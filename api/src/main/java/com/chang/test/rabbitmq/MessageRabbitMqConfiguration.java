package com.chang.test.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 消息通知 - 消息队列配置信息
 *
 * @author：恒宇少年 <br/>
 * ===============================
 * Created with IDEA.
 * Date：2018/3/3
 * Time：下午4:32
 * 简书：http://www.jianshu.com/u/092df3f77bca
 *  */

/*将message.center.create队列通过路由键message.center.create绑定到了message.center.direct交换上。
除此之外，我们还添加了消息通知延迟队列的Exchange、Queue、Binding等配置，将message.center.create.ttl队列通过message.center.create.ttl路由键绑定到了message.center.topic.ttl交换上。
我们仔细来看看messageTtlQueue延迟队列的配置，跟messageQueue队列配置不同的地方这里多出了x-dead-letter-exchange、x-dead-letter-routing-key两个参数，而这两个参数就是配置延迟队列过期后转发的Exchange、RouteKey，只要在创建队列时对应添加了这两个参数，在RabbitMQ管理平台看到的队列配置就不仅是单纯的Direct类型的队列类型

作者：恒宇少年
链接：https://www.jianshu.com/p/b74a14c7f31d
來源：简书
简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。*/

@Configuration
public class MessageRabbitMqConfiguration {
    /**
     * 消息中心实际消费队列交换配置
     *
     * @return
     */
    @Bean
    DirectExchange messageDirect() {
        return (DirectExchange) ExchangeBuilder
                .directExchange(QueueEnum.MESSAGE_QUEUE.getExchange())
                .durable(true)
                .build();
    }

    /**
     * 消息中心延迟消费交换配置
     *
     * @return
     */
    @Bean
    DirectExchange messageTtlDirect() {
        return (DirectExchange) ExchangeBuilder
                .directExchange(QueueEnum.MESSAGE_TTL_QUEUE.getExchange())
                .durable(true)
                .build();
    }

    /**
     * 消息中心实际消费队列配置
     *
     * @return
     */
    @Bean
    public Queue messageQueue() {
        return new Queue(QueueEnum.MESSAGE_QUEUE.getName());
    }


    /**
     * 消息中心TTL队列
     *
     * @return
     */
    @Bean
    Queue messageTtlQueue() {
        return QueueBuilder
                .durable(QueueEnum.MESSAGE_TTL_QUEUE.getName())
                // 配置到期后转发的交换
                .withArgument("x-dead-letter-exchange", QueueEnum.MESSAGE_QUEUE.getExchange())
                // 配置到期后转发的路由键
                .withArgument("x-dead-letter-routing-key", QueueEnum.MESSAGE_QUEUE.getRouteKey())
                .build();
    }

    /**
     * 消息中心实际消息交换与队列绑定
     *
     * @param messageDirect 消息中心交换配置
     * @param messageQueue  消息中心队列
     * @return
     */
    @Bean
    Binding messageBinding(DirectExchange messageDirect, Queue messageQueue) {
        return BindingBuilder
                .bind(messageQueue)
                .to(messageDirect)
                .with(QueueEnum.MESSAGE_QUEUE.getRouteKey());
    }

    /**
     * 消息中心TTL绑定实际消息中心实际消费交换机
     *
     * @param messageTtlQueue
     * @param messageTtlDirect
     * @return
     */
    @Bean
    public Binding messageTtlBinding(Queue messageTtlQueue, DirectExchange messageTtlDirect) {
        return BindingBuilder
                .bind(messageTtlQueue)
                .to(messageTtlDirect)
                .with(QueueEnum.MESSAGE_TTL_QUEUE.getRouteKey());
    }
}