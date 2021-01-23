package com.ist.kafka.consumer.service;

import com.ist.kafka.consumer.config.kafka.MsgData;
import com.ist.kafka.consumer.domain.Msg;
import com.ist.kafka.consumer.domain.UserFriend;

import javax.websocket.Session;
import java.util.List;
import java.util.Map;

public interface ChatService {

    List<MsgData> queryByParams(Map<String, Object> params);

    int updateByParams(Map<String, Object> params);

    void updateByMsgId(long msgId, short status);

    void saveSocketMsg(Msg msg);

    void saveUserFriend(UserFriend userFriend);

    void dealOnMessage(String message, Session session);

    void closeSession(String userId);

//    ResultVO urlReceiveMsg(String message);

    void kafkaReceiveMsg(String message);

    void kafkaCloseWebsocket(String closeMessage);


}
