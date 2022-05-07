package com.ecabs.audit.consumer.repository;

import com.ecabs.audit.consumer.entity.BookingAudit;
import com.ecabs.test.AbstractIntegrationTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookingMessageAuditRepositoryTest extends AbstractIntegrationTest {

    private final BookingMessageAuditRepository bookingMessageAuditRepository;

    @Autowired
    BookingMessageAuditRepositoryTest(BookingMessageAuditRepository bookingMessageAuditRepository) {
        this.bookingMessageAuditRepository = bookingMessageAuditRepository;
        bookingMessageAuditRepository.save(getBookingAudit());
    }

    @Test
    @Order(1)
    void findById() {
        var found = bookingMessageAuditRepository.findById(1L);
        assertTrue(found.isPresent());
    }

    @Test
    @Order(2)
    void update() {
        var entity = bookingMessageAuditRepository.findById(1L);
        entity.ifPresent(booking -> {
            booking.setMessage("yy");

        });
        var found = bookingMessageAuditRepository.save(entity.get());
        assertEquals(found.getMessage(), "yy");
    }

    @Test
    @Order(3)
    void delete() {
        bookingMessageAuditRepository.deleteById(1L);
        assertThrows(EmptyResultDataAccessException.class, () -> bookingMessageAuditRepository.deleteById(1L));
    }


    private BookingAudit getBookingAudit() {
        var bookingAudit = new BookingAudit();
        bookingAudit.setId(1L);
        bookingAudit.setMessage("abc");
        return bookingAudit ;
    }

}