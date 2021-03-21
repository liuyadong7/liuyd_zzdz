package com.lyd.subscription;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

/**
 * <p> 建立订阅者及订阅频道 </p>
 *
 * @author LiuYaDong
 * @since 2021-03-19 21:58
 **/
public class ChatSubscriber extends JedisPubSub implements Runnable {

    private JedisPool jedisPool;
    private String channel;

    public ChatSubscriber(JedisPool jedisPool, String channel) {
        this.jedisPool = jedisPool;
        this.channel = channel;
    }

    @Override
    public void onMessage(String channel, String message) {       //收到消息会调用
        System.out.println("收到来自频道" + channel + "的消息：" + message);
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {    //订阅了频道会调用
        System.out.println("订阅了频道：" + channel);
    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {   //取消订阅 会调用
        System.out.println("取消订阅频道：" + channel);

    }

    @Override
    public void run() {
        System.out.println();
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();   //取出一个连接
            jedis.subscribe(this, channel);    //通过subscribe 的api去订阅，入参是订阅者和频道名
        } catch (Exception e) {
            System.out.println(String.format("error, %s", e));
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

}