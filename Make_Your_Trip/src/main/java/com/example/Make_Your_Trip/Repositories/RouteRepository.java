package com.example.Make_Your_Trip.Repositories;

import com.example.Make_Your_Trip.Enums.City;
import com.example.Make_Your_Trip.Enums.ModeOfTransport;
import com.example.Make_Your_Trip.Models.Routes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RouteRepository extends JpaRepository<Routes,Integer>{
    List<Routes> findRoutesByFromCityAndToCityAndModeOfTransport(City fromCity, City toCity, ModeOfTransport transport);
}
