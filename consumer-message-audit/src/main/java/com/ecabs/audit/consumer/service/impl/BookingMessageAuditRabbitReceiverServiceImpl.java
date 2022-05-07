package com.ecabs.audit.consumer.service.impl;

import com.ecabs.audit.consumer.model.BookingDTO;
import com.ecabs.audit.consumer.service.BookingMessageAuditRabbitReceiverService;
import com.ecabs.audit.consumer.service.BookingMessageAuditService;
import com.ecabs.config.Loggable;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Loggable
public class BookingMessageAuditRabbitReceiverServiceImpl implements BookingMessageAuditRabbitReceiverService {

    private final BookingMessageAuditService bookingMessageAuditService;

    @RabbitListener(queues = "${e-cabs.rabbitmq.queue.message-audit}")
    @Override
    public void receivedAddBookingMessage(BookingDTO booking) {
       bookingMessageAuditService.save(booking);
    }
}
