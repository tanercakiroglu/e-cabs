package com.ecabs.consumer.service.impl;


import com.ecabs.config.Loggable;
import com.ecabs.consumer.model.dto.BookingDTO;
import com.ecabs.consumer.service.BookingConsumerService;
import com.ecabs.consumer.service.RabbitReceiverService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Loggable
public class RabbitReceiverServiceImpl implements RabbitReceiverService {

    private final BookingConsumerService bookingConsumerService;

    @RabbitListener(queues = "${e-cabs.rabbitmq.queue.add}")
    public void receivedAddBookingMessage(BookingDTO bookingDTO) {
        bookingConsumerService.save(bookingDTO);
    }

    @RabbitListener(queues = "${e-cabs.rabbitmq.queue.edit}")
    public void receivedEditBookingMessage(BookingDTO bookingDTO) {
        bookingConsumerService.update(bookingDTO);
    }

    @RabbitListener(queues = "${e-cabs.rabbitmq.queue.delete}")
    public void receivedDeleteBookingMessage(BookingDTO bookingDTO) {
        bookingConsumerService.deleteById(bookingDTO.getId());
    }

}
