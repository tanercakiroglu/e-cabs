package com.ecbas.audit.consumer.repository;

import com.ecbas.audit.consumer.entity.BookingAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingMessageAuditRepository extends JpaRepository<BookingAudit,Long> {
}
