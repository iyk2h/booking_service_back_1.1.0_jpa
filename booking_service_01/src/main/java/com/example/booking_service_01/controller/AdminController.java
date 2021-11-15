package com.example.booking_service_01.controller;

import com.example.booking_service_01.dto.AdminDTO;
import com.example.booking_service_01.repository.AdminRepository;
import com.example.booking_service_01.service.BookingServiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    BookingServiceService bookingServiceService;
    @Autowired
    AdminRepository adminRepository;
    
    //select admin ano
    @GetMapping(path="/{ano}", produces = "application/json")
    public ResponseEntity<?> getAno(@PathVariable("ano") Integer ano) {
        if(!bookingServiceService.checkAno(ano)) {
            return new ResponseEntity<>("ano can not found", HttpStatus.OK);
        }
        else {
            AdminDTO adminDTO = bookingServiceService.findByAno(ano);
            return new ResponseEntity<>(adminDTO, HttpStatus.OK);
        }
    }

    //insert admin
    @PostMapping(path = "", produces = "application/json")
    public ResponseEntity<?> insertAdmin(@RequestBody AdminDTO adminDTO) {
        System.out.println("insert"); 
        System.out.println(adminDTO);
        System.out.println(adminDTO.getAno());
        if(adminDTO.getAno()!=null) {
            if (!bookingServiceService.checkAno(adminDTO.getAno())) {
                System.out.println("if"); 
                System.out.println(adminDTO);
                System.out.println(adminDTO.getAno());
            }
            else
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            return new ResponseEntity<>(bookingServiceService.findByAno(bookingServiceService.insertAdminDto(adminDTO)), HttpStatus.CREATED);
        }
        else{
            System.out.println("else"); 
            System.out.println(adminDTO);
            System.out.println(adminDTO.getAno());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
