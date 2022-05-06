package com.ecabs.producer.controller.impl;

import com.ecabs.config.Loggable;


import com.ecabs.config.response.WrapperResponse;
import com.ecabs.producer.controller.BookingOperations;
import com.ecabs.producer.model.dto.BookingDTO;
import com.ecabs.producer.model.request.DeleteBookingRequest;
import com.ecabs.producer.model.request.SaveBookingRequest;
import com.ecabs.producer.model.request.UpdateBookingRequest;

import com.ecabs.producer.service.impl.BookingServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
@Loggable
@RequiredArgsConstructor
@Validated
public class BookingController implements BookingOperations{

    private final BookingServiceImpl bookingService;


    @Override
    public WrapperResponse<BookingDTO> save(SaveBookingRequest request) {
        return WrapperResponse.of(bookingService.sendToRabbit(request));
    }

    @Override
    public WrapperResponse<BookingDTO> update(UpdateBookingRequest request) {
        return WrapperResponse.of(bookingService.sendToRabbit(request));
    }

    @Override
    public WrapperResponse<BookingDTO> delete(DeleteBookingRequest request) {
        return WrapperResponse.of(bookingService.sendToRabbit(request));
    }
}
