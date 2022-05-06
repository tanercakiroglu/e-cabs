package com.ecabs.producer.service;

import com.ecabs.producer.model.dto.BookingDTO;

public interface RabbitSenderService {

    void sendAddBooking(BookingDTO bookingDTO);

    void sendEditBooking(BookingDTO bookingDTO);

    void sendDeleteBooking(BookingDTO dto);
}
