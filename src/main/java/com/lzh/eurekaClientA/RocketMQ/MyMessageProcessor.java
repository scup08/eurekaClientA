package com.lzh.eurekaClientA.RocketMQ;

import com.alibaba.rocketmq.common.message.MessageExt;

public interface MyMessageProcessor {
    /**
     * 处理消息的接口
     * @param messageExt
     * @return
     */
    public boolean handleMessage(MessageExt messageExt);
}