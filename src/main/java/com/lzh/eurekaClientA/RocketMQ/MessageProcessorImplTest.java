package com.lzh.eurekaClientA.RocketMQ;


import org.springframework.stereotype.Component;

import com.alibaba.rocketmq.common.message.MessageExt;

@Component
public class MessageProcessorImplTest implements MyMessageProcessor {
    @Override
    public boolean handleMessage(MessageExt messageExt) {
		System.out.println("receive+++++++++++++++++ : " + new String(messageExt.getBody()));
        System.out.println("receive : " + messageExt.toString());
        return true;
    }
}