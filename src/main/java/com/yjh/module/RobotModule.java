package com.yjh.module;

import com.yjh.util.MyUtil;
import com.yjh.vo.CqpPostMsg;
import com.yjh.vo.CqpRespDiscussMsg;
import com.yjh.vo.CqpRespGroupMsg;
import com.yjh.vo.CqpRespPrivMsg;
import lombok.extern.slf4j.Slf4j;
import org.nutz.mvc.adaptor.JsonAdaptor;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

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
        String message = cqpPostMsg.getMessage();
        switch (cqpPostMsg.getMessage_type()) {
            case "private":
                CqpRespPrivMsg privMsg = new CqpRespPrivMsg();
                privMsg.setReply(message);
                return privMsg;
            case "group":
                CqpRespGroupMsg groupMsg = new CqpRespGroupMsg();
                groupMsg.setReply(message);
                return groupMsg;
            case "discuss":
                CqpRespDiscussMsg discussMsg = new CqpRespDiscussMsg();
                discussMsg.setReply(message);
                return discussMsg;
            default:
                return "";
        }
    }
}
