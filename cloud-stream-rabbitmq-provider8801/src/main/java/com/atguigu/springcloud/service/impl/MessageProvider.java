package com.atguigu.springcloud.service.impl;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import com.atguigu.springcloud.service.IMessageProvider;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * TODO:
 *
 * @author Zhang Hao yu
 * @date 2021/02/19 18:35
 */
@EnableBinding(Source.class) //定义消息的推送管道
public class MessageProvider implements IMessageProvider {

    @Resource
    private MessageChannel output;
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("==========serial: "+serial);
        return serial;
    }
}
