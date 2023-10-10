package com.example.Make_Your_Trip.RequestDtos;

import com.example.Make_Your_Trip.Enums.ModeOfTransport;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
public class AddTransportDto {
    private ModeOfTransport modeOfTransport;
    private LocalTime startTime;
    private LocalDate journeyDate;
    private double journeyDuration;
    private String companyName;
    private Integer routeId;
}
