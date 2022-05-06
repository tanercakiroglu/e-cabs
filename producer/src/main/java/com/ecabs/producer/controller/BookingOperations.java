package com.ecabs.producer.controller;

import com.ecabs.config.response.WrapperResponse;
import com.ecabs.producer.model.dto.BookingDTO;
import com.ecabs.producer.model.request.DeleteBookingRequest;
import com.ecabs.producer.model.request.SaveBookingRequest;
import com.ecabs.producer.model.request.UpdateBookingRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface BookingOperations {


    @PostMapping("/")
    WrapperResponse<BookingDTO> save(@Valid @RequestBody SaveBookingRequest request);

    @PutMapping("/")
    WrapperResponse<BookingDTO> update(@Valid @RequestBody UpdateBookingRequest request);

    @DeleteMapping("/")
    WrapperResponse<BookingDTO> delete(@Valid @RequestBody DeleteBookingRequest request);
}
