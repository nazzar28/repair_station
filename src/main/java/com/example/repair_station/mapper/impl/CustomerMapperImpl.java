package com.example.repair_station.mapper.impl;

import com.example.repair_station.dto.cars.CarsResponse;
import com.example.repair_station.dto.customer.CustomerResponse;
import com.example.repair_station.entities.Car;
import com.example.repair_station.entities.Customer;
import com.example.repair_station.mapper.interfaces.CustomerMapper;

import java.util.ArrayList;
import java.util.List;

public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerResponse toDto(Customer customer) {
        CustomerResponse customerResponse=new CustomerResponse();
        customerResponse.setId(customer.getId());
        customerResponse.setName(customer.getName());

        return customerResponse;
    }

    @Override
    public List<CustomerResponse> toDtos(List<Customer> all) {
        List<CustomerResponse>customerResponses=new ArrayList<>();
        for(Customer customer:all){
            customerResponses.add(toDto(customer));
        }
        return customerResponses;
    }
}
