package com.ist.kafka.consumer.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.ist.kafka.consumer.common.CodeConstant;
import com.ist.kafka.consumer.common.ResultConstant;
import com.ist.kafka.consumer.common.pojo.ResultVO;
import com.ist.kafka.consumer.common.util.*;
import com.ist.kafka.consumer.config.IstConfig;
import com.ist.kafka.consumer.config.IstEnum;
import com.ist.kafka.consumer.config.MessageEnum;
import com.ist.kafka.consumer.config.kafka.MsgData;
import com.ist.kafka.consumer.dao.MsgMapper;
import com.ist.kafka.consumer.dao.UserFriendMapper;
import com.ist.kafka.consumer.domain.Msg;
import com.ist.kafka.consumer.domain.MsgExample;
import com.ist.kafka.consumer.domain.UserFriend;
import com.ist.kafka.consumer.push.PushApi;
import com.ist.kafka.consumer.service.ChatService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.websocket.Session;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service(value = "chatService")
public class ChatServiceImpl extends BaseServiceImpl implements ChatService, ApplicationContextAware {
    private static KafkaTemplate kafkaTemplate;
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    public static Map<String, Session> drWebSocketSet = new ConcurrentHashMap<>(); //医生web
    @Autowired
    private MsgMapper msgMapper;
    @Autowired
    private UserFriendMapper userFriendMapper;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private IstConfig istConfig;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private PushApi pushApi;

    @Override
    public List<MsgData> queryByParams(Map<String, Object> params) {
        MsgExample example = new MsgExample();
        example.createCriteria().andReceiverIdEqualTo(Long.parseLong(params.get("receiverId").toString())).andStatusEqualTo((short)-1)
        .andTimeidGreaterThan(Long.parseLong(params.get("timeId").toString()));
        List<Msg> msgs = msgMapper.selectByExample(example);
        List<MsgData> msgDataList = new ArrayList<>();
        for (Msg msg:msgs){
            MsgData msgData = new MsgData();
            msgData.setContent(msg.getContent());
            msgData.setContentType(msg.getContenttype().intValue());
            msgData.setCreateTime(DateUtil.getString(msg.getCreatetime(), DateUtil.PATTERN_DATE_TIME));
            msgData.setMsgType(msg.getMsgtype().intValue());
            msgData.setNo(msg.getNo().toString());
            msgData.setSender(msg.getSender().toString());
            msgData.setShopId(msg.getShopid()==null?"":msg.getShopid().toString());
            msgData.setTalker(msg.getTalker().toString());
            msgData.setStatus(msg.getStatus().intValue());
            msgData.setTimeId(msg.getTimeid().toString());
            msgDataList.add(msgData);
        }
        return msgDataList;
    }

    @Override
    public int updateByParams(Map<String, Object> params) {
        return msgMapper.updateByParams(params);
    }

    @Override
    public void updateByMsgId(long timeId,short status) {
        Msg updateMsg = new Msg();
        updateMsg.setStatus(status);
        MsgExample example = new MsgExample();
        example.createCriteria().andTimeidEqualTo(timeId);
        msgMapper.updateByExampleSelective(updateMsg,example);
    }

    @Override
    public void saveSocketMsg(Msg msg) {
        msgMapper.insertSelective(msg);
    }

    @Override
    public void saveUserFriend(UserFriend userFriend) {
        userFriendMapper.insertSelective(userFriend);
    }

    private JSONObject getJsonObjectStatusRespBack(JSONObject jsonObject,long timeId) {
        long sender = jsonObject.getLong("sender")==null?0:jsonObject.getLong("sender");
        long talker = jsonObject.getLong("talker")==null?0:jsonObject.getLong("talker");
        long no = jsonObject.getLong("no")==null?0:jsonObject.getLong("no");
        JSONObject jsonObjectStatus  = new JSONObject();
        jsonObjectStatus.put("sender",sender);
        jsonObjectStatus.put("talker",talker);
        jsonObjectStatus.put("no",no);
        jsonObjectStatus.put("type",jsonObject.getIntValue("type"));
        jsonObjectStatus.put("status",99);//收到正常反馈
        jsonObjectStatus.put("timeId",timeId);
        return jsonObjectStatus;
    }

    @Override
    @Async("asyncServiceExecutor")
    public void dealOnMessage(String message, Session session){
        try {
            sendMessage(message); //基本消息
        }catch (Exception e){
            logger.info("dealOnMessage.err:",e);
        }
    }


    /**
     * 发送消息
     *
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message)  {
        logger.info("receive message send before:" + message);
        System.out.println("receive message send before:" + message);
        if (StringUtils.isNotBlank(message)) {
            if(message.substring(15,26).equals("\"type\":\"01\"")){
                long timeId = System.currentTimeMillis();
                int len = Integer.valueOf(message.substring(34,38));
//                if(message.substring(40,54).equals("\"receiverId\":[") && message.substring((54+13*(len-1))+12,(54+13*(len-1))+12+1).equals("]")){
                    for(int j=0;j<len;j++){
                        String receiverId = message.substring(55+15*j,(55+15*j)+12);
                        String sendMessageUrl = (String) redisUtil.get(RedisKeyUtil.getUIDWebSocketURL(receiverId));
                        boolean isPush = false;
                        if (StringUtils.isNotBlank(sendMessageUrl)) {
                            try {
                                long s = System.currentTimeMillis();
//                                String result = HttpClientUtil.doPost(sendMessageUrl + "sendMessage/", message,receiverId);
                                Map<String,String> params  = new HashMap<>();
                                params.put("message",message);
                                params.put("receiverId",receiverId);
                                JsonObject resultJson = HttpConnectionPoolUtil.post(sendMessageUrl + "sendMessage/", params);
                                logger.info("sendMessage to "+receiverId+ " resp==>"+resultJson.toString());
                                if (resultJson.get("code").getAsInt()!=200){
                                    //插入离线消息
                                    insertOfflineMsg(message, receiverId);
                                    isPush = true;
                                    logger.info("offine:" + receiverId);
                                }
                            }catch (Exception e){
                                logger.error("sendMessage",e);
                            }
                        } else {
                            isPush = true;
                            logger.info("offine:" + receiverId);
                            //插入离线消息
                            insertOfflineMsg(message, receiverId);
                        }
                        if (isPush){
                            //推送服务
                            //调svc服务获取cid
                            pushApiContent(message, receiverId);
                        }
                    }
//                }else{
//                    logger.warn("format err:" + message);
//                }
            }else{
                JSONObject jsonObject = JSONObject.parseObject(message);
                try {
                    JSONArray receiverIdArray = jsonObject.getJSONArray("receiverId"); //接受者ID
                    if (receiverIdArray == null || receiverIdArray.size() == 0) {
                        logger.warn("sendMessage message:" + jsonObject.toJSONString() + ",is no receiverId");
                    } else {
                        boolean isPush = false;
                        for (int i = 0; i < receiverIdArray.size(); i++) {
                            String receiverId = receiverIdArray.getString(i);
                            if ("null".equals(receiverIdArray.get(i))){
                                continue;
                            }
                            String sendMessageUrl = (String) redisUtil.get(RedisKeyUtil.getUIDWebSocketURL(receiverId));
                            if (StringUtils.isNotBlank(sendMessageUrl)){
                                String result = HttpClientUtil.doPost(sendMessageUrl + "sendMessage/", message, receiverId);
                                logger.info("sendMessage to " + receiverId + " resp==>" + result);
                                JSONObject jsonObject1 = JSONObject.parseObject(result);
                                if (jsonObject1.getInteger("code")!=200){
                                    //插入离线消息
                                    insertOfflineMsg(message, receiverId);
                                    isPush = true;
                                }
                            }else{
                                isPush = true;
                                try {
                                    getMsgFromJson(jsonObject,MessageEnum.MsgStatus.NOT_DELIVERY.getStatus(),receiverId);
                                } catch (Exception e) {
                                    logger.error("insert offline err:",e);
                                }
                            }
                            if (isPush){
                                //推送服务
                                //调svc服务获取cid
                                pushApiContent(message, receiverId);
                            }
                        }
                    }
                } catch (Exception e) {
                    logger.error("sendMessage.error:", e);
                    System.out.println(e);
                }
            }
        }
    }

    public void pushApiContent(String message, String receiverId) {
        try {
            JSONObject jsonObject2 = new JSONObject();
            jsonObject2.put("userId", receiverId);
            ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(istConfig.getIstSvcUrl() + CodeConstant.IstSvc.USER_QUERY_CLIENT_ID, jsonObject2, String.class);
            String body = stringResponseEntity.getBody();
            JSONObject bodyJsonObject = JSONObject.parseObject(body);
            if (ResultConstant.SUCCESS_CODE.equals(bodyJsonObject.getString("code")) && StringUtils.isNotBlank(bodyJsonObject.getString("data"))) {
                String clientId = bodyJsonObject.getString("data");
                if (pushApi!=null){
                    pushApi.push(clientId, 1, message,receiverId);
                }else {
                    logger.warn("pushApi is null,receiveId:" + receiverId);
                }
            }else{
                logger.warn("");
            }
        }catch (Exception e){
            logger.warn("pushApiContent.err:",e);
        }

    }

    @Async("asyncServiceExecutor")
    public void insertOfflineMsg(String message, String receiverId) {
        JSONObject jsonObject = JSONObject.parseObject(message);
        try {
            getMsgFromJson(jsonObject, MessageEnum.MsgStatus.NOT_DELIVERY.getStatus(), receiverId);
        } catch (Exception e) {
            logger.error("insert offline err:", e);
        }
    }

    private void getMsgFromJson(JSONObject jsonObject,short status,String receiverId) throws Exception {
        //IsInsertMsgSwitch开关打开全部插入消息 否则只插入离线消息
        if ("1".equals(istConfig.getIsInsertMsgSwitch()) || (!"1".equals(istConfig.getIsInsertMsgSwitch()) && status==MessageEnum.MsgStatus.NOT_DELIVERY.getStatus())){
            //新增msg
            Date now = new Date();
            Msg msg = new Msg();
            msg.setType(jsonObject.getShort("type"));
            msg.setContent(jsonObject.getString("content"));
            Short msgType = jsonObject.getShort("msgType");
            msg.setMsgtype(msgType);
            msg.setReceiverId(receiverId);
            msg.setContenttype(jsonObject.getShort("contentType"));
            msg.setSender(jsonObject.getLong("sender"));
            msg.setTalker(jsonObject.getLong("talker")==null?0:jsonObject.getLong("talker"));
            msg.setCreatetime(now);
            msg.setUpdatetime(now);
            msg.setStatus(status);
            msg.setNo(jsonObject.getLong("no"));
            msg.setTimeid(jsonObject.getLong("timeId"));
            this.saveSocketMsg(msg);
        }

        //1好友请求通过
        if (jsonObject.getShort("type")==4 && jsonObject.getShort("status")!=null && jsonObject.getShort("status")==1){
            UserFriend userFriend = new UserFriend();
            userFriend.setUserid(jsonObject.getLong("receiverId"));
            userFriend.setFuserid(jsonObject.getLong("sender"));
            userFriend.setGrouptype(IstEnum.GroupType.OTHER.getCode());
            userFriend.setFriendgroupid(0L);
            userFriend.setCreatetime(new Date());
            userFriend.setUpdatetime(new Date());
            this.saveUserFriend(userFriend);

            UserFriend userFriend1 = new UserFriend();
            userFriend1.setUserid(jsonObject.getLong("sender"));
            userFriend1.setFuserid(jsonObject.getLong("receiverId"));
            userFriend1.setGrouptype(IstEnum.GroupType.OTHER.getCode());
            userFriend1.setFriendgroupid(0L);
            userFriend1.setCreatetime(new Date());
            userFriend1.setUpdatetime(new Date());
            this.saveUserFriend(userFriend1);
        }
        //5加入组
        else if(jsonObject.getShort("type")==5 && jsonObject.getShort("status")!=null && jsonObject.getShort("status")==1){


        }
        jsonObject.put("receiverId",receiverId);
    }

    /**
     * 消息状态通知
     *
     * @param message
     * @param session
     * @param timeId
     * @throws IOException
     */
    public void statusNotify(String message, Session session)  {
        if (StringUtils.isNotBlank(message)) {
            JSONObject jsonObject = JSONObject.parseObject(message);

            JSONArray receiverIdArray = jsonObject.getJSONArray("receiverId"); //接受者ID
            if (receiverIdArray==null||receiverIdArray.size()==0){
                logger.warn("sendMessage message:" + message + ",is no receiverId");
            }else{
                for (int j = 0;j<receiverIdArray.size();j++){
                    try {
                        String receiverId = receiverIdArray.get(j).toString();
                        JSONArray data = jsonObject.getJSONArray("data");
                        for (int i=0;i<data.size();i++){
                            JSONObject  jsonObjectData = data.getJSONObject(i);
                            this.updateByMsgId(jsonObjectData.getLong("timeId"),jsonObjectData.getShort("status"));
                        }
                        Session sessionTo = drWebSocketSet.get(receiverId);
                        if (null!=sessionTo){
                            sessionTo.getAsyncRemote().sendText(data.toJSONString());
                        }else {
                            //判断缓存
                            String sendMessageUrl = (String) redisUtil.get(RedisKeyUtil.getUIDWebSocketURL(receiverId));
                            //sendMessageUrl = "http://127.0.0.1:8010/ist_im/sendMessage";
                            if (StringUtils.isNoneBlank(sendMessageUrl)){
                                ResultVO resultVO = restTemplate.postForObject(sendMessageUrl + "sendMessage", data.toJSONString(), ResultVO.class);
                                logger.info("statusNotify" + resultVO.toString());
                            }
                        }
                    }catch (Exception e){
                        logger.error("statusNotify statusNotify.error:",e);
                    }
                }
            }
        }
    }

    public static int getOnlineCount() {
        return drWebSocketSet.size();
    }
    @Override
    public void closeSession(String userId) {
        try {
            if (ChatServiceImpl.drWebSocketSet.get(userId)!=null){
                ChatServiceImpl.drWebSocketSet.get(userId).close();
            }
        }catch (Exception e){
            logger.error("closeSession.error:",e);
        }
    }

//    @Override
//    public ResultVO urlReceiveMsg(String message) {
//        JSONObject jsonObject = JSONObject.parseObject(message);
//        try {
//            String receiver_id = jsonObject.getString("receiverId"); //接受者ID
//            if (ChatServiceImpl.drWebSocketSet.get(receiver_id) != null) {
//                JSONArray data = jsonObject.getJSONArray("data");
//                for (int i=0;i<data.size();i++){
//                    JSONObject  jsonObjectData = data.getJSONObject(i);
//                    long msgId = jsonObjectData.getLong("timeId");
//                    this.updateByMsgId(msgId,(short)0);
//                }
//                ChatServiceImpl.drWebSocketSet.get(receiver_id).getAsyncRemote().sendText(data.toJSONString()); //进行消息发送
//            }
//            else{
//                logger.warn("urlReceiveMsg " + jsonObject + "不存在");
//                return new ResultVO(ResultConstant.SOCKET_USER_NOT_EXIST_CURRENT_NODE_CODE,ResultConstant.SOCKET_USER_NOT_EXIST_CURRENT_NODE_MSG);
//            }
//        }catch (Exception e){
//            logger.error("urlReceiveMsg.error:",e);
//            return new ResultVO(ResultConstant.APP_ERROR_CODE,ResultConstant.APP_ERROR_MSG);
//        }
//        return new ResultVO();
//    }

    @Override
    public void kafkaReceiveMsg(String message) {
        JSONObject jsonObject = JSONObject.parseObject(message);
        try {
            String receiver_id = jsonObject.getString("receiverId"); //接受者ID
            if (drWebSocketSet.get(receiver_id) != null) {
                JSONArray data = jsonObject.getJSONArray("data");
                for (int i=0;i<data.size();i++){
                    JSONObject  jsonObjectData = data.getJSONObject(i);
                    long msgId = jsonObjectData.getLong("timeId");
                    this.updateByMsgId(msgId,(short) 0);
                }
                drWebSocketSet.get(receiver_id).getAsyncRemote().sendText(data.toJSONString()); //进行消息发送
            }
            else{
                logger.warn(jsonObject + "不存在");
            }
        }catch (Exception e){
            logger.error("kafkaReceiveMsg.error:",e);
        }
    }

    @Override
    public void kafkaCloseWebsocket(String closeMessage) {
        JSONObject jsonObject = JSONObject.parseObject(closeMessage);
        String userId = jsonObject.getString("userId");
        Session removeSession = drWebSocketSet.remove(userId);
        if (null!=removeSession){
//            Session removeSession = ChatServiceImpl.drWebSocketSet.remove(userId);
            //从set中删除
//            subOnlineCount();
            logger.info("用户退出:"+userId+",当前在线人数为drWebSocketSet:" + getOnlineCount() + ",getOpenSessions:" + removeSession.getOpenSessions().size());
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (kafkaTemplate == null) {
            kafkaTemplate = applicationContext.getBean(KafkaTemplate.class); //获取kafka的Bean实例
        }
    }

    public static void main(String[] args) {
        String message = "{\"status\":\"10\",\"type\":\"05\",\"receiverId\":[\"200000026825\"],\"sender\":\"200000000101\",\"no\":1603010062333,\"talker\":\"123\",\"contentType\":1,\"content\":{\"text\":{\"joinChannel\":1,\"inviter\":\"200000000101\",\"invitees\":[\"200000026825\"],\"note\":\"\",\"nickNames\":[\"13111111110\"],\"avatarUrls\":[\"http://47.92.227.241/msg/missing-face.png\"]}},\"timeId\":1603010062333,\"msgType\":2}";
        ChatServiceImpl chatService = new ChatServiceImpl();
        chatService.sendMessage(message);
    }

}
