package com.chang.test.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
	
	protected static final Logger log = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendDirectQueue() {
        User user = new User();
        user.setUserId("世界的看法就是的");
        user.setName("想，支持，下周末，这些吗吗存在每次v");
        log.info("【sendDirectQueue已发送消息】");
         // 第一个参数是指要发送到哪个队列里面， 第二个参数是指要发送的内容
        //this.amqpTemplate.convertAndSend(RabbitMQConfig.QUEUE, user);
        this.amqpTemplate.convertAndSend( RabbitMQConfig.QUEUE,user,message -> {
            message.getMessageProperties().setExpiration( 1000 * 60 + "");
            return message;
        });
    }

    public void sendTopic() {
        User user1 = new User();
        user1.setUserId("123456");
        user1.setName("lizhencheng");

        User user2 = new User();
        user2.setUserId("456789");
        user2.setName("张三");

        log.info("【sendTopic已发送消息】");
        // 第一个参数：TopicExchange名字
        // 第二个参数：Route-Key
        // 第三个参数：要发送的内容
        this.amqpTemplate.convertAndSend(RabbitMQConfig.TOPIC_EXCHANGE, "lzc.message", user1 );
        this.amqpTemplate.convertAndSend(RabbitMQConfig.TOPIC_EXCHANGE, "lzc.lzc", user2);
    }

    public void sendFanout() {
        User user = new User();
        user.setUserId("123456");
        user.setName("lizhencheng");
        log.info("【sendFanout已发送消息】");
        // 注意， 这里的第2个参数为空。
        // 因为fanout 交换器不处理路由键，只是简单的将队列绑定到交换器上，
        // 每个发送到交换器的消息都会被转发到与该交换器绑定的所有队列上
        //this.amqpTemplate.convertAndSend(RabbitMQConfig.FANOUT_EXCHANGE, "", user );
        this.amqpTemplate.convertAndSend( RabbitMQConfig.FANOUT_EXCHANGE,user,message -> {
            message.getMessageProperties().setExpiration( 1000 * 60 + "");
            return message;
        });
    }

    public void sendDelay() {

    }

}
