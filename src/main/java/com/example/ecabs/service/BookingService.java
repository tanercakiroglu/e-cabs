package com.example.ecabs.service;

import com.example.ecabs.model.dto.BookingDTO;
import com.example.ecabs.model.request.SaveBookingRequest;
import com.example.ecabs.model.request.UpdateBookingRequest;

import java.util.List;

public interface BookingService {

    BookingDTO sendToRabbit(SaveBookingRequest bookingDTO);

    BookingDTO save(BookingDTO bookingDTO);

    BookingDTO update(BookingDTO bookingDTO);

    List<BookingDTO> getAll();

    BookingDTO getById(Long id);

    BookingDTO sendToRabbit(UpdateBookingRequest request);

    BookingDTO sendToRabbit(Long id);

    void deleteByExample(BookingDTO bookingDTO);
}
