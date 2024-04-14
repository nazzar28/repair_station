package com.example.repair_station.repositories;

import com.example.repair_station.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarsRepository extends JpaRepository<Car,Long> {

    Optional<Car> findByNumber(String tra);

    List<Car> findAllByExistAndAgeAccessGreaterThan(Boolean b, Integer integer);
    List<Car> findAllByExistAndAgeAccessLessThan(Boolean b, Integer integer);
}
