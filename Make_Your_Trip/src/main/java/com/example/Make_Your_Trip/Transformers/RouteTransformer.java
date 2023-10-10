package com.example.Make_Your_Trip.Transformers;

import com.example.Make_Your_Trip.Models.Routes;
import com.example.Make_Your_Trip.RequestDtos.AddRouteDto;

public class RouteTransformer {
    public static Routes convertDtoToEntity(AddRouteDto addRouteDto){
        Routes routeObj = Routes.builder()
                .fromCity(addRouteDto.getFromCity())
                .toCity(addRouteDto.getToCity())
                .listOfStops(addRouteDto.getStopsInBetween())
                .modeOfTransport(addRouteDto.getModeOfTransport())
                .build();
        return routeObj;
    }
}
