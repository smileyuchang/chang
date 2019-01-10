package io.renren.test.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class Receiver {

    protected static final Logger log = LoggerFactory.getLogger(Receiver.class);

    // queues是指要监听的队列的名字
    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receiverDirectQueue(User user) {
        log.info("【receiverDirectQueue监听到消息】" + user.toString());
    }

    // queues是指要监听的队列的名字
    @RabbitListener(queues = RabbitMQConfig.TOPIC_QUEUE1)
    public void receiveTopic1(User user) {
        log.info("【receiveTopic1监听到消息】" + user.toString());
    }
    @RabbitListener(queues = RabbitMQConfig.TOPIC_QUEUE2)
    public void receiveTopic2(User user) {
        log.info("【receiveTopic2监听到消息】" + user.toString());
    }



}