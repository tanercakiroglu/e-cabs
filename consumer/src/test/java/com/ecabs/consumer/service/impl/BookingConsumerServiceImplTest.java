package com.ecabs.consumer.service.impl;

import com.ecabs.consumer.entity.Booking;
import com.ecabs.consumer.entity.TripWaypoint;
import com.ecabs.consumer.mapper.BookingMapperImpl;
import com.ecabs.consumer.model.dto.BookingDTO;
import com.ecabs.consumer.model.dto.TripWaypointDTO;
import com.ecabs.consumer.repository.BookingRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookingConsumerServiceImplTest {

    @InjectMocks
    BookingConsumerServiceImpl bookingConsumerService;

    @Mock
    BookingRepository bookingRepository;

    @Spy
    BookingMapperImpl bookingMapper;


    @Test
    public void save_whenValidDto_ReturnSaved() {
        when(bookingRepository.save(any())).thenReturn(getBooking());

        var saved = bookingConsumerService.save(new BookingDTO());

        assertEquals(saved.getId(), 1L);
        assertEquals(saved.getTripWaypointSet().size(), 1L);
        assertTrue(saved.getTripWaypointSet().contains(getTripWaypointDTO()));
    }

    @Test
    public void update_whenValidDto_ReturnSaved() {
        when(bookingRepository.save(any())).thenReturn(getBooking());

        var saved = bookingConsumerService.update(new BookingDTO());

        assertEquals(saved.getId(), 1L);
        assertEquals(saved.getTripWaypointSet().size(), 1L);
        assertTrue(saved.getTripWaypointSet().contains(getTripWaypointDTO()));
    }

    @Test
    public void delete_whenValidId_ReturnSaved() {
        doNothing().when(bookingRepository).deleteById(anyLong());

        bookingConsumerService.deleteById(1L);

        verify(bookingRepository, times(1)).deleteById(anyLong());
    }

    private Booking getBooking() {
        var booking = new Booking();
        booking.setId(1L);
        booking.setTripWaypointSet(Set.of(getTripWaypoint()));
        return booking;
    }

    private TripWaypoint getTripWaypoint() {
        var tripWaypoint = new TripWaypoint();
        tripWaypoint.setId(1L);
        tripWaypoint.setLocality("abc");
        return tripWaypoint;
    }

    private TripWaypointDTO getTripWaypointDTO() {
        var tripWaypoint = new TripWaypointDTO();
        tripWaypoint.setId(1L);
        tripWaypoint.setLocality("abc");
        return tripWaypoint;
    }

/*
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
    }*/


}