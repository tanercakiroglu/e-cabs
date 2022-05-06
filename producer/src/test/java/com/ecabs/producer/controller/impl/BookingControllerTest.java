package com.ecabs.producer.controller.impl;

import com.ecabs.producer.model.dto.BookingDTO;
import com.ecabs.producer.model.request.DeleteBookingRequest;
import com.ecabs.producer.model.request.SaveBookingRequest;
import com.ecabs.producer.model.request.UpdateBookingRequest;
import com.ecabs.producer.service.BookingService;
import com.ecabs.test.AbstractControllerStandaloneTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

class BookingControllerTest extends AbstractControllerStandaloneTest {

    @InjectMocks
    BookingController bookingController;
    @Mock
    BookingService bookingService;

    @BeforeEach
    public void setup() {
        this.setup(bookingController);
    }

    @Test
    void save_whenValidRequest_ReturnOk() throws Exception {

        when(bookingService.sendToRabbit((SaveBookingRequest) any())).thenReturn(new BookingDTO());
        mockMvc.perform(MockMvcRequestBuilders.post("/bookings/")
                        .content(getSaveRequestContent())
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
                .andExpect(MockMvcResultMatchers.content().string(containsString("200")));
    }

    @Test
    void save_whenContactNumberInvalid_ReturnBadRequest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/bookings/")
                        .content(getSaveRequestContentInvalidContactNumber())
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.BAD_REQUEST.value()))
                .andExpect(MockMvcResultMatchers.content().string(containsString("400")))
                .andExpect(MockMvcResultMatchers.content().string(containsString("Contact number should be like  +111 (202) 555-0125")));
    }


    @Test
    void update_whenValidRequest_ReturnOk() throws Exception {

        when(bookingService.sendToRabbit((UpdateBookingRequest) any())).thenReturn(new BookingDTO());
        mockMvc.perform(MockMvcRequestBuilders.put("/bookings/")
                        .content(getUpdateRequestContent())
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
                .andExpect(MockMvcResultMatchers.content().string(containsString("200")));
    }


    @Test
    void update_whenIdInvalid_ReturnBadRequest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.put("/bookings/")
                        .content(getUpdateRequestContentIdInvalid())
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.BAD_REQUEST.value()))
                .andExpect(MockMvcResultMatchers.content().string(containsString("400")))
                .andExpect(MockMvcResultMatchers.content().string(containsString("Invalid booking id.")));
    }


    @Test
    void delete_whenValidRequest_ReturnOk() throws Exception {

        when(bookingService.sendToRabbit((DeleteBookingRequest) any())).thenReturn(new BookingDTO());
        mockMvc.perform(MockMvcRequestBuilders.delete("/bookings/")
                        .content(getDeleteRequestContent())
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
                .andExpect(MockMvcResultMatchers.content().string(containsString("200")));
    }


    @Test
    void delete_whenIdInvalid_ReturnBadRequest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete("/bookings/")
                        .content(getDeleteRequestContentInvalidId())
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.BAD_REQUEST.value()))
                .andExpect(MockMvcResultMatchers.content().string(containsString("400")))
                .andExpect(MockMvcResultMatchers.content().string(containsString("Invalid booking id.")));
    }


    private String getSaveRequestContent() {
        return "{\n" +
                "  \"passengerName\": \"Taner\",\n" +
                "  \"passengerContactNumber\": \"+111 (202) 555-0125\",\n" +
                "  \"pickUpTime\": \"2022-05-05T10:46:55.645Z\",\n" +
                "  \"waitingTime\": 0,\n" +
                "  \"numberOfPassengers\": 0,\n" +
                "  \"price\": 0,\n" +
                "  \"rating\": 0,\n" +
                "  \"tripWaypointSet\": [\n" +
                "    {\n" +
                "      \"latitude\": 23434212.234234,\n" +
                "      \"longitude\": 23434212.234234\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }

    private String getSaveRequestContentInvalidContactNumber() {
        return "{\n" +
                "  \"passengerName\": \"Taner\",\n" +
                "  \"passengerContactNumber\": \"+111 (20) 555-0125\",\n" +
                "  \"pickUpTime\": \"2022-05-05T10:46:55.645Z\",\n" +
                "  \"waitingTime\": 0,\n" +
                "  \"numberOfPassengers\": 0,\n" +
                "  \"price\": 0,\n" +
                "  \"rating\": 0,\n" +
                "  \"tripWaypointSet\": [\n" +
                "    {\n" +
                "      \"latitude\": 23434212.234234,\n" +
                "      \"longitude\": 23434212.234234\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }

    private String getUpdateRequestContent() {
        return "{\n" +
                "  \"id\": 1,\n" +
                "  \"passengerName\": \"Taner\",\n" +
                "  \"passengerContactNumber\": \"+111 (202) 555-0125\",\n" +
                "  \"pickUpTime\": \"2022-05-05T10:46:55.645Z\",\n" +
                "  \"waitingTime\": 0,\n" +
                "  \"numberOfPassengers\": 0,\n" +
                "  \"price\": 0,\n" +
                "  \"rating\": 0,\n" +
                "  \"tripWaypointSet\": [\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"latitude\": 11111111.234234,\n" +
                "      \"longitude\": 23434212.234234\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }

    private String getUpdateRequestContentIdInvalid() {
        return "{\n" +
                "  \"id\": null,\n" +
                "  \"passengerName\": \"Taner\",\n" +
                "  \"passengerContactNumber\": \"+111 (202) 555-0125\",\n" +
                "  \"pickUpTime\": \"2022-05-05T10:46:55.645Z\",\n" +
                "  \"waitingTime\": 0,\n" +
                "  \"numberOfPassengers\": 0,\n" +
                "  \"price\": 0,\n" +
                "  \"rating\": 0,\n" +
                "  \"tripWaypointSet\": [\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"latitude\": 11111111.234234,\n" +
                "      \"longitude\": 23434212.234234\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }
    private String getDeleteRequestContent() {
        return "{\n" +
                "  \"id\": 1,\n" +
                "  \"passengerName\": \"Taner\",\n" +
                "  \"passengerContactNumber\": \"+111 (202) 555-0125\",\n" +
                "  \"pickUpTime\": \"2022-05-05T10:46:55.645Z\",\n" +
                "  \"waitingTime\": 0,\n" +
                "  \"numberOfPassengers\": 0,\n" +
                "  \"price\": 0,\n" +
                "  \"rating\": 0\n" +
                "}";
    }

    private String getDeleteRequestContentInvalidId() {
        return "{\n" +
                "  \"id\": null,\n" +
                "  \"passengerName\": \"Taner\",\n" +
                "  \"passengerContactNumber\": \"+111 (202) 555-0125\",\n" +
                "  \"pickUpTime\": \"2022-05-05T10:46:55.645Z\",\n" +
                "  \"waitingTime\": 0,\n" +
                "  \"numberOfPassengers\": 0,\n" +
                "  \"price\": 0,\n" +
                "  \"rating\": 0\n" +
                "}";
    }


}