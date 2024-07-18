package com._yzhheng.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

/**
 * Rabbitmq配置类
 * 
 */
@Configuration
public class MyRabbitConfig {

    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 使用JSON序列化机制，进行消息转换
     * 
     * @return
     */
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    /**
     * 定制RabbitTemplate
     * 1、服务收到消息就会回调
     * 1、spring.rabbitmq.publisher-confirms: true
     * 2、设置确认回调ConfirmCallback
     * 2、消息正确抵达队列就会进行回调
     * 1、spring.rabbitmq.publisher-returns: true
     * spring.rabbitmq.template.mandatory: true
     * 2、设置确认回调ReturnCallback
     *
     * 3、消费端确认(保证每个消息都被正确消费，此时才可以broker删除这个消息)
     * 1、默认是手动确认的，只要消息接收到，客户端会自动确认，服务器就会移除这个消息。
     * 问题：
     * 我们收到很多消息，自动回复给服务器ack，只有一个消息处理成功，宕机了。发生消息丢失；
     * 消费者手动确认。只要我们没有明确告诉mq，货物被签收。没有ack，消息就一直是unack状态。即使Consumer宕机。
     * 消息也不会丢失，会重新变为ready，下一次有新的Consumer连接来给他发。
     * spring.rabbitmq.listener.simple.acknowledge-mode=manual #手动签收
     * 2、如何签收：
     * channel.basicAck(deliveryTag,false); 签收货物；业务成功完成应该签收
     * channel.basicNack(deliveryTag,false,true); 拒签货物；业务失败了应该拒签
     */
    @PostConstruct // MyRabbitConfig对象创建完成以后，执行这个方法
    public void initRabbitTemplate() {
        // 设置确认回调
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            /**
             * 只要消息抵达Broker就ack=true
             * 
             * @param correlationData 当前消息的唯一关联数据(这个是消息的唯一id)
             * @param ack             消息是否成功收到
             * @param cause           失败的原因
             */
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                /**
                 * 1、做好消息确认机制（pulisher，consumer【手动ack】）
                 * 2、每一个发送的消息都在数据库【mq_message表】做好记录。定期将失败的消息再次发送一遍
                 */
                // 服务器收到了
                // 修改消息的状态【没做】
                System.out.println("confirm...correlationData[" + correlationData + "]==>ack:[" + ack + "]==>cause:["
                        + cause + "]");
            }
        });

        // 设置消息抵达队列的确认回调
        rabbitTemplate.setReturnsCallback(new RabbitTemplate.ReturnsCallback() {
            /**
             * 只要消息没有投递给指定的队列，就触发这个失败回调
             * 
             * @param message    投递失败的消息详细信息
             * @param replyCode  回复的状态码
             * @param replyText  回复的文本内容
             * @param exchange   当时这个消息发给哪个交换机
             * @param routingKey 当时这个消息用哪个路邮键
             */
            // @Override
            // public void returnedMessage(Message message, int replyCode, String replyText,
            // String exchange,
            // String routingKey) {
            // // 报错了。修改数据库当前消息的状态->错误。
            // System.out.println("Fail Message[" + message + "]==>replyCode[" + replyCode +
            // "]" +
            // "==>replyText[" + replyText + "]==>exchange[" + exchange + "]==>routingKey["
            // + routingKey
            // + "]");
            // }

            @Override
            public void returnedMessage(ReturnedMessage returned) {
                // TODO Auto-generated method stub
                System.out.println("Failed Message: " + returned.getReplyText());
            }
        });
    }

}
