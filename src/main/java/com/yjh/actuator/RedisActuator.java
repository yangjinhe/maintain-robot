package com.yjh.actuator;

import com.yjh.util.RedisPool;
import redis.clients.jedis.Jedis;

/**
 * @auth yangjh on 2018-06-18.
 */
public class RedisActuator extends BaseActuator {

    public String run(String msg) {
        String ret = "";
        try (Jedis jedis = RedisPool.getInstance().getJedis()) {
            String[] msgs = msg.split("\\s");
            switch (msgs[0]) {
                case "sadd":
                    ret += jedis.sadd(msgs[1], msgs[2]);
                    break;
                case "smembers":
                    ret += jedis.smembers(msgs[1]);
                    break;
                case "del":
                    ret += jedis.del(msgs[1]);
                    break;
                case "set":
                    ret += jedis.set(msgs[1], msgs[2]);
                    break;
                case "get":
                    ret += jedis.get(msgs[1]);
                    break;


            }
        } catch (Exception e) {
            ret += e.getMessage();
        }
        return ret;
    }
}
