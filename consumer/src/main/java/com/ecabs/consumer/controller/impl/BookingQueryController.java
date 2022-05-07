package com.ecabs.consumer.controller.impl;

import com.ecabs.config.Loggable;
import com.ecabs.config.response.WrapperCollectionResponse;
import com.ecabs.config.response.WrapperResponse;
import com.ecabs.consumer.controller.BookingQueryOperations;
import com.ecabs.consumer.model.dto.BookingDTO;
import com.ecabs.consumer.service.BookingQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
@Loggable
@RequiredArgsConstructor
public class BookingQueryController implements BookingQueryOperations {

    private final BookingQueryService bookingQueryService;


    @Override
    public WrapperResponse<BookingDTO> getById(Long id) {
        return WrapperResponse.of(bookingQueryService.getById(id));
    }

    @Override
    public WrapperCollectionResponse<BookingDTO> getAll() {
        return WrapperCollectionResponse.of(bookingQueryService.getAll());
    }
}
