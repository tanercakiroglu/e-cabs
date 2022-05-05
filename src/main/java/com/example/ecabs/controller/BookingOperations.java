package com.example.ecabs.controller;

import com.example.ecabs.model.dto.BookingDTO;
import com.example.ecabs.model.request.SaveBookingRequest;
import com.example.ecabs.model.response.WrapperCollectionResponse;
import com.example.ecabs.model.response.WrapperResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public interface BookingOperations {

    @GetMapping("/")
    WrapperCollectionResponse<BookingDTO> getAll();

    @GetMapping("/{id}")
    WrapperResponse<BookingDTO> getById(@PathVariable int id);

    @PostMapping("/")
    WrapperResponse<BookingDTO> save(@Valid @RequestBody SaveBookingRequest request);

    @PutMapping("/")
    WrapperResponse<BookingDTO> update(@Valid @RequestBody BookingDTO bookingDTO);

    @DeleteMapping("/{id}")
    WrapperResponse<BookingDTO> deleteById(@PathVariable int id);
}
