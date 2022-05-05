package com.example.ecabs.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "BOOKINGS")
@Getter
@Setter
public class Booking {


    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "PASSENGER_NAME")
    private String passengerName;

    @Column(name = "PASSENGER_CONTACT_NUMBER")
    private String passengerContactNumber;

    @Column(name = "PICK_UP_TIME")
    private Timestamp pickUpTime;

    @Column(name = "WAITING_TIME")
    private Integer waitingTime;

    @Column(name = "NUMBER_OF_PASSENGERS")
    private Integer numberOfPassengers;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "RATING")
    private Integer rating;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "booking")
    private Set<TripWaypoint> tripWaypointSet;

}
