package com.example.ecabs.service.impl;

import com.example.ecabs.config.Loggable;
import com.example.ecabs.mapper.BookingMapper;
import com.example.ecabs.mapper.BookingRequestMapper;
import com.example.ecabs.model.dto.BookingDTO;
import com.example.ecabs.model.request.SaveBookingRequest;
import com.example.ecabs.model.request.UpdateBookingRequest;
import com.example.ecabs.repository.BookingRepository;
import com.example.ecabs.service.BookingService;
import com.example.ecabs.service.RabbitSenderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRequestMapper bookingRequestMapper;
    private final RabbitSenderService rabbitSenderService;
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
    public void deleteByExample(BookingDTO bookingDTO) {
        bookingRepository.delete(bookingMapper.toEntity(bookingDTO));
    }

    @Override
    public BookingDTO sendToRabbit(UpdateBookingRequest request) {
        var dto = bookingRequestMapper.updateRequestToDto(request);
        rabbitSenderService.sendAddBooking(dto);
        return dto;
    }

    @Override
    @Loggable
    public BookingDTO sendToRabbit(SaveBookingRequest request) {
        var dto = bookingRequestMapper.saveRequestToDto(request);
        rabbitSenderService.sendAddBooking(dto);
        return dto;
    }

    @Override
    @Transactional
    public BookingDTO sendToRabbit(Long id) {
        var dto = getById(id);
        rabbitSenderService.sendDeleteBooking(dto);
        return dto;
    }


}
