package com.example.ecabs.service.impl;

import com.example.ecabs.model.dto.BookingDTO;
import com.example.ecabs.service.BookingService;
import com.example.ecabs.service.RabbitReceiverService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RabbitReceiverServiceImpl implements RabbitReceiverService {

    private final BookingService bookingService;

    @RabbitListener(queues = "${e-cabs.rabbitmq.queue.add}")
    public void receivedAddBookingMessage(BookingDTO bookingDTO) {
      bookingService.save(bookingDTO);
    }

    @RabbitListener(queues = "${e-cabs.rabbitmq.queue.edit}")
    public void receivedEditBookingMessage(BookingDTO bookingDTO) {
        bookingService.update(bookingDTO);
    }

    @RabbitListener(queues = "${e-cabs.rabbitmq.queue.delete}")
    public void receivedDeleteBookingMessage(BookingDTO bookingDTO) {
        bookingService.deleteByExample(bookingDTO);
    }

}
