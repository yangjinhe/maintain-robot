package com.yjh.module;

import com.xiaoleilu.hutool.lang.Singleton;
import com.yjh.actuator.BaseActuator;
import com.yjh.actuator.RedisActuator;
import com.yjh.util.MessageActuatorEnum;
import com.yjh.util.MyUtil;
import com.yjh.vo.CqpPostMsg;
import com.yjh.vo.CqpRespDiscussMsg;
import com.yjh.vo.CqpRespGroupMsg;
import com.yjh.vo.CqpRespPrivMsg;
import com.yjh.vo.MsgBody;
import lombok.extern.slf4j.Slf4j;
import org.nutz.mvc.adaptor.JsonAdaptor;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Description
 * @ProjectName maintain-robot
 * @Package com.yjh.module
 * @Author yangjh5
 * @CreateDate 2017/11/30
 */
@Slf4j
@At("/robot")
public class RobotModule {

    @At("/acceptBin")
    public Object acceptBin(HttpServletRequest request) throws IOException {
        String s = MyUtil.binaryReader(request);
        log.info(s);
        return s;
    }

    @At("/accept")
    @AdaptBy(type=JsonAdaptor.class)
    public Object accept(CqpPostMsg cqpPostMsg) throws IOException {
        if (cqpPostMsg.getMessage().startsWith("#")) {
            switch (cqpPostMsg.getPost_type()) {
                case "message":
                    return processMessage(cqpPostMsg);
                case "event":
                    break;
                case "request":
                    break;
            }
        }
        return "";
    }

    private Object processMessage(CqpPostMsg cqpPostMsg) {
        MsgBody msgBody = cqpPostMsg.getMessageBody();
        switch (cqpPostMsg.getMessage_type()) {
            case "private":
                CqpRespPrivMsg privMsg = new CqpRespPrivMsg();
                BaseActuator actuator = MyUtil.getClassByCmd(msgBody.getCommand());
                if (null != actuator) {
                    privMsg.setReply(actuator.run(msgBody.getBody()));
                } else {
                    privMsg.setReply(msgBody.getBody());
                }
                return privMsg;
            case "group":
                CqpRespGroupMsg groupMsg = new CqpRespGroupMsg();
                groupMsg.setReply(msgBody.getBody());
                return groupMsg;
            case "discuss":
                CqpRespDiscussMsg discussMsg = new CqpRespDiscussMsg();
                discussMsg.setReply(msgBody.getBody());
                return discussMsg;
            default:
                return "";
        }
    }
}
