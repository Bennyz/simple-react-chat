package io.benny.chat.data;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by benny on 9/13/16.
 */
public class RedisConnection {
    private JedisPool jedisPool;

    public RedisConnection(String host, int port) {
        jedisPool = new JedisPool(host, port);
    }

    public Jedis getConnection() {
        return jedisPool.getResource();
    }
}
