package com.ecbas.consumer.mapper;


import com.ecabs.config.utils.MapperUtils;
import com.ecbas.consumer.entity.Booking;
import com.ecbas.consumer.model.dto.BookingDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = MapperUtils.class)
public interface BookingMapper {

    Booking toEntity(BookingDTO bookingDTO);

    BookingDTO toDto(Booking booking);

    List<Booking> toEntityList(List<BookingDTO> bookingDTOList);

    List<BookingDTO> toDtoList(List<Booking> bookList);


}
