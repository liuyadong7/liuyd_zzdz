package com.lyd.subscription;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * <p> 订阅发布者 </p>
 *
 * @author LiuYaDong
 * @since 2021-03-19 21:56
 **/
public class ChatRelease extends Thread {

    private final JedisPool jedisPool;
    private String mess;
    private String channel;

    public ChatRelease(JedisPool jedisPool, String mess, String channel) {
        this.jedisPool = jedisPool;
        this.mess = mess;
        this.channel = channel;
    }

    @Override
    public void run() {
        Jedis jedis = jedisPool.getResource();   //连接池中取出一个连接
        jedis.publish(channel, mess);   //从 channel 的频道上推送消息
    }
}