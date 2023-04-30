package com.avisys.cim;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerrepo;
	
	@Autowired
	CustomerMobileNoRepository custmobrepo;

	public List<Customer> getAllCustomers() {
		
		return customerrepo.findAll();
	}

	public List<Customer> getCustomerByFirstName(String fname) {
		
		return customerrepo.getCustomerByFirstName(fname);
	}
	public List<Customer> getCustomerByLastName(String lname) {
		
		return customerrepo.getCustomerByLastName(lname);
	}

//	public Customer getCustomerByNumber(int mobno) {
//		
//		return customerrepo.getCustomerByNumber(mobno);
//	}

	//In this method first we save object in customer table and we have multiple mobile numbers 
	// for one customer so in for loop we are inserting record in Customer_MobileNo for each mobile number
	//in entity classes we have used association to save multiple mobile number for one customer so we have 
	//created another table for mobile number.
	public Customer save(Customer p) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		customer.setFirstName(p.getFirstName());
		customer.setLastName(p.getLastName());
		
		customer=customerrepo.save(customer);
		for(Customer_MobileNo custmob : p.getCustmob())
		{
			Customer_MobileNo cmob = new Customer_MobileNo();
			cmob.setMobile_number(custmob.getMobile_number());
			cmob.setCustomeridobj(customer);
			custmobrepo.save(cmob);
			
		}
		return customer;
	}

	//This method is used for checking whether the customer exists in database for provided customer's mobile
	//number and returns boolean.
	public boolean existsByMobileNumber(String mobileNumber) {
		// TODO Auto-generated method stub
		Customer_MobileNo c = custmobrepo.getCustomerByNumber(mobileNumber);
		
		
		if(c != null)
		{
			return true;
		}else
		{
		  return false;	
		}
		
	}

	public List<Customer_MobileNo> fetchMobileNo() {
		
		
		return custmobrepo.findAll();
	}

}
