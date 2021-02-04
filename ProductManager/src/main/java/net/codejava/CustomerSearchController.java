package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerSearchController {

	@Autowired
	private CustomerSearchService service; 
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<CustomerSearch> listCustomers = service.listAll();
		model.addAttribute("listCustomers", listCustomers);
		
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewCustomerPage(Model model) {
		CustomerSearch cs = new CustomerSearch();
		model.addAttribute("cs", cs);
		
		return "new_product";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") CustomerSearch cs) {
		service.save(cs);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_customer");
		CustomerSearch customer = service.get(id);
		mav.addObject("customer", customer);
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";		
	}
}
