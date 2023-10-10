package com.example.Make_Your_Trip.Controllers;

import com.example.Make_Your_Trip.RequestDtos.AddSeatDto;
import com.example.Make_Your_Trip.Services.SeatServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seat")
public class SeatController {
    @Autowired
    private SeatServices seatServices;
    @PostMapping("/addSeat")
    public String addSeats(@RequestBody AddSeatDto addSeatDto){
        return  seatServices.addSeats(addSeatDto);
    }
}
