package net.secondassignment.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rooms")

public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="status")
	private String roomstatus;
	
	public Room()
	{
		
	}
	
	public Room(String roomstatus) {
		super();
		this.roomstatus = roomstatus;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoomstatus() {
		return roomstatus;
	}

	public void setRoomstatus(String roomstatus) {
		this.roomstatus = roomstatus;
	}
	
	

	
	

}
