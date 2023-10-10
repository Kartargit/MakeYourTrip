package com.example.Make_Your_Trip.Services;

import com.example.Make_Your_Trip.Enums.ModeOfTransport;
import com.example.Make_Your_Trip.Exceptions.RouteNotFoundException;
import com.example.Make_Your_Trip.Models.Routes;
import com.example.Make_Your_Trip.Models.Transport;
import com.example.Make_Your_Trip.Repositories.RouteRepository;
import com.example.Make_Your_Trip.Repositories.TransportRepository;
import com.example.Make_Your_Trip.RequestDtos.AddTransportDto;
import com.example.Make_Your_Trip.RequestDtos.SearchFlightDto;
import com.example.Make_Your_Trip.ResponseDtos.FlightResultsDto;
import com.example.Make_Your_Trip.Transformers.TransportTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class TransportServices {
    @Autowired
    private TransportRepository transportRepository;
    @Autowired
    private RouteRepository routeRepository;
    public String addTransport(AddTransportDto addTransportDto) throws Exception{
        Transport transport = TransportTransformer.convertDtoToEntity(addTransportDto);
        Optional<Routes> routesOptional = routeRepository.findById(addTransportDto.getRouteId());
        if(!routesOptional.isPresent()){
            throw new RouteNotFoundException("InCorrect RouteId");
        }
        Routes route = routesOptional.get();
        transport.setRoute(route); //primaryKey Set in child
        route.getTransportList().add(transport); //bidirectionally in parent also
        routeRepository.save(route);

        return "Transport is added to database and route Successfully";
    }
    public List<FlightResultsDto> searchFlights(SearchFlightDto searchFlightDto){
        List<Routes> routesList = routeRepository.findRoutesByFromCityAndToCityAndModeOfTransport(
                searchFlightDto.getFromCity(),searchFlightDto.getToCity(),
                ModeOfTransport.FLIGHT);

        List<FlightResultsDto> flightResultList = new ArrayList<>();

        for(Routes routes:routesList){
            log.info("we are having routes",routes.getFromCity(),routes.getFromCity());
            List<Transport> transportList = routes.getTransportList();
            log.info("We have transportList of size: {}",transportList.size());
            for(Transport transport:transportList){
                if(transport.getJourneyDate().equals(searchFlightDto.getJourneyDate())){
                    FlightResultsDto flightResult = TransportTransformer.convertEntityToFlightResultsDto(transport);
                    flightResult.setStopsInBetween(routes.getListOfStops());
                    flightResultList.add(flightResult);
                }
            }
        }
        return flightResultList;
    }
}
