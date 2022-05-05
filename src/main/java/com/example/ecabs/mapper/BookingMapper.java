package com.example.ecabs.mapper;

import com.example.ecabs.entity.Booking;
import com.example.ecabs.model.dto.BookingDTO;
import com.example.ecabs.util.MapperUtils;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring" ,uses = MapperUtils.class)
public interface BookingMapper {

    Booking toDto(BookingDTO bookingDTO);

    BookingDTO toEntity(Booking booking);

    List<Booking> toDtoList(List<BookingDTO> bookingDTOList);

    List<BookingDTO> toEntityList(List<Booking> bookList);


}
