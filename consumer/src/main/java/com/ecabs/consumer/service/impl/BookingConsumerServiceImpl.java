package com.ecabs.consumer.service.impl;


import com.ecabs.consumer.mapper.BookingMapper;
import com.ecabs.consumer.model.dto.BookingDTO;
import com.ecabs.consumer.repository.BookingRepository;
import com.ecabs.consumer.service.BookingConsumerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class BookingConsumerServiceImpl implements BookingConsumerService {

    private final BookingMapper bookingMapper;
    private final BookingRepository bookingRepository;

    @Override
    @Transactional
    public BookingDTO save(BookingDTO bookingDTO) {
        var booking = bookingMapper.toEntity(bookingDTO);
        if (!CollectionUtils.isEmpty(booking.getTripWaypointSet())) {
            booking.getTripWaypointSet().forEach(tripWaypoint -> tripWaypoint.setBooking(booking));
        }
        var saved = bookingRepository.save(booking);
        return bookingMapper.toDto(saved);
    }

    @Override
    @Transactional
    public BookingDTO update(BookingDTO bookingDTO) {
        var booking = bookingMapper.toEntity(bookingDTO);
        if (!CollectionUtils.isEmpty(booking.getTripWaypointSet())) {
            booking.getTripWaypointSet().forEach(tripWaypoint -> tripWaypoint.setBooking(booking));
        }
        var saved = bookingRepository.save(booking);
        return bookingMapper.toDto(saved);
    }

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

    @Override
    @Transactional
    public void deleteById(Long id) {
        bookingRepository.deleteById(id);
    }



}
