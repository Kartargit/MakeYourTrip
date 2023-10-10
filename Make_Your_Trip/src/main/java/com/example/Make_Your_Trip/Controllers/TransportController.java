package com.example.Make_Your_Trip.Controllers;

import com.example.Make_Your_Trip.RequestDtos.AddTransportDto;
import com.example.Make_Your_Trip.RequestDtos.SearchFlightDto;
import com.example.Make_Your_Trip.ResponseDtos.FlightResultsDto;
import com.example.Make_Your_Trip.Services.TransportServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/transport")
public class TransportController {
@Autowired
    private TransportServices transportServices;
@PostMapping("/addTransport")
    public ResponseEntity addTransport(@RequestBody AddTransportDto addTransportDto){
    try{
        String res = transportServices.addTransport(addTransportDto);
        return new ResponseEntity(res, HttpStatus.OK);

    }catch (Exception e){
        log.error("Add transport failed {}",e.getMessage());
        return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
    @GetMapping("/searchFlight")
    public ResponseEntity searchFlight(@RequestBody SearchFlightDto searchFlightDto){
        try{
            List<FlightResultsDto> listOfFlight = transportServices.searchFlights(searchFlightDto);
                    return new ResponseEntity(listOfFlight,HttpStatus.OK);
        }catch (Exception e){
            log.error("There is no Flight {}",e.getMessage());
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
