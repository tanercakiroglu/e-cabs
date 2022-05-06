package com.ecbas.audit.consumer.service;

import com.ecbas.audit.consumer.entity.BookingAudit;
import com.ecbas.audit.consumer.model.BookingDTO;

public interface BookingMessageAuditService {
    BookingAudit save(BookingDTO booking);
}
