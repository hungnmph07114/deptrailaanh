package com.example.demo.repository;

import com.example.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositoryCustomer extends JpaRepository<Customer, Long> {

}
