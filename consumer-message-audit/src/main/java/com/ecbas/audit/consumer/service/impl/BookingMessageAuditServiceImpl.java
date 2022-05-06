package com.ecbas.audit.consumer.service.impl;

import com.ecabs.config.Loggable;
import com.ecbas.audit.consumer.entity.BookingAudit;
import com.ecbas.audit.consumer.model.BookingDTO;
import com.ecbas.audit.consumer.repository.BookingMessageAuditRepository;
import com.ecbas.audit.consumer.service.BookingMessageAuditService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Loggable
public class BookingMessageAuditServiceImpl implements BookingMessageAuditService {

    private final BookingMessageAuditRepository bookingMessageAuditRepository;

    @Override
    public BookingAudit save(BookingDTO booking){
        var bookingAudit = new BookingAudit();
        bookingAudit.setMessage(booking.toString());
        bookingMessageAuditRepository.save(bookingAudit);
        return bookingAudit;
    }
}
