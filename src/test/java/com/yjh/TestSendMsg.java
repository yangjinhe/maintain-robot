package com.yjh;

import com.yjh.util.CqpHttpApi;
import com.yjh.vo.CqpHttpApiResp;
import org.junit.Test;

public class TestSendMsg {

    @Test
    public void testCqpSendPrivateMsg() {
        CqpHttpApiResp xx = CqpHttpApi.getInstance().sendPrivateMsg(1846253361, "[CQ:music,type=163,id=590438]");
        //CqpHttpApiResp xx = CqpHttpApi.sendPrivateMsg(1846253361, "[CQ:shake]");
        System.out.println(xx.getRetcode());
        System.out.println(xx.getStatus());
    }
}
