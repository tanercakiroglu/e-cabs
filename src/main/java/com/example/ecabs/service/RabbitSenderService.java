package com.example.ecabs.service;

import com.example.ecabs.model.dto.BookingDTO;

public interface RabbitSenderService {
    void sendAddBooking(BookingDTO bookingDTO);
}
