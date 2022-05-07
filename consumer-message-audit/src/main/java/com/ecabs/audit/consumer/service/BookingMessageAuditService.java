package com.ecabs.audit.consumer.service;

import com.ecabs.audit.consumer.model.BookingAuditDTO;
import com.ecabs.audit.consumer.model.BookingDTO;

public interface BookingMessageAuditService {
    BookingAuditDTO save(BookingDTO booking);
}
