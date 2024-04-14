package com.example.repair_station.mapper.interfaces;

import com.example.repair_station.dto.customer.CustomerResponse;
import com.example.repair_station.dto.repairer.RepairerResponse;
import com.example.repair_station.entities.Customer;
import com.example.repair_station.entities.Repairer;

import java.util.List;

public interface CustomerMapper {

    CustomerResponse toDto(Customer customer);

    List<CustomerResponse> toDtos(List<Customer>all);
}
