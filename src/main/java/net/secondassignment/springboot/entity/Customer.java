package net.secondassignment.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="room_number")
	private long roomno;
	
	


	public Customer()
	{
		
	}
	
	public Customer(String firstName, String lastName,long roomno) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.roomno= roomno;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public long getRoomno() {
		return roomno;
	}

	public void setRoomno(long roomno) {
		this.roomno = roomno;
	}
	
}
