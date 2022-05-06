package com.ecbas.consumer.model.dto;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TripWaypointDTO {

    private Long id;

    private BigDecimal latitude;

    private BigDecimal longitude;

}
