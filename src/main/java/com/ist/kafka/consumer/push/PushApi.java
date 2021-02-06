package com.ist.kafka.consumer.push;

import com.getui.push.v2.sdk.ApiHelper;
import com.getui.push.v2.sdk.GtApiConfiguration;
import com.getui.push.v2.sdk.common.ApiResult;
import com.getui.push.v2.sdk.dto.req.Audience;
import com.getui.push.v2.sdk.dto.req.Settings;
import com.getui.push.v2.sdk.dto.req.Strategy;
import com.getui.push.v2.sdk.dto.req.message.PushChannel;
import com.getui.push.v2.sdk.dto.req.message.PushDTO;
import com.getui.push.v2.sdk.dto.req.message.PushMessage;
import com.getui.push.v2.sdk.dto.req.message.android.AndroidDTO;
import com.getui.push.v2.sdk.dto.req.message.android.GTNotification;
import com.getui.push.v2.sdk.dto.req.message.android.ThirdNotification;
import com.getui.push.v2.sdk.dto.req.message.android.Ups;
import com.getui.push.v2.sdk.dto.req.message.ios.Alert;
import com.getui.push.v2.sdk.dto.req.message.ios.Aps;
import com.getui.push.v2.sdk.dto.req.message.ios.IosDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: sunhaitao
 */
@Component
@Slf4j
public final class PushApi {
    private static String appId = "5UzMuftaok9yFYPJoomtL7";
    private static String appKey = "vuYEhK1nT2AUPh2cfP7fn3";
    private static String masterSecret = "INyDqfgMO99awPZk5njcx4";
    private static ApiHelper apiHelper = null;
    static {
        GtApiConfiguration apiConfiguration = new GtApiConfiguration();
        //填写应用配置
        apiConfiguration.setAppId(appId);
        apiConfiguration.setAppKey(appKey);
        apiConfiguration.setMasterSecret(masterSecret);
        // 接口调用前缀，请查看文档: 接口调用规范 -> 接口前缀, 可不填写appId
        apiConfiguration.setDomain("https://restapi.getui.com/v2/");
        // 实例化ApiHelper对象，用于创建接口对象
        apiHelper = ApiHelper.build(apiConfiguration);
    }
    public void push(String clientId,Integer num) {

        // 创建对象，建议复用。目前有PushApi、StatisticApi、UserApi
        com.getui.push.v2.sdk.api.PushApi pushApi = apiHelper.creatApi(com.getui.push.v2.sdk.api.PushApi.class);

        //根据cid进行单推
        PushDTO<Audience> pushDTO = new PushDTO<Audience>();
        // 设置推送参数
        pushDTO.setRequestId(System.currentTimeMillis() + "");
        Settings settings = new Settings();
        Strategy strategy = new Strategy();
        strategy.setDef(4);
        settings.setStrategy(strategy);
        pushDTO.setSettings(settings);
        String title = "消息";
        String body = "来消息啦";
        //厂商推送消息参数
        IosDTO iosDTO = new IosDTO();
        Aps aps = new Aps();
        aps.setSound("pushsound.caf");
        aps.setContentAvailable(0);
        Alert alert = new Alert();
        alert.setTitle(title);
        alert.setBody(body);
        aps.setAlert(alert);
        iosDTO.setAps(aps);
        iosDTO.setType("notify");
        iosDTO.setAutoBadge("+"+num);
        AndroidDTO androidDTO = new AndroidDTO();
        PushChannel pushChannel = new PushChannel();
        pushDTO.setPushChannel(pushChannel);
        pushChannel.setAndroid(androidDTO);
        pushChannel.setIos(iosDTO);
        Ups ups = new Ups();
        androidDTO.setUps(ups);
        ThirdNotification thirdNotification = new ThirdNotification();
        ups.setNotification(thirdNotification);
        thirdNotification.setTitle(title);
        thirdNotification.setBody(body);
        thirdNotification.setClickType("startapp");
        thirdNotification.setIntent("intent:#Intent;action=android.intent.action.oppopush;launchFlags=0x14000000;component=com.brofarm.app/io.dcloud.PandoraEntry;S.UP-OL-SU=true;S.title=消息;S.content=来消息啦;S.payload=test;end");
        thirdNotification.setPayload("{\"title\":\"消息\"}");
        Map<String, Map<String, Object>> options = new HashMap<>();
        Map<String, Object> all = new HashMap<>();
        all.put("key","value");
        Map<String, Object> HW = new HashMap<>();
        HW.put("/message/android/notification/badge/class","io.dcloud.PandoraEntry");
        HW.put("/message/android/notification/badge/add_num",num);
//        HW.put("/message/android/notification/badge/set_num",2);
        options.put("ALL",all);
        options.put("HW",HW);
        ups.setOptions(options);
        //个推 格式
        PushMessage pushMessage = new PushMessage();
        pushDTO.setPushMessage(pushMessage);
//        pushMessage.setTransmission("sss");
        GTNotification notification = new GTNotification();
        pushMessage.setNotification(notification);
        notification.setTitle("test");
        notification.setBody("来消息啦");
        notification.setClickType("startapp");
        notification.setUrl("https://www.getui.com");
        notification.setBadgeAddNum("2");
        // 设置接收人信息
        Audience audience = new Audience();
        pushDTO.setAudience(audience);
        audience.addCid(clientId);

        // 进行cid单推
        ApiResult<Map<String, Map<String, String>>> apiResult = pushApi.pushToSingleByCid(pushDTO);
        if (apiResult.isSuccess()) {
            log.info("clientId:{},result:{}",clientId,apiResult.getData());
            System.out.println();
        } else {
            log.info("code:" + apiResult.getCode() + ", msg: " + apiResult.getMsg());
        }
    }
}
