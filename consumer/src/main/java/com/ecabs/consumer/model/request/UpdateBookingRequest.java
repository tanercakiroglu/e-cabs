package com.ecabs.consumer.model.request;


import com.ecabs.config.validator.ValidContactNumber;
import com.ecabs.consumer.model.dto.TripWaypointDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
public class UpdateBookingRequest {

    @NotNull(message = "booking.id.invalid")
    private Long id;

    @NotEmpty(message = "booking.passenger-name.invalid")
    private String passengerName;

    @ValidContactNumber(message = "booking.passenger.contact.number.invalid")
    private String passengerContactNumber;

    @NotNull(message = "booking.pick-up-time.invalid")
    private LocalDateTime pickUpTime;

    private Integer waitingTime;

    private Integer numberOfPassengers;

    private BigDecimal price;

    private Integer rating;

    private Set<TripWaypointDTO> tripWaypointSet;
}
