package com.example.ecabs.mapper;

import com.example.ecabs.model.dto.BookingDTO;
import com.example.ecabs.model.request.SaveBookingRequest;
import com.example.ecabs.model.request.UpdateBookingRequest;
import com.example.ecabs.util.MapperUtils;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = MapperUtils.class)
public interface BookingRequestMapper {

    BookingDTO saveRequestToDto(SaveBookingRequest request);

    BookingDTO updateRequestToDto(UpdateBookingRequest request);
}
