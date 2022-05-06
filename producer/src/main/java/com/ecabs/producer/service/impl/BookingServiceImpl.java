package com.ecabs.producer.service.impl;

import com.ecabs.config.Loggable;
import com.ecabs.producer.mapper.BookingRequestMapper;
import com.ecabs.producer.model.dto.BookingDTO;
import com.ecabs.producer.model.request.DeleteBookingRequest;
import com.ecabs.producer.model.request.SaveBookingRequest;
import com.ecabs.producer.model.request.UpdateBookingRequest;
import com.ecabs.producer.service.BookingService;
import com.ecabs.producer.service.RabbitSenderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRequestMapper bookingRequestMapper;
    private final RabbitSenderService rabbitSenderService;

    @Override
    public BookingDTO sendToRabbit(UpdateBookingRequest request) {
        var dto = bookingRequestMapper.updateRequestToDto(request);
        rabbitSenderService.sendEditBooking(dto);
        return dto;
    }

    @Override
    @Loggable
    public BookingDTO sendToRabbit(SaveBookingRequest request) {
        var dto = bookingRequestMapper.saveRequestToDto(request);
        rabbitSenderService.sendAddBooking(dto);
        return dto;
    }

    @Override
    public BookingDTO sendToRabbit(DeleteBookingRequest request) {
        var dto = bookingRequestMapper.deleteRequestToDto(request);
        rabbitSenderService.sendDeleteBooking(dto);
        return dto;
    }


}
