package com.example.repair_station.service.interfaces;

import com.example.repair_station.dto.customer.CustomerRequest;
import com.example.repair_station.dto.customer.CustomerResponse;
import com.example.repair_station.dto.repairer.RepairerRequest;

import java.util.List;

public interface CustomerService {
    CustomerResponse find(Long id, String token);

    void delete(Long id);

    List<CustomerResponse> getAll();

    void update(Long id, CustomerRequest customerRequest);
}
