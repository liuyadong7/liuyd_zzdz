package com.lyd.subscription.controller;

import com.lyd.subscription.ChatRelease;
import com.lyd.subscription.ChatSubscriber;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * <p>  </p>
 *
 * @author LiuYaDong
 * @since 2021-03-19 22:03
 **/
@RestController
@RequestMapping("/user")
public class ChatController {

    /**
     * 发布消息
     * @param mess
     * @param channel
     * @return
     */
    @RequestMapping("/release")
    @ResponseBody
    public String release(String mess,String channel) {
        // 连接redis服务端
        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), "127.0.0.1", 6379);
        ChatRelease chatRelease = new ChatRelease(jedisPool, mess, channel);
        chatRelease.start();
        return "success";
    }

    /**
     * 订阅频道
     * @param channel
     * @return
     */
    @RequestMapping("/subscribe")
    @ResponseBody
    public String subscribe(String channel) {
        // 连接redis服务端
        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), "127.0.0.1", 6379);
        new Thread(new ChatSubscriber(jedisPool,channel)).start();
        return "success";
    }

}
