package com.example.ecabs.service.impl;

import com.example.ecabs.model.dto.BookingDTO;
import com.example.ecabs.service.RabbitSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitSenderServiceImpl implements RabbitSenderService {

    private  final AmqpTemplate amqpTemplate;

    @Value("${e-cabs.rabbitmq.exchange}")
    String exchange;

    @Value("${e-cabs.rabbitmq.routing-key.add}")
    String addRoutingKey;

    @Value("${e-cabs.rabbitmq.routing-key.delete}")
    String editRoutingKey;

    @Value("${e-cabs.rabbitmq.routing-key.edit}")
    String deleteRoutingKey;


    @Override
    public void sendAddBooking(BookingDTO bookingDTO){
        amqpTemplate.convertAndSend(exchange, addRoutingKey, bookingDTO);

    }
}
