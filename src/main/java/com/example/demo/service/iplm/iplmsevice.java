package com.example.demo.service.iplm;

import com.example.demo.entity.Customer;
import com.example.demo.repository.RepositoryCustomer;
import com.example.demo.service.ServiceCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class iplmsevice implements ServiceCustomer {
	@Autowired
    RepositoryCustomer repo;

	@Override
	public List<Customer> listall() {
		
		return repo.findAll();
	}

	@Override
	public Optional<Customer> findbyid(long id ) {
		return repo.findById(id);
	}

	@Override
	public Customer CUSTOMER(long id) {
		return repo.findById(id).get();
	}


	@Override
	public void save(Customer customer) {
		repo.save(customer);

	}

	@Override
	public void remove(long id) {
		repo.deleteById(id);
	}

}
