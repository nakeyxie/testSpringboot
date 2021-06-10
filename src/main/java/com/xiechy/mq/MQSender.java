package com.xiechy.mq;

import com.xiechy.util.uuid.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @Description 消息发送服务
 * @Author
 * @Date  2021/6/10 13:49
 * @return  
*/
@Slf4j
@Component
public class MQSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 消息发送回调(判断是否发送到相应的交换机(exchange)上)
     * @param correlationData   消息唯一标识
     * @param ack               消息确认结果(true:正确到达exchange,false:消息发送失败!)
     * @param cause             失败原因
     * @Author R&D-VAL SZ nakey.xie
     * @Date  2021/6/10 13:50
     * @return  
    */
    final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
        @Override
        public void confirm(@Nullable CorrelationData correlationData, boolean ack, @Nullable String cause) {
            String uuid = correlationData.getId();
            if (ack) {
                log.info("消息ID为：{}，成功发送到MQ broker！", uuid);
            } else {
                //后续做处理!
                log.error("消息ID为:{},发送失败!cause:{}", uuid, cause);
            }
        }
    };


    /**
     * 发送到队列失败后回调(消息无法路由到queue)
     * 消息可以发送到相应交换机，但是没有相应路由键和队列绑定
     * @param message           返回消息
     * @param replyCode         返回状态码
     * @param replyText         回复文本
     * @param exchange          交换机
     * @param routingKey        路由键
     */
    final RabbitTemplate.ReturnCallback returnCallback = new RabbitTemplate.ReturnCallback() {
        @Override
        public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
            log.error("消息ID为:{},发送失败！", message.getMessageProperties().getHeaders().get("spring_returned_message_correlation"));
            log.info("msg:{}", new String(message.getBody()));
            log.info("replyCode:{}", replyCode);
            log.info("replyText:{}", replyText);
            log.info("exchange:{}", exchange);
            log.info("routingKey:{}", routingKey);
        }
    };


    public void sendMessage(String exchange, String routingKey, String message) {
        //correlationDataId相当于消息的唯一表示
        String correlationDataId = IdUtils.fastSimpleUUID();
        CorrelationData correlationData = new CorrelationData(correlationDataId);
        this.sendMessage(exchange, routingKey, message, correlationData);
    }

    public void sendMessage(String exchange, String routingKey, String message, CorrelationData correlationData) {
        //设置消息的confirm监听，监听消息是否到达exchange
        rabbitTemplate.setConfirmCallback(confirmCallback);
        //设置消息的return监听，当消息无法路由到queue时候，会触发这个监听。
        rabbitTemplate.setReturnCallback(returnCallback);
        log.info("消息发送，消息ID:{},消息内容:{}", correlationData.getId(), message);
        rabbitTemplate.convertAndSend(exchange, routingKey, message, correlationData);
    }






    /**
     * 定制化amqp模版
     *
     * ConfirmCallback接口用于实现消息发送到RabbitMQ交换器后接收ack回调   即消息发送到exchange  ack
     * ReturnCallback接口用于实现消息发送到RabbitMQ 交换器，但无相应队列与交换器绑定时的回调  即消息发送不到任何一个队列中  ack
     *//*
    @Bean
    public RabbitTemplate rabbitTemplate() {


        // 消息发送失败返回到队列中, yml需要配置 publisher-returns: true
        rabbitTemplate.setMandatory(true);

        // 消息返回, yml需要配置 publisher-returns: true

        //配置return监听处理，消息无法路由到queue,根据实际业务操作
        final RabbitTemplate.ReturnCallback returnCallback = new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                log.info("=============returnCallback触发。消息路由到queue失败===========");
                log.info("msg="+new String(message.getBody()));
                log.info("replyCode="+replyCode);
                log.info("replyText="+replyText);
                log.info("exchange="+exchange);
                log.info("routingKey="+routingKey);
            }
        };


        // 消息确认, yml需要配置 publisher-confirms: true
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if (ack) {
                log.info("消息发送到exchange成功,id: {}", correlationData.getId());
            } else {
                log.info("消息发送到exchange失败,id:{},原因: {}", correlationData.getId(),cause);
            }
        });

        return rabbitTemplate;
    }*/


}

