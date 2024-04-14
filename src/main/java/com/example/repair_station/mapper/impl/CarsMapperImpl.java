package com.example.repair_station.mapper.impl;

import com.example.repair_station.dto.cars.CarsResponse;
import com.example.repair_station.entities.Car;
import com.example.repair_station.mapper.interfaces.CarsMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarsMapperImpl implements CarsMapper {

    @Override
    public CarsResponse toDto(Car car){
        CarsResponse carsResponse=new CarsResponse();
        carsResponse.setId(car.getId());
        carsResponse.setModel(car.getModel().name());
        carsResponse.setAge(car.getAge());
        carsResponse.setNumber(car.getNumber());

        return carsResponse;
    }

    @Override
    public List<CarsResponse>toDtos(List<Car>all){
        List<CarsResponse>carsResponses=new ArrayList<>();
        for(Car car:all){
            carsResponses.add(toDto(car));
        }
        return carsResponses;
    }
}
