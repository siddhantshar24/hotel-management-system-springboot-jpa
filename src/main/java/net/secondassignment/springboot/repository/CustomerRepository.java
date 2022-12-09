package net.secondassignment.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.secondassignment.springboot.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
