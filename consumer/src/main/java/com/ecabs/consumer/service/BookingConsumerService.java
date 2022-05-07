package com.ecabs.consumer.service;

import com.ecabs.consumer.model.dto.BookingDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookingConsumerService {


    BookingDTO save(BookingDTO bookingDTO);

    BookingDTO update(BookingDTO bookingDTO);

    @Transactional
    void deleteById(Long id);
}
