package org.hongxi.whatsmars.mq.rocketmq.spring.demo;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;

public class Consumer {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("spring/rocketmq-consumer.xml");
    }
}
