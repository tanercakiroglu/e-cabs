package com.ecbas.audit.consumer.service.impl;

import com.ecbas.audit.consumer.model.BookingDTO;
import com.ecbas.audit.consumer.service.BookingMessageAuditRabbitReceiverService;
import com.ecbas.audit.consumer.service.BookingMessageAuditService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingMessageAuditRabbitReceiverServiceImpl implements BookingMessageAuditRabbitReceiverService {

    private final BookingMessageAuditService bookingMessageAuditService;

    @RabbitListener(queues = "${e-cabs.rabbitmq.queue.message-audit}")
    @Override
    public void receivedAddBookingMessage(BookingDTO booking) {
       bookingMessageAuditService.save(booking);
    }
}
