package com.example.repair_station.service.impl;

import com.example.repair_station.dto.customer.CustomerRequest;
import com.example.repair_station.dto.customer.CustomerResponse;
import com.example.repair_station.dto.repairer.RepairerRequest;
import com.example.repair_station.dto.repairer.RepairerResponse;
import com.example.repair_station.entities.Customer;
import com.example.repair_station.entities.Repairer;
import com.example.repair_station.mapper.interfaces.CustomerMapper;
import com.example.repair_station.repositories.CustomerRepository;
import com.example.repair_station.service.interfaces.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;
    
    @Override
    public CustomerResponse find(Long id, String token) {
        Optional<Customer> customer=customerRepository.findById(id);
        if(customer.isEmpty()){
            System.out.println("repairer by id: "+id+" is empty");
            return null;
        }else{
            CustomerResponse customerResponse=new CustomerResponse();
            return customerMapper.toDto(customer.get());
        }
    }

    @Override
    public void delete(Long id) {
        Optional<Customer> customer=customerRepository.findById(id);
        if(customer.isEmpty()){
            System.out.println("customer by id: "+id+" is empty");
        }else{
            customerRepository.deleteById(id);
        }
    }

    @Override
    public List<CustomerResponse> getAll() {
        return customerMapper.toDtos(customerRepository.findAll());
    }

    @Override
    public void update(Long id, CustomerRequest customerRequest) {
        Optional<Customer>customer=customerRepository.findById(id);
        if(customer.isEmpty()){
            System.out.println("Customer by id: "+id+" is empty");
        }else{
            customer.get().setName(customerRequest.getName());

            customerRepository.save(customer.get());
        }
    }


}
