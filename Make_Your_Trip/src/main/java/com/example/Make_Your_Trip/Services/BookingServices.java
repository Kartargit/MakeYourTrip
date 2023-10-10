package com.example.Make_Your_Trip.Services;

import com.example.Make_Your_Trip.Models.*;
import com.example.Make_Your_Trip.Repositories.BookingRepository;
import com.example.Make_Your_Trip.Repositories.TransportRepository;
import com.example.Make_Your_Trip.Repositories.UserRepository;
import com.example.Make_Your_Trip.RequestDtos.BookingRequest;
import com.example.Make_Your_Trip.RequestDtos.GetAvailableSeatDto;
import com.example.Make_Your_Trip.ResponseDtos.AvailableSeatResponseDto;
import com.example.Make_Your_Trip.Transformers.BookingTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookingServices {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private TransportRepository transportRepository;
    @Autowired
    private UserRepository userRepository;
    public List<AvailableSeatResponseDto> getAvailableSeats(GetAvailableSeatDto getAvailableSeatDto){
        List<Bookings> bookingsList = bookingRepository.findBookingsByJourneyDateAndTransportId(
                getAvailableSeatDto.getJourneyDate(),getAvailableSeatDto.getTransportId());
        Set<String> bookedSeats = new HashSet<>();
        for(Bookings booking: bookingsList){
            String seats = booking.getSeatNos();
            String[] bookedSeatInBooking = seats.split(",");
            for(String seatNo:bookedSeatInBooking){
                bookedSeats.add(seatNo);
            }
        }
        Transport transport = transportRepository.findById(getAvailableSeatDto.getTransportId()).get();
        List<Seats> seatsList = transport.getSeatsList();

        List<AvailableSeatResponseDto> availableSeatsList = new ArrayList<>();
        for(Seats seat: seatsList){
            if(bookedSeats.contains(seat.getSeatNo()))continue;
            else{
                AvailableSeatResponseDto seatResponse = AvailableSeatResponseDto.builder()
                        .seatNo(seat.getSeatNo()).seatPrice(seat.getPrice()).seatType(seat.getSeatType())
                        .build();
                availableSeatsList.add(seatResponse);
            }
        }
        return availableSeatsList;
    }

    public String makeBooking(BookingRequest bookingRequest){
        Users userObj = userRepository.findById(bookingRequest.getUserId()).get();
        Transport transportObj = transportRepository.findById(bookingRequest.getTransportId()).get();
        Tickets ticket = creatTicket(transportObj,bookingRequest);

        Bookings booking = BookingTransformer.convertBookingRequestToEntity(bookingRequest);

        booking.setTicket(ticket);
        booking.setUser(userObj);
        booking.setTransport(transportObj);
//biDirection setting
        ticket.setBooking(booking);
        userObj.getBookingsList().add(booking);
        transportObj.getBookingList().add(booking);
//        saving now
        bookingRepository.save(booking);
        return "Booking had been Successfully";
    }
    public Tickets creatTicket(Transport transport,BookingRequest bookingRequest){
        Integer totalPrice = findTotalPrice(transport,bookingRequest.getSeatNos());
        String routeDetail = findRoutDetails(transport);
        Tickets ticket = Tickets.builder().seatNos(bookingRequest.getSeatNos()).totalCost(totalPrice)
                .journeyDate(bookingRequest.getJourneyDate()).startTime(transport.getStartTime())
                .routeDetail(routeDetail).journeyDuration(transport.getJourneyDuration()).build();
        return ticket;
    }
    public String findRoutDetails(Transport transport){
        Routes route = transport.getRoute();
        String res = route.getFromCity()+" To "+route.getToCity();
        return res;
    }
    public Integer findTotalPrice(Transport transport,String seatNos){
        return 0;
    }
}
