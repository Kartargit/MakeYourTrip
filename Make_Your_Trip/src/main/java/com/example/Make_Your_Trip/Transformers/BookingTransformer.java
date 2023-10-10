package com.example.Make_Your_Trip.Transformers;

import com.example.Make_Your_Trip.Models.Bookings;
import com.example.Make_Your_Trip.RequestDtos.BookingRequest;

public class BookingTransformer {
    public static Bookings convertBookingRequestToEntity(BookingRequest bookingRequest){
        Bookings booking = Bookings.builder().seatNos(bookingRequest.getSeatNos())
                .journeyDate(bookingRequest.getJourneyDate())
                .transportId(bookingRequest.getTransportId())
                .build();
        return booking;
    }
}
