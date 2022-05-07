package com.ecabs.consumer.model.dto;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class TripWaypointDTO implements Serializable {

    private static final long serialVersionUID = -6994790489541383369L;
    private Long id;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private String locality;

}
