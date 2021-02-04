package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Customer> listCustomers = service.listAll();
		model.addAttribute("listCustomers", listCustomers);
		return "index";
	}
	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "new";
	}
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("Customer") Customer customer) {
		service.save(customer);
		
		return "redirect:/";
	}
	@RequestMapping("/edit/{cid}")
	public ModelAndView showEditCustomerPage(@PathVariable(name="cid") int cid) {
		ModelAndView mav = new ModelAndView("edit");
		Customer customer = service.get(cid);
		mav.addObject("customer", customer);
		return mav;
	}
	@RequestMapping("/delete/{cid}")
	public String deleteCustomer(@PathVariable(name="cid") int cid) {
		service.delete(cid);
		return "redirect:/";
	}
}
