package com.example.Make_Your_Trip.Controllers;

import com.example.Make_Your_Trip.RequestDtos.BookingRequest;
import com.example.Make_Your_Trip.RequestDtos.GetAvailableSeatDto;
import com.example.Make_Your_Trip.ResponseDtos.AvailableSeatResponseDto;
import com.example.Make_Your_Trip.Services.BookingServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingServices bookingServices;
    @GetMapping("/availableSeats")
    public ResponseEntity searchAvailableSeat(@RequestBody GetAvailableSeatDto getAvailableSeatDto){
    List<AvailableSeatResponseDto> results = bookingServices.getAvailableSeats(getAvailableSeatDto);
    return new ResponseEntity(results, HttpStatus.OK);
    }

    @PostMapping("/bookFlight")
    public ResponseEntity bookFlight(@RequestBody BookingRequest bookingRequest){
        try{
            String res = bookingServices.makeBooking(bookingRequest);
            return new ResponseEntity(res,HttpStatus.OK);
        }catch (Exception e){
            log.error("Booking Failed {}",e.getMessage());
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
