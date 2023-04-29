package com.avisys.cim;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	

	//creating customer service object 
	// I have used @Autowired annotation for dependency injection 
	@Autowired
	CustomerService custservice;
	
	
	//1. Get Customer information over an REST API call
	
	//This method is for fetching all customer details .
	@GetMapping("/fetchAllCustomer")
	public List<Customer> getAllCustomers()
	{
		
		List< Customer> list = custservice.getAllCustomers();
		for (Customer c : list) {
			
			System.out.println(c);
		}
		return list;
	}
	
	//This method is for fetching customer details by partially matching the pattern of first name.
	
	//For this method in repository I have written JPQL query and in that query I have use like clause for 
	// matching pattern of first name as per users requirement
	@GetMapping("/fetchByFirstName")
	public List<Customer> getCustomerByFirstName(@RequestParam("fname") String fname)
	{
		List<Customer> cust =custservice.getCustomerByFirstName(fname);
		
		System.out.println(cust);
		System.out.println("fname: "+fname);
		return cust ;
	}
	
	//This method is for fetching customer details by partially matching the pattern of LastName.
	
	//For this method in repository I have written JPQL query and in that query I have used like clause for 
	// matching pattern of LastName as per users requirement
	@GetMapping("/fetchByLastName")
	public List<Customer> getCustomerByLastName(@RequestParam("lname") String lname)
	{
		List<Customer> cust =custservice.getCustomerByLastName(lname);
		
		System.out.println(cust);
		System.out.println("fname: "+lname);
		return cust ;
	}
	
	//This method is for fetching customer details by using mobile number.
	
	//For this method I have written JPQL query in repository . 
	@GetMapping("/fetchByNumber")
	public Customer getCustomerByNumber(@RequestParam("mobno") String mobno)
	{
		Customer cust =custservice.getCustomerByNumber(mobno);
		
		System.out.println(cust);
		System.out.println("fname: "+mobno);
		return cust ;
	}
}
