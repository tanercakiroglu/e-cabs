package com.ecabs.consumer.service;

import com.ecabs.consumer.model.dto.BookingDTO;

public interface RabbitReceiverService {

    void receivedAddBookingMessage(BookingDTO bookingDTO);

    void receivedDeleteBookingMessage(BookingDTO bookingDTO);

    void receivedEditBookingMessage(BookingDTO bookingDTO);
}
