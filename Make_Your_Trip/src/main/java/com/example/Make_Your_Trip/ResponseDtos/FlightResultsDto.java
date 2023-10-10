package com.example.Make_Your_Trip.ResponseDtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlightResultsDto {
    private String companyName;
    private LocalDate journeyDate;
    private LocalTime startTime;
    private String stopsInBetween;
    private double journeyDuration;
}
