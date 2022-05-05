package com.example.ecabs.service;

import com.example.ecabs.model.dto.BookingDTO;

public interface RabbitReceiverService {

     void receivedAddBookingMessage(BookingDTO bookingDTO);

     void receivedDeleteBookingMessage(BookingDTO bookingDTO);

     void receivedEditBookingMessage(BookingDTO bookingDTO);
}
