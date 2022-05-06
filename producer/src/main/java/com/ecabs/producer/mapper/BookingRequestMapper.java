package com.ecabs.producer.mapper;

import com.ecabs.config.utils.MapperUtils;
import com.ecabs.producer.model.dto.BookingDTO;
import com.ecabs.producer.model.request.DeleteBookingRequest;
import com.ecabs.producer.model.request.SaveBookingRequest;
import com.ecabs.producer.model.request.UpdateBookingRequest;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = MapperUtils.class)
public interface BookingRequestMapper {
    BookingDTO saveRequestToDto(SaveBookingRequest request);

    BookingDTO updateRequestToDto(UpdateBookingRequest request);

    BookingDTO deleteRequestToDto(DeleteBookingRequest request);

}

