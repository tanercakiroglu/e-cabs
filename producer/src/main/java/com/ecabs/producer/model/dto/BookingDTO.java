package com.ecabs.producer.model.dto;

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

    private static final long serialVersionUID = 295598826387909517L;
    private Long id;

    private String passengerName;

    private String passengerContactNumber;

    private LocalDateTime pickUpTime;

    private Integer waitingTime;

    private Integer numberOfPassengers;

    private BigDecimal price;

    private boolean asap;

    private Integer rating;

    private LocalDateTime createDateTime;

    private LocalDateTime updateDateTime;

    private Set<TripWaypointDTO> tripWaypointSet;
}
