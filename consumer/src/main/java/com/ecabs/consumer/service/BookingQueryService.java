package com.ecabs.consumer.service;

import com.ecabs.consumer.model.dto.BookingDTO;

import java.util.List;

public interface BookingQueryService {

    List<BookingDTO> getAll();

    BookingDTO getById(Long id);

}
