package com.ecabs.audit.consumer.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class BookingAuditDTO {

    private Long id;
    private String message;
    private LocalDateTime createDateTime;
}
