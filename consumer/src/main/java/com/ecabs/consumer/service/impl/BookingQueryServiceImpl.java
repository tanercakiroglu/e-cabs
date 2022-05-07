package com.ecabs.consumer.service.impl;

import com.ecabs.consumer.mapper.BookingMapper;
import com.ecabs.consumer.model.dto.BookingDTO;
import com.ecabs.consumer.repository.BookingRepository;
import com.ecabs.consumer.service.BookingQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingQueryServiceImpl implements BookingQueryService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    @Override
    @Transactional
    public List<BookingDTO> getAll() {
        var list = bookingRepository.findAll();
        return bookingMapper.toDtoList(list);
    }

    @Override
    @Transactional
    public BookingDTO getById(Long id) {
        return bookingRepository.findById(id)
                .map(bookingMapper::toDto).orElseThrow(() -> {
                    throw new EntityNotFoundException(String.valueOf(id));
                });
    }

}
