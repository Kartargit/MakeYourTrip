package com.example.Make_Your_Trip.Transformers;

import com.example.Make_Your_Trip.Models.Transport;
import com.example.Make_Your_Trip.RequestDtos.AddTransportDto;
import com.example.Make_Your_Trip.ResponseDtos.FlightResultsDto;

public class TransportTransformer {
    public static Transport convertDtoToEntity(AddTransportDto addTransportDto){
        Transport transportObj = Transport.builder().modeOfTransport(addTransportDto.getModeOfTransport())
                .journeyDate(addTransportDto.getJourneyDate())
                .startTime(addTransportDto.getStartTime())
                .journeyDuration(addTransportDto.getJourneyDuration())
                .companyName(addTransportDto.getCompanyName())
                .build();
        return transportObj;
    }
    public static FlightResultsDto convertEntityToFlightResultsDto(Transport transport){
        FlightResultsDto flightResult = FlightResultsDto.builder()
                .companyName(transport.getCompanyName())
                .journeyDate(transport.getJourneyDate())
                .journeyDuration(transport.getJourneyDuration())
                .startTime(transport.getStartTime())
                .build();
        return flightResult;
    }
}
