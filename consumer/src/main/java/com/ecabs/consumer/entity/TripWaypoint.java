package com.ecabs.consumer.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@Entity
@Table(name = "TRIP_WAYPOINTS")
@Getter
@Setter
public class TripWaypoint {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "LATITUDE", nullable = false)
    @Digits(integer = 8, fraction = 6)
    private BigDecimal latitude;

    @Column(name = "LONGITUDE", nullable = false)
    @Digits(integer = 9, fraction = 6)
    private BigDecimal longitude;

    @Column(name = "LOCALITY")
    private String locality;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOOKING_ID")
    private Booking booking;

}
