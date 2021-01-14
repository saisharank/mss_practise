package com.example.po;

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
public class PoController {
	@Autowired
	public Poservice poservice;
	
	@PostMapping("/poinsert")
	public Map insertpo(@RequestBody Po po) {
		Map additem = null;
				try {
			additem = poservice.insertPo(po);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
				return additem;
	}
	@CrossOrigin
	@PutMapping("/poupdate")
	public Map update(@RequestBody Po po) {
		return poservice.update(po);
	}

	
	@CrossOrigin
	@GetMapping("/poget")
	public List get(@RequestBody Po po) {
		return poservice.get(po.getPoid());
	}

	@CrossOrigin
	@GetMapping("/pogetAll")
	public List getAll() {
		return poservice.getAll();
	}

	}