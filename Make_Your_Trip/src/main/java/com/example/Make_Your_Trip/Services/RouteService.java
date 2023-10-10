package com.example.Make_Your_Trip.Services;

import com.example.Make_Your_Trip.Models.Routes;
import com.example.Make_Your_Trip.Repositories.RouteRepository;
import com.example.Make_Your_Trip.RequestDtos.AddRouteDto;
import com.example.Make_Your_Trip.Transformers.RouteTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;
    public String addRoutes(AddRouteDto addRouteDto){
        Routes routeObj = RouteTransformer.convertDtoToEntity(addRouteDto);
        routeRepository.save(routeObj);
        return "Route has been added to database Successfully";
    }
}
