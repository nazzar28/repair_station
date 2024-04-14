package com.example.repair_station.service.interfaces;
import com.example.repair_station.dto.cars.CarsRequest;
import com.example.repair_station.dto.cars.CarsResponse;

import java.util.List;

public interface CarsService {

    void add(CarsRequest carsRequest, String token);

    void delete(Long id);

    void update(Long id,CarsRequest carsRequest);

    CarsResponse find(Long id);

    List<CarsResponse> findAll();

    void register(CarsRequest carsRequest, Long repairerId);

    void drop(Long repairerId, Long id);
}
