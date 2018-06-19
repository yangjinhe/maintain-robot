package com.yjh.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @auth yangjh on 2018-06-18.
 */
public class RedisPool {

    private static RedisPool ourInstance = new RedisPool();

    public static RedisPool getInstance() {
        return ourInstance;
    }

    private JedisPool pool;

    private RedisPool() {
        pool = new JedisPool(new JedisPoolConfig(), "127.0.0.1", 6379, 3000, "123456", 0, null);
    }

    public Jedis getJedis() {
        return pool.getResource();
    }
}
