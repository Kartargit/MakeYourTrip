package com.example.Make_Your_Trip.RequestDtos;

import lombok.Data;

import java.time.LocalDate;
@Data
public class GetAvailableSeatDto {

    private LocalDate journeyDate;
    private Integer transportId;
}
