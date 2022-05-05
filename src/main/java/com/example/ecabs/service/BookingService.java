package com.example.ecabs.service;

import com.example.ecabs.model.dto.BookingDTO;
import com.example.ecabs.model.request.SaveBookingRequest;

public interface BookingService {

  BookingDTO  save(SaveBookingRequest bookingDTO);
}
