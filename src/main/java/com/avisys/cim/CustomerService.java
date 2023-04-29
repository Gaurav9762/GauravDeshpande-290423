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

	public Customer save(Customer p) {
		// TODO Auto-generated method stub
		return customerrepo.save(p);
	}

	//This method is used for checking whether the customer exists in database for provided customer's mobile
	//number and returns boolean.
	public boolean existsByMobileNumber(String mobileNumber) {
		// TODO Auto-generated method stub
		Customer c = customerrepo.getCustomerByNumber(mobileNumber);
		
		
		if(c != null)
		{
			return true;
		}else
		{
		  return false;	
		}
		
	}

}
