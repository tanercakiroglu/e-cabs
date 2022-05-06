package com.ecabs.producer.service.impl;

import com.ecabs.producer.mapper.BookingRequestMapperImpl;
import com.ecabs.producer.model.request.DeleteBookingRequest;
import com.ecabs.producer.model.request.SaveBookingRequest;
import com.ecabs.producer.model.request.UpdateBookingRequest;
import com.ecabs.producer.service.RabbitSenderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookingServiceImplTest {

    @InjectMocks
    BookingServiceImpl bookingService;

    @Mock
    RabbitSenderService rabbitSenderService;

    @Spy
    BookingRequestMapperImpl mapper;


    @Test
    void sendToRabbitForAdd_WhenValidDTO_verifyNumberOfTimes() {

        doNothing().when(rabbitSenderService).sendAddBooking(any());

        bookingService.sendToRabbit(getSaveRequest());

        verify(rabbitSenderService, times(1)).sendAddBooking(any());
        verify(mapper, times(1)).saveRequestToDto(any());

    }

    @Test
    void sendToRabbitForEdit_WhenValidDTO_verifyNumberOfTimes() {

        doNothing().when(rabbitSenderService).sendEditBooking(any());

        bookingService.sendToRabbit(getEditRequest());

        verify(rabbitSenderService, times(1)).sendEditBooking(any());
        verify(mapper, times(1)).updateRequestToDto(any());

    }

    @Test
    void sendToRabbitForDelete_WhenValidDTO_verifyNumberOfTimes() {

        doNothing().when(rabbitSenderService).sendDeleteBooking(any());

        bookingService.sendToRabbit(getDeleteRequest());

        verify(rabbitSenderService, times(1)).sendDeleteBooking(any());
        verify(mapper, times(1)).deleteRequestToDto(any());

    }

    private DeleteBookingRequest getDeleteRequest() {
        return new DeleteBookingRequest();
    }


    private SaveBookingRequest getSaveRequest() {
        return new SaveBookingRequest();
    }

    private UpdateBookingRequest getEditRequest() {
        return new UpdateBookingRequest();
    }
}