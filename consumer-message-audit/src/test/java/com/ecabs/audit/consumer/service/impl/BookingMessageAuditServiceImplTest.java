package com.ecabs.audit.consumer.service.impl;

import com.ecabs.audit.consumer.entity.BookingAudit;
import com.ecabs.audit.consumer.mapper.BookingAuditMapperImpl;
import com.ecabs.audit.consumer.model.BookingDTO;
import com.ecabs.audit.consumer.repository.BookingMessageAuditRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookingMessageAuditServiceImplTest {


    @InjectMocks
    BookingMessageAuditServiceImpl bookingMessageAuditService;

    @Mock
    BookingMessageAuditRepository bookingMessageAuditRepository;

    @Spy
    BookingAuditMapperImpl bookingAuditMapper;

    @Test
    void save_whenValidAuditMessage_BookingAuditDto() {

        when(bookingMessageAuditRepository.save(any())).thenReturn(getBookingAudit());

        var saved = bookingMessageAuditService.save(getBookingDTO());

        assertEquals(saved.getId(),1L);
        assertEquals(saved.getMessage(),getBookingDTO().toString());
    }

    private BookingAudit getBookingAudit() {
        var bookingAudit = new BookingAudit();
        bookingAudit.setId(1L);
        bookingAudit.setMessage(getBookingDTO().toString());
        return bookingAudit;
    }

    private BookingDTO getBookingDTO() {
        var bookingDto = new BookingDTO();
        bookingDto.setId(1L);
        bookingDto.setNumberOfPassengers(5);
        return bookingDto;
    }
}