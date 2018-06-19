package com.yjh.util;

import com.yjh.module.WebSocketModule;
import com.yjh.vo.CqpHttpApiResp;
import org.nutz.lang.util.NutMap;

import javax.websocket.Session;
import java.io.IOException;
import java.util.Map;

/**
 * @Description
 * @ProjectName maintain-robot
 * @Package com.yjh.util
 * @Author yangjh5
 * @CreateDate 2017/12/2
 */
public class CqpWebsocketApi extends AbstractCqpApi {

    private static CqpWebsocketApi instance = new CqpWebsocketApi();

    private CqpWebsocketApi(){}

    public static CqpWebsocketApi getInstance() {
        return instance;
    }

    @Override
    public CqpHttpApiResp sendPrivateMsg(long qq, String message) {
        sendMsg(buildPrivateMsg(qq, message));
        return null;
    }

    @Override
    public CqpHttpApiResp sendGroupMsg(long groupId, String message) {
        sendMsg(buildGroupMsg(groupId, message));
        return null;
    }

    @Override
    public CqpHttpApiResp sendDisCussMsg(long groupId, String message) {
        sendMsg(buildDisCussMsg(groupId, message));
        return null;
    }

    private static void sendMsg(Map msg) {
        Session session = WebSocketModule.sessionMap.get(WebSocketModule.CQP_USER);
        if (null != session) {
            try {
                session.getBasicRemote().sendText(JsonUtils.toJson(msg));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
