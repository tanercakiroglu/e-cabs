package com.ecabs.producer.service.impl;


import com.ecabs.producer.model.dto.BookingDTO;
import com.ecabs.producer.service.RabbitSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitSenderServiceImpl implements RabbitSenderService {

    private final AmqpTemplate amqpTemplate;


    @Value("${e-cabs.rabbitmq.message.exchange}")
    String messageExchange;

    @Value("${e-cabs.rabbitmq.routing-key.add}")
    String addRoutingKey;

    @Value("${e-cabs.rabbitmq.routing-key.edit}")
    String editRoutingKey;

    @Value("${e-cabs.rabbitmq.routing-key.delete}")
    String deleteRoutingKey;


    @Override
    public void sendAddBooking(BookingDTO bookingDTO) {
        amqpTemplate.convertAndSend(messageExchange, addRoutingKey, bookingDTO);
    }

    @Override
    public void sendEditBooking(BookingDTO bookingDTO) {
        amqpTemplate.convertAndSend(messageExchange, editRoutingKey, bookingDTO);
    }

    @Override
    public void sendDeleteBooking(BookingDTO bookingDTO) {
        amqpTemplate.convertAndSend(messageExchange, deleteRoutingKey, bookingDTO);
    }
}
