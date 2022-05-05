package com.example.ecabs.controller.impl;

import com.example.ecabs.config.Loggable;
import com.example.ecabs.controller.BookingOperations;
import com.example.ecabs.model.dto.BookingDTO;
import com.example.ecabs.model.request.SaveBookingRequest;
import com.example.ecabs.model.request.UpdateBookingRequest;
import com.example.ecabs.model.response.WrapperCollectionResponse;
import com.example.ecabs.model.response.WrapperResponse;
import com.example.ecabs.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/bookings")
@Loggable
@RequiredArgsConstructor
@Validated
public class BookingController implements BookingOperations {

    private final BookingService bookingService;

    @Override
    public WrapperCollectionResponse<BookingDTO> getAll() {
        return WrapperCollectionResponse.of(bookingService.getAll());
    }

    @Override
    public WrapperResponse<BookingDTO> getById(Long id) {
        return WrapperResponse.of(bookingService.getById(id));
    }

    @Override
    public WrapperResponse<BookingDTO> save(@Valid @RequestBody SaveBookingRequest request) {
        return WrapperResponse.of(bookingService.sendToRabbit(request));
    }

    @Override
    public WrapperResponse<BookingDTO> update(@Valid UpdateBookingRequest request) {
        return WrapperResponse.of(bookingService.sendToRabbit(request));
    }

    @Override
    public WrapperResponse<BookingDTO> deleteById(Long id) {
        return WrapperResponse.of(bookingService.sendToRabbit(id));
    }
}
