package com.ecbas.consumer.configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Value("${e-cabs.rabbitmq.queue.add}")
    String addQueueName;

    @Value("${e-cabs.rabbitmq.queue.edit}")
    String editQueueName;

    @Value("${e-cabs.rabbitmq.queue.delete}")
    String deleteQueueName;

    @Value("${e-cabs.rabbitmq.queue.message-audit}")
    String messageAuditQueueName;

    @Value("${e-cabs.rabbitmq.exchange}")
    String exchange;

    @Value("${e-cabs.rabbitmq.message.exchange}")
    String messageExchange;

    @Value("${e-cabs.rabbitmq.routing-key.add}")
    String addRoutingKey;

    @Value("${e-cabs.rabbitmq.routing-key.edit}")
    String editRoutingKey;

    @Value("${e-cabs.rabbitmq.routing-key.delete}")
    String deleteRoutingKey;


    @Bean
    DirectExchange exchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(messageExchange);
    }

    @Bean
    Binding exchangeBinding(FanoutExchange fanoutExchange, DirectExchange exchange) {
        return BindingBuilder.bind(exchange).to(fanoutExchange);
    }

    @Bean
    Queue messageAuditQueue() {
        return new Queue(messageAuditQueueName, false);
    }

    @Bean
    Binding messageAuditQueueBinding(Queue messageAuditQueue,FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(messageAuditQueue).to(fanoutExchange);
    }

    @Bean
    Queue addQueue() {
        return new Queue(addQueueName, false);
    }

    @Bean
    Binding addQueueBinding(Queue addQueue, DirectExchange exchange) {
        return BindingBuilder.bind(addQueue).to(exchange).with(addRoutingKey);
    }

    @Bean
    Queue editQueue() {
        return new Queue(editQueueName, false);
    }

    @Bean
    Binding editQueueBinding(Queue editQueue, DirectExchange exchange) {
        return BindingBuilder.bind(editQueue).to(exchange).with(editRoutingKey);
    }

    @Bean
    Queue deleteQueue() {
        return new Queue(deleteQueueName, false);
    }

    @Bean
    Binding deleteQueueBinding(Queue deleteQueue, DirectExchange exchange) {
        return BindingBuilder.bind(deleteQueue).to(exchange).with(deleteRoutingKey);
    }


    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter(mapper());
    }

    @Bean
    public ObjectMapper mapper() {
        var mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }

    @Bean
    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}
