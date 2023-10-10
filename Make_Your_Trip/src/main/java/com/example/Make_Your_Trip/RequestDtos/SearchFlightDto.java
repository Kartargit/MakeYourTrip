package com.example.Make_Your_Trip.RequestDtos;

import com.example.Make_Your_Trip.Enums.City;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SearchFlightDto {
    private City fromCity;
    private City toCity;
    private LocalDate journeyDate;
}
