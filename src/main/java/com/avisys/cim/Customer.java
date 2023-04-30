package com.avisys.cim;


import java.util.Set;



import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;

import jakarta.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

	//In schema auto_increment was not present for "id" column so ignored the @GenratedValue for id
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;

	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;
	
//	@JsonIgnoreProperties("customeridobj")
	@OneToMany( mappedBy = "customeridobj",fetch = FetchType.EAGER)
	@Cascade(value=CascadeType.ALL)
	Set<Customer_MobileNo> custmob;


	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer(int id, String firstName, String lastName, Set<Customer_MobileNo> custmob) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.custmob = custmob;
	}


	public Customer(String firstName, String lastName, Set<Customer_MobileNo> custmob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.custmob = custmob;
	}

	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


//	@JsonIgnore
	public Set<Customer_MobileNo> getCustmob() {
		return custmob;
	}


	public void setCustmob(Set<Customer_MobileNo> custmob) 
	{
		for(Customer_MobileNo p : custmob)
			p.setCustomeridobj(this);
		
		this.custmob = custmob;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", custmob=" + custmob + "]";
	}
	
	
	
}
/*
  {
    
        
         "firstName": "Alan",
         "lastName": "Smith",
        "custmob": [
            {

            "mobile_number": "0123456789"
            },
            {

            "mobile_number": "7896547894"
         }
        ]

    
}*/
