package com.example.Make_Your_Trip.Repositories;

import com.example.Make_Your_Trip.Models.Seats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seats,Integer> {
}
