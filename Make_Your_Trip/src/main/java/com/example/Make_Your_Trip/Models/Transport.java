package com.example.Make_Your_Trip.Models;

import com.example.Make_Your_Trip.Enums.ModeOfTransport;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
@Builder
@Entity
@Table(name = "transport")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transportId;
    @Enumerated(value = EnumType.STRING)
    private ModeOfTransport modeOfTransport;
    private LocalDate journeyDate;
    private LocalTime startTime;
    private double journeyDuration;
    private String companyName;
    @ManyToOne
    @JoinColumn
    private Routes route;

    @OneToMany(mappedBy = "transport",cascade = CascadeType.ALL)
    List<Seats> seatsList = new ArrayList<>();

    @OneToMany(mappedBy = "transport",cascade = CascadeType.ALL)
    List<Bookings> bookingList = new ArrayList<>();
}
