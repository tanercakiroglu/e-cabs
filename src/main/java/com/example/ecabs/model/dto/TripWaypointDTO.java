package com.example.ecabs.model.dto;


import com.example.ecabs.entity.Booking;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TripWaypointDTO {

    private Long id;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private Booking booking;
}
