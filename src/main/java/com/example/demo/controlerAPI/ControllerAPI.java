package com.example.demo.controlerAPI;

import com.example.demo.entity.Customer;
import com.example.demo.service.ServiceCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class ControllerAPI {
	   @Autowired
	ServiceCustomer sevice;
	   @GetMapping("/customer")
	   public ResponseEntity<List<Customer>>listall(){
		 List<Customer> list = sevice.listall();
		 if (list.isEmpty()) {
			return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		   return new ResponseEntity<>(list,HttpStatus.OK);
	   }
	   @DeleteMapping("/customer/{id}")
	public ResponseEntity<Customer>delete(@PathVariable("id") long id){
	   	Optional<Customer> customer = sevice.findbyid(id);
	   	if (!customer.isPresent()){
	   		return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
sevice.delete(customer.get());
		   return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
	   }
@PostMapping("/customer")
	public ResponseEntity<Customer>add(@RequestBody Customer customer)
{
	sevice.save(customer);
}
}
