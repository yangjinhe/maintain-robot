package com.yjh.job;

import com.yjh.util.CqpWebsocketApi;
import lombok.extern.slf4j.Slf4j;
import org.nutz.ioc.loader.annotation.IocBean;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Description
 * @ProjectName maintain-robot
 * @Package com.yjh.job
 * @Author yangjh5
 * @CreateDate 2017/12/1
 */
@Slf4j
@IocBean
public class TestJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //CqpWebsocketApi.getInstance().sendPrivateMsg(1846253361, "定时消息");
    }
}
