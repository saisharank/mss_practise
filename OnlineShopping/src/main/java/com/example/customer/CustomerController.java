package com.example.customer;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CustomerController {
	@Autowired
	public Customerservice customerservice;
	
	@PostMapping("/customerinsert")
	public Map insertCustomers(@RequestBody Customer customer) {
		Map additem = null;
				try {
			additem = customerservice.insertCustomers(customer);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
				return additem;
	}
	@CrossOrigin
	@PutMapping("/customerupdate")
	public Map update(@RequestBody Customer customer) {
		return customerservice.update(customer);
	}

	
	@CrossOrigin
	@GetMapping("/customerget")
	public List get(@RequestBody Customer customer) {
		return customerservice.get(customer.getCustomerid());
	}

	@CrossOrigin
	@GetMapping("/customergetAll")
	public List getAll() {
		return customerservice.getAll();
	}

	}