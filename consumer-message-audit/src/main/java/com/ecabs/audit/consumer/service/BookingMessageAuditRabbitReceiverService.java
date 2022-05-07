package com.ecabs.audit.consumer.service;

import com.ecabs.audit.consumer.model.BookingDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public interface BookingMessageAuditRabbitReceiverService {
    @RabbitListener(queues = "${e-cabs.rabbitmq.queue.message-audit}")
    void receivedAddBookingMessage(BookingDTO booking);
}
