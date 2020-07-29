package com.example.demo.service;

import com.example.demo.entity.Customer;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ServiceCustomer {
public List<Customer> listall();
Optional<Customer> findbyid(long id);
public  Customer CUSTOMER(long id);
  void save(Customer customer);
  void remove(long id);
    void delete(Customer customer);
}
