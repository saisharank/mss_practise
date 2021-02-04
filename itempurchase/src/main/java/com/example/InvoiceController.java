package com.example;

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
public class InvoiceController {
	@Autowired
	public InvoiceService service;
	
	
	@PostMapping("/iteminsert")
	public Map insertItems(@RequestBody Item item) {
		Map additem = null;
				try {
			additem = service.insertItems(item);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
				return additem;
	}
	@CrossOrigin
	@PutMapping("/itemupdate")
	public Map itemupdate(@RequestBody Item item) {
		return service.itemupdate(item);
	}
	
	@CrossOrigin
	@GetMapping("/itemget")
	public List get(@RequestBody Item item) {
		return service.itemget(item.getItem_id());
	}
	
	@CrossOrigin
	@GetMapping("/itemgetAll")
	public List itemgetAll() {
		return service.itemgetAll();
	}
	
	@PostMapping("/customerinsert")
	public Map insertCustomers(@RequestBody Customer customer) {
		Map additem = null;
				try {
			additem = service.insertCustomers(customer);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
				return additem;
	}
	@CrossOrigin
	@PutMapping("/customerupdate")
	public Map updateCustomer(@RequestBody Customer customer) {
		return service.updateCustomer(customer);
	}

	
	@CrossOrigin
	@GetMapping("/customerget")
	public List getCustomer(@RequestBody Customer customer) {
		return service.getCustomer(customer.getCustomer_id());
	}

	@CrossOrigin
	@GetMapping("/customergetAll")
	public List getAllcustomer() {
		return service.getAllcustomer();
	}
	
	@PostMapping("/invoiceinsert")
	public Map insertInvoice(@RequestBody Invoice invoice) {
		Map additem = null;
				try {
			additem = service.insertInvoice(invoice);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
				return additem;
	}
	
	@CrossOrigin
	@GetMapping("/invoicegetitem")
	public List invoicegetitem(@RequestBody Invoice invoice) {
		return service.invoicegetitem(invoice.getItem_id());
	}
	
	@CrossOrigin
	@GetMapping("/invoicegetcustomer")
	public List invoicegetcustomer(@RequestBody Invoice invoice) {
		return service.invoicegetcustomer(invoice.getCustomer_id());
	}
	
	@CrossOrigin
	@GetMapping("/invoicegetall")
	public List invoicegetall(@RequestBody Invoice invoice) {
		return service.invoicegetall();
	}
	@CrossOrigin
	@GetMapping("/login")
	public List login(@RequestBody Customer customer) {
		return service.login(customer);
	}
}
