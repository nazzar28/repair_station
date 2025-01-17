package com.example.repair_station.controller;

import com.example.repair_station.dto.cars.CarsRequest;
import com.example.repair_station.dto.cars.CarsResponse;
import com.example.repair_station.entities.Car;
import com.example.repair_station.entities.Repairer;
import com.example.repair_station.repositories.RepairerRepository;
import com.example.repair_station.service.interfaces.CarsService;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.web.bind.annotation.*;
import com.example.repair_station.mapper.interfaces.CarsMapper;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/car")
public class CarsController {
    private final CarsService carsService;
    private final CarsMapper carsMapper;
    private final RepairerRepository repairerRepository;

    @PostMapping("/add")
    public void add(@RequestBody CarsRequest carsRequest, @RequestHeader("Authorization") String token){
        carsService.add(carsRequest,token);
    }

    @DeleteMapping("/delete")
    public void delete(@PathVariable Long id){
        carsService.delete(id);
    }

    @GetMapping("/update")
    public void update(@PathVariable Long id,@RequestBody CarsRequest carsRequest){
        carsService.update(id,carsRequest);
    }

    @GetMapping("/find/{id}")
    public CarsResponse find(@PathVariable Long id){
        return carsService.find(id);
    }

    @GetMapping("/getAll")
    public List<CarsResponse>carsResponses(){
        return carsService.findAll();
    }

    @PostMapping("/register/{repairerId}")
    public void register(@RequestBody CarsRequest carsRequest,@PathVariable Long repairerId){
        carsService.register(carsRequest,repairerId);
    }

    @PostMapping("/{repairerId}/{id}")
    public void drop(@PathVariable Long repairerId,@PathVariable Long id){
        carsService.drop(repairerId,id);
    }

    @GetMapping("/repairerCars/{repairerId}")
    public List<CarsResponse>repairerCars(@PathVariable Long repairerId){
        Optional<Repairer> repairer = repairerRepository.findById(repairerId);

        return carsMapper.toDtos(repairer.get().getRepairercars());
    }
}
