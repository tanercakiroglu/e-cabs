package com.example.ecabs.controller.impl;

import com.example.ecabs.config.Loggable;
import com.example.ecabs.controller.BookingOperations;
import com.example.ecabs.model.dto.BookingDTO;
import com.example.ecabs.model.request.SaveBookingRequest;
import com.example.ecabs.model.response.WrapperCollectionResponse;
import com.example.ecabs.model.response.WrapperResponse;
import com.example.ecabs.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
@Loggable
@RequiredArgsConstructor
public class BookingController implements BookingOperations {

    private final BookingService bookingService;

    @Override
    public WrapperCollectionResponse<BookingDTO> getAll() {
        throw new ResourceNotFoundException();
    }

    @Override
    public WrapperResponse<BookingDTO> getById(int id) {
        return null;
    }

    @Override
    public WrapperResponse<BookingDTO> save(SaveBookingRequest request) {
        return WrapperResponse.of(bookingService.save(request));
    }

    @Override
    public WrapperResponse<BookingDTO> update(BookingDTO bookingDTO) {
        return null;
    }

    @Override
    public WrapperResponse<BookingDTO> deleteById(int id) {
        return null;
    }
}
