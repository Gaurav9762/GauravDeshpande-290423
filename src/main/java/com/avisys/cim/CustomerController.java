package com.avisys.cim;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		
		
		return cust ;
	}
	
	//This method is for fetching customer details by using mobile number.
	
	//For this method I have written JPQL query in repository .
	
	
//	********** this method will not work now because we have to change the code for 3rd requirement *******
	
//	@GetMapping("/fetchByNumber")
//	public Customer getCustomerByNumber(@RequestParam("mobno") int mobno)
//	{
//		Customer cust =custservice.getCustomerByNumber(mobno);
//		
//		System.out.println(cust);
//		System.out.println("fname: "+mobno);
//		return cust ;
//	
//	}
	
	//This method is for inserting new customer record.
	//If mobile number dosen't exists then record is added to database.
	//If mobile number already exists in database returns customized error message in response. 
	
	
	
	@PostMapping("/addCustomer")
	public ResponseEntity<String> addCustomer(@RequestBody Customer p)
	{
		for(Customer_MobileNo custmob : p.getCustmob())
		{
		
		if (custservice.existsByMobileNumber(custmob.getMobile_number())) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Unable to create Customer. Mobile number already present.");
	    }
		}
	    // Create new customer
	    Customer newCustomer = custservice.save(p);
	    return ResponseEntity.ok("Customer created successfully.");

		
//		return custservice.save(p);
		
	}
	
	//3. Modify the application to support multiple mobile number for a single customer.
	@GetMapping("/getMobnumber")
	public List<Customer_MobileNo>fetchMobileNo()
	{

		List< Customer_MobileNo> list = custservice.fetchMobileNo();
		
		return list;	
	}
//5. Ability to delete over REST API
//	@DeleteMapping("/deleteByMobileNumber")
//	public void deleteCustomerByMobileNumber(@RequestParam("mobno") String mobileNo)
//	{
//		custservice.deleteCustomerByMobileNumber(mobileNo);		
//	}
	
	
}
