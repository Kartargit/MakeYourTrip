package com.example.Make_Your_Trip.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tickets")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;
    private String routeDetail;
    private LocalTime startTime;
    private LocalDate journeyDate;
    private double journeyDuration;
    private Integer totalCost;
    private String seatNos;
    @OneToOne
    @JoinColumn
    private Bookings booking;
}
