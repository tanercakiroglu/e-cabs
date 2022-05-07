package com.ecabs.audit.consumer.model;


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

    private static final long serialVersionUID = 1082647715460681819L;
    private Long id;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private String locality;

}
