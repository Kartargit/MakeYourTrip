package com.example.Make_Your_Trip.Controllers;

import com.example.Make_Your_Trip.RequestDtos.AddRouteDto;
import com.example.Make_Your_Trip.Services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/routes")
public class RouteController {
    @Autowired
    private RouteService routeService;
    @PostMapping("/addRoute")
    public String addRoutes(@RequestBody AddRouteDto addRouteDto){
        return routeService.addRoutes(addRouteDto);
    }

}
