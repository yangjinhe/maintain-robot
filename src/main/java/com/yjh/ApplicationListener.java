package com.yjh;

import lombok.extern.slf4j.Slf4j;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@Slf4j
@WebListener
public class ApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        log.info("初始化监听器");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log.info("销毁监听器");
        System.exit(0);
    }
}
