package com.ecabs.audit.consumer.mapper;

import com.ecabs.audit.consumer.entity.BookingAudit;
import com.ecabs.audit.consumer.model.BookingAuditDTO;
import com.ecabs.config.utils.MapperUtils;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = MapperUtils.class)
public interface BookingAuditMapper {

    BookingAuditDTO toDto(BookingAudit bookingAudit);
    BookingAudit toEntity(BookingAuditDTO bookingAuditDTO);
}
