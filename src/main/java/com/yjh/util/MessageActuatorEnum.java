package com.yjh.util;

import com.yjh.actuator.*;

/**
 * @auth yangjh on 2018-06-18.
 */
public enum MessageActuatorEnum {
    REDIS("#redis", "com.yjh.actuator.RedisActuator");

    private String command;
    private String classz;

    MessageActuatorEnum(String command, String classz) {
        this.command = command;
        this.classz = classz;
    }

    public static MessageActuatorEnum getClasszByCmd(String cmd) {
        for (MessageActuatorEnum anEnum : MessageActuatorEnum.values()) {
            if (cmd.equals(anEnum.command)) {
                return anEnum;
            }
        }
        return null;
    }

    public String getCommand() {
        return command;
    }

    public String getClassz() {
        return classz;
    }
}
