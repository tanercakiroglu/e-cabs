package com.ecabs.audit.consumer.service.impl;

import com.ecabs.audit.consumer.entity.BookingAudit;
import com.ecabs.audit.consumer.mapper.BookingAuditMapper;
import com.ecabs.audit.consumer.model.BookingAuditDTO;
import com.ecabs.audit.consumer.model.BookingDTO;
import com.ecabs.audit.consumer.repository.BookingMessageAuditRepository;
import com.ecabs.audit.consumer.service.BookingMessageAuditService;
import com.ecabs.config.Loggable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Loggable
public class BookingMessageAuditServiceImpl implements BookingMessageAuditService {

    private final BookingMessageAuditRepository bookingMessageAuditRepository;
    private final BookingAuditMapper bookingAuditMapper;

    @Override
    public BookingAuditDTO save(BookingDTO booking){
        var bookingAudit = new BookingAudit();
        bookingAudit.setMessage(booking.toString());
        return bookingAuditMapper.toDto(bookingMessageAuditRepository.save(bookingAudit));

    }
}
