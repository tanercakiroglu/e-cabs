package com.example.ecabs.entity;


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
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "CREATED_ON")
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    @Column(name = "LAST_MODIFIED_ON")
    private LocalDateTime updateDateTime;

    @OneToMany(
            mappedBy = "booking",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<TripWaypoint> tripWaypointSet;

}
