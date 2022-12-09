package net.secondassignment.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.secondassignment.springboot.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{

}
