package com.ecabs.consumer.repository;

import com.ecabs.consumer.entity.Booking;
import com.ecabs.consumer.entity.TripWaypoint;
import com.ecabs.test.AbstractIntegrationTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookingRepositoryTest extends AbstractIntegrationTest {

    private final BookingRepository bookingRepository;

    @Autowired
    BookingRepositoryTest(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
        bookingRepository.save(getBooking());
    }

    @Test
    @Order(1)
    void findById() {
        var found = bookingRepository.findById(1L);
        assertTrue(found.isPresent());
    }

    @Test
    @Order(2)
    void update() {
        var entity = bookingRepository.findById(1L);
        entity.ifPresent(booking -> {
            booking.setNumberOfPassengers(5);
            booking.setTripWaypointSet(Set.of(getTripWay(booking)));
        });
        var found = bookingRepository.save(entity.get());
        assertEquals(found.getNumberOfPassengers(), 5);
        assertEquals(found.getTripWaypointSet().size(), 1);
    }

    @Test
    @Order(3)
    void delete() {
        bookingRepository.deleteById(1L);
        assertThrows(EmptyResultDataAccessException.class, () -> bookingRepository.deleteById(1L));
    }

    private TripWaypoint getTripWay(Booking booking) {
        var tripWaypoint = new TripWaypoint();
        tripWaypoint.setId(1L);
        tripWaypoint.setLatitude(new BigDecimal("12345678.123456"));
        tripWaypoint.setLongitude(new BigDecimal("123456789.123456"));
        tripWaypoint.setLocality("Y");
        tripWaypoint.setBooking(booking);
        return tripWaypoint;
    }


    private Booking getBooking() {
        var booking = new Booking();
        booking.setId(1L);
        booking.setNumberOfPassengers(4);
        booking.setPrice(BigDecimal.TEN);
        booking.setTripWaypointSet(new HashSet<>());

        return booking;

    }
}