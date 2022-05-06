package com.ecbas.consumer.service;

import com.ecbas.consumer.model.dto.BookingDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookingConsumerService {


    BookingDTO save(BookingDTO bookingDTO);

    BookingDTO update(BookingDTO bookingDTO);

    List<BookingDTO> getAll();

    BookingDTO getById(Long id);

    @Transactional
    void deleteById(Long id);
}
