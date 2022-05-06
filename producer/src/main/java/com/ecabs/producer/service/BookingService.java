package com.ecabs.producer.service;

import com.ecabs.producer.model.dto.BookingDTO;
import com.ecabs.producer.model.request.DeleteBookingRequest;
import com.ecabs.producer.model.request.SaveBookingRequest;
import com.ecabs.producer.model.request.UpdateBookingRequest;

public interface BookingService {

    BookingDTO sendToRabbit(SaveBookingRequest bookingDTO);

    BookingDTO sendToRabbit(UpdateBookingRequest request);

    BookingDTO sendToRabbit(DeleteBookingRequest request);

}
