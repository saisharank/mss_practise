package com.example.item;

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
public class ItemController {
	@Autowired
	public Itemservice itemservice;
	
	@PostMapping("/iteminsert")
	public Map insertItems(@RequestBody Item item) {
		Map additem = null;
				try {
			additem = itemservice.insertItems(item);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
				return additem;
	}
	@CrossOrigin
	@PutMapping("/itemupdate")
	public Map update(@RequestBody Item item) {
		return itemservice.update(item);
	}

	
	@CrossOrigin
	@GetMapping("/itemget")
	public List get(@RequestBody Item item) {
		return itemservice.get(item.getId());
	}

	@CrossOrigin
	@GetMapping("/itemgetAll")
	public List getAll() {
		return itemservice.getAll();
	}

	}