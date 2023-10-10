package com.example.Make_Your_Trip.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "bookings")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    private String seatNos;
    private LocalDate journeyDate;
    private Integer transportId;

    @ManyToOne
    @JoinColumn
    private Transport transport;

    @OneToOne(mappedBy = "booking",cascade = CascadeType.ALL)
    private Tickets ticket;

    @ManyToOne
    private Users user;
}
