package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArithmeticController {
	@Autowired
	public DivisionService ds;
	@Autowired
	public AdditionService as;
	@Autowired
	public SubtractionService ss;
	@Autowired
	public MultiplicationService ms;
	
	@PostMapping(value="/division")
	public String division(@RequestBody Numbers n) {
		return ds.division(n);
	}
	@PostMapping(value="/add")
	public String add(@RequestBody Numbers n) {
		return as.add(n);
	}
	@PostMapping(value="/sub")
	public String sub(@RequestBody Numbers n) {
		return ss.sub(n);
	}
	@PostMapping(value="/mul")
	public String mul(@RequestBody Numbers n) {
		return ms.mul(n);
	}
}
