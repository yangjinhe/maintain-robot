package com.yjh.util;

import com.yjh.vo.CqpHttpApiResp;
import org.nutz.lang.util.NutMap;

import java.util.Map;

/**
 * @auth yangjh on 2018-06-18.
 */
public abstract class AbstractCqpApi implements CqpApi {
    @Override
    public CqpHttpApiResp sendPrivateMsg(long qq, String message) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CqpHttpApiResp sendGroupMsg(long groupId, String message) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CqpHttpApiResp sendDisCussMsg(long groupId, String message) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CqpHttpApiResp deleteMsg(long messageId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CqpHttpApiResp sendLike(long qq, long times) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CqpHttpApiResp setGroupKick(long qq, long groupId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CqpHttpApiResp setGroupBan(long qq, long groupId, long duration) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CqpHttpApiResp setGroupAnonymousBan(String flag, long groupId, long duration) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CqpHttpApiResp setGroupWholeBan(long groupId, boolean enable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CqpHttpApiResp setGroupAdmin(long groupId, long qq, boolean enable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CqpHttpApiResp getGroupList() {
        throw new UnsupportedOperationException();
    }

    @Override
    public CqpHttpApiResp getGroupMemberInfo(long groupId, long qq) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CqpHttpApiResp getGroupMemberList(long groupId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CqpHttpApiResp getVersionInfo() {
        throw new UnsupportedOperationException();
    }

    @Override
    public CqpHttpApiResp setRestart() {
        throw new UnsupportedOperationException();
    }

    @Override
    public CqpHttpApiResp setRestartPlugin() {
        throw new UnsupportedOperationException();
    }

    Map<String, Object> buildPrivateMsg(Object qq, Object message) {
        return new NutMap("action", SEND_PRIVATE_MSG)
                .setv("params", new NutMap("user_id", qq)
                        .setv("message", message)
                );
    }

    Map<String, Object> buildGroupMsg(Object groupId, Object message) {
        return new NutMap("action", SEND_GROUP_MSG)
                .setv("params", new NutMap("group_id", groupId)
                        .setv("message", message)
                );
    }

    Map<String, Object> buildDisCussMsg(Object groupId, Object message) {
        return new NutMap("action", SEND_DISCUSS_MSG)
                .setv("params", new NutMap("discuss_id", groupId)
                        .setv("message", message)
                );
    }
}
