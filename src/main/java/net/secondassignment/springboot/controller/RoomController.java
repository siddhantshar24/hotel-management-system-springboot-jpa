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

import net.secondassignment.springboot.entity.Room;
import net.secondassignment.springboot.exception.ResourceNotFoundException;
import net.secondassignment.springboot.repository.RoomRepository;

@RestController
@RequestMapping("/api/rooms")

public class RoomController {
	
	@Autowired
	private RoomRepository roomRepository;
	
	//get all users
	@GetMapping
	public List<Room> getAllUsers()
	{
		return this.roomRepository.findAll();
	}
	
	
	//get user by id
	@GetMapping("/{id}")
	public Room getUserById(@PathVariable (value="id")long userId) 
	{
		return this.roomRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("Not Found"));
	}
	
	//create user
	@PostMapping
	public Room createUser(@RequestBody Room room)
	{ 
		return this.roomRepository.save(room);
	}
	
	//update user
	@PutMapping("/{id}")
	public Room updateUser(@RequestBody Room user,@PathVariable ("id") long userId)
	{
		Room existing= this.roomRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("Not Found"));
		existing.setId(user.getId());
		existing.setRoomstatus(user.getRoomstatus());
		return this.roomRepository.save(existing);
		
	}
	
	//delete user by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Room> deleteUser(@PathVariable ("id") long userId)
	{
		Room existing= this.roomRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("Not Found"));
		this.roomRepository.delete(existing);
		return ResponseEntity.ok().build();
	}
}
