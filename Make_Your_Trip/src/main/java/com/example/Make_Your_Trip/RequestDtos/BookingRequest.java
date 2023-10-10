package com.example.Make_Your_Trip.RequestDtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingRequest {
    private String seatNos;
    private LocalDate journeyDate;
    private Integer transportId;
    private Integer userId;
}
