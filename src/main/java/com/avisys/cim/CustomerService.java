package com.avisys.cim;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerrepo;

	public List<Customer> getAllCustomers() {
		
		return customerrepo.findAll();
	}

	public List<Customer> getCustomerByFirstName(String fname) {
		
		return customerrepo.getCustomerByFirstName(fname);
	}
	public List<Customer> getCustomerByLastName(String lname) {
		
		return customerrepo.getCustomerByLastName(lname);
	}

	public Customer getCustomerByNumber(String mobno) {
		
		return customerrepo.getCustomerByNumber(mobno);
	}

}
