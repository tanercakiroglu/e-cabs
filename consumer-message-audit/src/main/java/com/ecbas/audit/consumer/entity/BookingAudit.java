package com.ecbas.audit.consumer.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name = "BOOKING_AUDIT")
@Getter
@Setter
@ToString
public class BookingAudit {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(name = "MESSAGE",columnDefinition="CLOB")
    @Lob
    private String message;
    @CreationTimestamp
    @Column(name = "CREATED_ON",updatable = false)
    private LocalDateTime createDateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BookingAudit that = (BookingAudit) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
