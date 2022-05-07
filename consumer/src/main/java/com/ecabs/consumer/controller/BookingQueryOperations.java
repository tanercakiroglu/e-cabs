package com.ecabs.consumer.controller;

import com.ecabs.config.response.WrapperCollectionResponse;
import com.ecabs.config.response.WrapperResponse;
import com.ecabs.consumer.model.dto.BookingDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface BookingQueryOperations {

    @GetMapping("/{id}")
    WrapperResponse<BookingDTO> getById(@PathVariable("id") Long id);

    @GetMapping("/")
    WrapperCollectionResponse<BookingDTO> getAll();
}
