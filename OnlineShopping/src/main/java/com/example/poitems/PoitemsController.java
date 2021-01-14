package com.example.poitems;

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
public class PoitemsController {
	@Autowired
	public Poitemsservice Poitemsservice;
	
	@PostMapping("/Poitemsinsert")
	public Map insertPoitems(@RequestBody Poitems poitems) {
		Map additem = null;
				try {
			additem = Poitemsservice.insertPoitems(poitems);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
				return additem;
	}
	@CrossOrigin
	@PutMapping("/Poitemsupdate")
	public Map update(@RequestBody Poitems poitems) {
		return Poitemsservice.update(poitems);
	}

	
	@CrossOrigin
	@GetMapping("/Poitemsget")
	public List get(@RequestBody Poitems poitems) {
		return Poitemsservice.get(poitems.getPoid());
	}

	@CrossOrigin
	@GetMapping("/PoitemsgetAll")
	public List getAll() {
		return Poitemsservice.getAll();
	}

	}