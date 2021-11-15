package com.example.booking_service_01.mapper;

import com.example.booking_service_01.dto.AdminDTO;
import com.example.booking_service_01.dto.BookingDTO;
import com.example.booking_service_01.dto.FacilityDTO;
import com.example.booking_service_01.dto.ManageDTO;
import com.example.booking_service_01.dto.StudentsDTO;
import com.example.booking_service_01.entity.Admin;
import com.example.booking_service_01.entity.Booking;
import com.example.booking_service_01.entity.Facility;
import com.example.booking_service_01.entity.Manage;
import com.example.booking_service_01.entity.Students;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookingMapper {
    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class); // 2

    AdminDTO admin_To_DTO(Admin admin);
    Admin adminDto_To_Entity(AdminDTO adminDTO);

    @Mapping(target = "sid", source = "students.sid") 
    @Mapping(target = "fno", source = "facility.fno") 
    BookingDTO booking_To_DTO(Booking booking);
    @Mapping(target = "students.sid", source = "sid")
    @Mapping(target = "facility.fno", source = "fno")
    Booking bookingDto_To_Entity(BookingDTO bookigdDto); 

    FacilityDTO facility_To_DTO(Facility facility);
    Facility facilityDTO_To_Entity(FacilityDTO facilityDTO);

    @Mapping(target = "ano", source = "admin.ano")
    @Mapping(target = "fno", source = "facility.fno")
    ManageDTO manage_To_DTO(Manage manage);
    @Mapping(target = "admin.ano", source = "ano")
    @Mapping(target = "facility.fno", source = "fno")
    Manage manageDTO_To_Entity(ManageDTO manageDTO);
    
    StudentsDTO students_To_DTO(Students students);
    Students studentsDTO_To_Entity(StudentsDTO studentsDTO);
}