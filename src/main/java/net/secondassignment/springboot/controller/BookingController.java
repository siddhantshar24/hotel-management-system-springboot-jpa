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

import net.secondassignment.springboot.entity.Booking;
import net.secondassignment.springboot.exception.ResourceNotFoundException;
import net.secondassignment.springboot.repository.BookingRepository;





@RestController
@RequestMapping("/api/bookings")

public class BookingController {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	//get all users
	@GetMapping
	public List<Booking> getAllUsers()
	{
		return this.bookingRepository.findAll();
	}
	
	
	//get user by id
	@GetMapping("/{id}")
	public Booking getUserById(@PathVariable (value="id")long bookingId) 
	{   
		return this.bookingRepository.findById(bookingId).orElseThrow(()->new ResourceNotFoundException("Not Found"));
	}
	
	//create user
	@PostMapping
	public Booking createUser(@RequestBody Booking product)
	{
		return this.bookingRepository.save(product);
	}
	
	//update user
	@PutMapping("/{id}")
	public Booking updateUser(@RequestBody Booking product,@PathVariable ("id") long productId)
	{
		Booking existing= this.bookingRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException("Not Found"));
		existing.setId(product.getId());
		existing.setFirstName(product.getFirstName());
		existing.setLastName(product.getLastName());
		existing.setRoomno(product.getRoomno());
		return this.bookingRepository.save(existing);
		
	}
	
	//delete user by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Booking> deleteUser(@PathVariable ("id") long productId)
	{
		Booking existing= this.bookingRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException("Not Found"));
		this.bookingRepository.delete(existing);
		return ResponseEntity.ok().build();
	}
}
