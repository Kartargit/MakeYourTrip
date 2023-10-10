package com.example.Make_Your_Trip.ResponseDtos;

import com.example.Make_Your_Trip.Enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AvailableSeatResponseDto {
    private String seatNo;
    private SeatType seatType;
    private Integer seatPrice;
}
