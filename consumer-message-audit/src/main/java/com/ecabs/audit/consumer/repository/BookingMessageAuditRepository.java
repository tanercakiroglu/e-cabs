package com.ecabs.audit.consumer.repository;

import com.ecabs.audit.consumer.entity.BookingAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingMessageAuditRepository extends JpaRepository<BookingAudit,Long> {
}
