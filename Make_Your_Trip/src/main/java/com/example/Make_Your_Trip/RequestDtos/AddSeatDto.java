package com.example.Make_Your_Trip.RequestDtos;

import lombok.Data;

@Data
public class AddSeatDto {
    private int noOfEconomySeats;
    private int noOfBusinessSeats;
    private Integer transportId;
    private int economyPrice;
    private int businessPrice;
}
