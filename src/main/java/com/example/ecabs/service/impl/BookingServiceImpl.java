package com.example.ecabs.service.impl;

import com.example.ecabs.mapper.BookingRequestMapper;
import com.example.ecabs.model.dto.BookingDTO;
import com.example.ecabs.model.request.SaveBookingRequest;
import com.example.ecabs.service.BookingService;
import com.example.ecabs.service.RabbitSenderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRequestMapper bookingRequestMapper;
    private final RabbitSenderService rabbitSenderService;

    @Override
    public BookingDTO save(SaveBookingRequest request) {
        var dto = bookingRequestMapper.saveRequestToDto(request);
        rabbitSenderService.sendAddBooking(dto);
        return dto;
    }
}
