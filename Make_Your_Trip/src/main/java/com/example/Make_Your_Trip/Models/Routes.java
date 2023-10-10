package com.example.Make_Your_Trip.Models;

import com.example.Make_Your_Trip.Enums.City;
import com.example.Make_Your_Trip.Enums.ModeOfTransport;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "routes")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Routes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer routeId;

    @Enumerated(value = EnumType.STRING)
    private City fromCity;
    @Enumerated(value = EnumType.STRING)
    private City toCity;

//    private Date travelDate;
    private String listOfStops;

    @Enumerated(value = EnumType.STRING)
    private ModeOfTransport modeOfTransport;

    @OneToMany(mappedBy = "route",cascade = CascadeType.ALL)
    private List<Transport> transportList = new ArrayList<>();

}
