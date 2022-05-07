package com.ecabs.audit.consumer.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;


@Getter
@Setter
@ToString
@EqualsAndHashCode
public class BookingDTO implements Serializable {

    private static final long serialVersionUID = -5250922909895859227L;
    private Long id;

    private String passengerName;

    private String passengerContactNumber;

    private LocalDateTime pickUpTime;

    private Integer waitingTime;

    private Integer numberOfPassengers;

    private boolean asap;

    private BigDecimal price;

    private Integer rating;

    private LocalDateTime createDateTime;

    private LocalDateTime updateDateTime;

    private Set<TripWaypointDTO> tripWaypointSet;
}
