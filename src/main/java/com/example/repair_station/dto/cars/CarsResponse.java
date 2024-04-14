package com.example.repair_station.dto.cars;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CarsResponse {
    private Long id;
    private String model;
    private int age;
    private String number;
}
