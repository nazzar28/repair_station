package com.example.repair_station.mapper.interfaces;

import com.example.repair_station.dto.cars.CarsResponse;
import com.example.repair_station.entities.Car;

import java.util.List;

public interface CarsMapper {
    CarsResponse toDto(Car car);

    List<CarsResponse> toDtos(List<Car>all);
}
