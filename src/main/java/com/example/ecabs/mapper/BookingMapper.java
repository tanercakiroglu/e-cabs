package com.example.ecabs.mapper;

import com.example.ecabs.entity.Booking;
import com.example.ecabs.model.dto.BookingDTO;
import com.example.ecabs.util.MapperUtils;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring" ,uses = MapperUtils.class)
public interface BookingMapper {

    Booking toEntity(BookingDTO bookingDTO);

    BookingDTO toDto(Booking booking);

    List<Booking> toEntityList(List<BookingDTO> bookingDTOList);

    List<BookingDTO> toDtoList(List<Booking> bookList);


}
