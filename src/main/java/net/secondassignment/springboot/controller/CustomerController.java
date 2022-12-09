package net.secondassignment.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.secondassignment.springboot.entity.Customer;
import net.secondassignment.springboot.exception.ResourceNotFoundException;
import net.secondassignment.springboot.repository.CustomerRepository;





@RestController
@RequestMapping("/api/customers")

public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;	
	//get all users
	@GetMapping
	public List<Customer> getAllUsers()
	{
		return this.customerRepository.findAll();
	}
	
	
	//get user by id
	@GetMapping("/{id}")
	public Customer getUserById(@PathVariable (value="id")long customerId) 
	{   
		return this.customerRepository.findById(customerId).orElseThrow(()->new ResourceNotFoundException("Not Found"));
	}
	
	//create user
	@PostMapping
	public Customer createUser(@RequestBody Customer customer)
	{
		return this.customerRepository.save(customer);
	}
	
	//update user
	@PutMapping("/{id}")
	public Customer updateUser(@RequestBody Customer product,@PathVariable ("id") long productId)
	{
		Customer existing= this.customerRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException("Not Found"));
		existing.setId(product.getId());
		existing.setFirstName(product.getFirstName());
		existing.setLastName(product.getLastName());
		return this.customerRepository.save(existing);
		
	}
	
	//delete user by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Customer> deleteUser(@PathVariable ("id") long productId)
	{
		Customer existing= this.customerRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException("Not Found"));
		this.customerRepository.delete(existing);
		return ResponseEntity.ok().build();
	}
}
