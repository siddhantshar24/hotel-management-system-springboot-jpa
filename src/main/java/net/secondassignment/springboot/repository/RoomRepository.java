package net.secondassignment.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.secondassignment.springboot.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

}
