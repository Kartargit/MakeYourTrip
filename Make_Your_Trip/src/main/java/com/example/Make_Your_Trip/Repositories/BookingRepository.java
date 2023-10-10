package com.example.Make_Your_Trip.Repositories;

import com.example.Make_Your_Trip.Models.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Bookings,Integer> {
    List<Bookings> findBookingsByJourneyDateAndTransportId(LocalDate journeyDate,Integer transportId);
}
