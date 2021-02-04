package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerSearchService {

	@Autowired
	private CustomerSearchRepository repo;
	
	public List<CustomerSearch> listAll() {
		return repo.findAll();
	}
	
	public void save(CustomerSearch customer) {
		repo.save(customer);
	}
	
	public CustomerSearch get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
}
