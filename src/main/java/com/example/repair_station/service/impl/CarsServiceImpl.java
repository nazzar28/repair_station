package com.example.repair_station.service.impl;

import com.example.repair_station.dto.cars.CarsRequest;
import com.example.repair_station.dto.cars.CarsResponse;
import com.example.repair_station.entities.Car;
import com.example.repair_station.entities.Repairer;
import com.example.repair_station.entities.User;
import com.example.repair_station.enums.Role;
import com.example.repair_station.enums.Type;
import com.example.repair_station.exception.BadCredentialsException;
import com.example.repair_station.exception.NotFoundException;
import com.example.repair_station.mapper.interfaces.CarsMapper;
import com.example.repair_station.repositories.CarsRepository;
import com.example.repair_station.repositories.RepairerRepository;
import com.example.repair_station.service.interfaces.AuthenticateService;
import com.example.repair_station.service.interfaces.CarsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarsServiceImpl implements CarsService {

    private final CarsRepository carsRepository;
    private final CarsMapper carsMapper;
    private RepairerRepository repairerRepository;
    private final AuthenticateService authenticateService;

    @Override
    public void add(CarsRequest carsRequest, String token){
        if (carsRepository.findByNumber(carsRequest.getNumber()).isPresent())
            throw new NotFoundException("book with this transcript is already exist!: "+carsRequest.getNumber(),
                    HttpStatus.BAD_REQUEST);
        if (!authenticateService.getUsernameFromToken(token).getRole().equals(Role.ADMIN))
            throw new BadCredentialsException("this function only for admin!");

        Car car=new Car();
        car.setModel(Type.valueOf(carsRequest.getModel()));
        car.setAge(carsRequest.getAge());
        car.setNumber(carsRequest.getNumber());

        carsRepository.save(car);
    }

    @Override
    public void delete(Long id){
        Optional<Car>car=carsRepository.findById(id);
        if(car.isEmpty()){
            System.out.println("car by id: "+id+" is empty");
        }else{
            carsRepository.deleteById(id);
        }
    }

    @Override
    public void update(Long id, CarsRequest carsRequest){
        Optional<Car>car=carsRepository.findById(id);
        if(car.isEmpty()){
            System.out.println("car by id: "+id+" is empty");
        }else{
            car.get().setModel(Type.valueOf(carsRequest.getModel()));
            car.get().setAge(carsRequest.getAge());
            car.get().setNumber(carsRequest.getNumber());

            carsRepository.save(car.get());
        }
    }

    @Override
    public CarsResponse find(Long id){
        Optional<Car>car=carsRepository.findById(id);
        if(car.isEmpty()){
            System.out.println("car by id: "+id+" is empty");
            return null;
        }else{
            return carsMapper.toDto(car.get());
        }
    }

    @Override
    public List<CarsResponse>findAll(){
        return carsMapper.toDtos(carsRepository.findAll());
    }

    @Override
    public void register(CarsRequest carsRequest, Long repairerId){
        Car car=new Car();
        car.setModel(Type.valueOf(carsRequest.getModel()));
        car.setAge(carsRequest.getAge());
        car.setNumber(carsRequest.getNumber());

        Optional<Repairer>repairer=repairerRepository.findById(repairerId);
        List<Car>cars=new ArrayList<>();
        if (repairer.get().getRepairercars()!=null){
            cars = repairer.get().getRepairercars();
        }
        cars.add(car);
        repairer.get().setRepairercars(cars);

        carsRepository.save(car);
    }

    public void drop(Long repairerId,Long id){
        Optional<Repairer>repairer=repairerRepository.findById(repairerId);
        if(repairer.isEmpty())
            throw new NotFoundException("repairer by this id is empty", HttpStatus.BAD_GATEWAY);
        Optional<Car>car=carsRepository.findById(id);
        if(car.isEmpty())
            throw new NotFoundException("car by this id is empty",HttpStatus.BAD_GATEWAY);

        List<Car>cars=new ArrayList<>();
        if (repairer.get().getRepairercars()!=null){
            cars = repairer.get().getRepairercars();
        }
        cars.add(car.get());
        repairer.get().setRepairercars(cars);

        carsRepository.save(car.get());
    }
}