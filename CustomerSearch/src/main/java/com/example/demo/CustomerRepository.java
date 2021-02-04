package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
//	@Query("SELECT cs from customer cs where cs.cname LIKE %?1%")
//	public List<Customer> findAll(String keyword);
}
