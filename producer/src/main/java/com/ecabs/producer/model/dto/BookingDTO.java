package com.ecabs.producer.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;


@Getter
@Setter
public class BookingDTO implements Serializable {

    private Long id;

    private String passengerName;

    private String passengerContactNumber;

    private LocalDateTime pickUpTime;

    private Integer waitingTime;

    private Integer numberOfPassengers;

    private BigDecimal price;

    private Integer rating;

    private LocalDateTime createDateTime;

    private LocalDateTime updateDateTime;

    private Set<TripWaypointDTO> tripWaypointSet;
}
