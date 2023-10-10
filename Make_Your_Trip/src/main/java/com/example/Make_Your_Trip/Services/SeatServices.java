package com.example.Make_Your_Trip.Services;

import com.example.Make_Your_Trip.Enums.SeatType;
import com.example.Make_Your_Trip.Models.Seats;
import com.example.Make_Your_Trip.Models.Transport;
import com.example.Make_Your_Trip.Repositories.SeatRepository;
import com.example.Make_Your_Trip.Repositories.TransportRepository;
import com.example.Make_Your_Trip.RequestDtos.AddSeatDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SeatServices {
    @Autowired
    private TransportRepository transportRepository;
    @Autowired
    private SeatRepository seatRepository;
    public String addSeats(AddSeatDto addSeatDto){
        Transport transport = transportRepository.findById(addSeatDto.getTransportId()).get();
//        Transport transport = transportOptional.get();

        for(int i=1;i<=addSeatDto.getNoOfEconomySeats();i++){
            Seats seat = Seats.builder()
                    .seatNo(String.valueOf("E"+i)).seatType(SeatType.ECONOMY)
                    .price(addSeatDto.getEconomyPrice())
                    .transport(transport).build();
            transport.getSeatsList().add(seat);
        }
        for(int i=1;i<=addSeatDto.getNoOfBusinessSeats();i++){
            Seats seat = Seats.builder()
                    .seatNo(String.valueOf("B"+i)).seatType(SeatType.BUSINESS)
                    .price(addSeatDto.getBusinessPrice())
                    .transport(transport).build();
            transport.getSeatsList().add(seat);
        }
        transportRepository.save(transport);
        return "Designed Seats has been created Successfully";
    }
}
