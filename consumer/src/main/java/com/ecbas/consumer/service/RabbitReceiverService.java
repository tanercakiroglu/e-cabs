package com.ecbas.consumer.service;

import com.ecbas.consumer.model.dto.BookingDTO;

public interface RabbitReceiverService {

    void receivedAddBookingMessage(BookingDTO bookingDTO);

    void receivedDeleteBookingMessage(BookingDTO bookingDTO);

    void receivedEditBookingMessage(BookingDTO bookingDTO);
}
