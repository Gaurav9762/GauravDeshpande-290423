package com.avisys.cim;



import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.avisys.cim.Customer;

@Entity
@Table(name = "customer_mobileno")
public class Customer_MobileNo 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int mobid;
	
	@Column
	String mobile_number;
	
	
	
	@JsonIgnoreProperties("custmob")
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name="customerid")
	@OnDelete(action = OnDeleteAction.CASCADE)
	Customer customeridobj;



	public Customer_MobileNo() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Customer_MobileNo(int mobid, String mobile_number, Customer customeridobj) {
		super();
		this.mobid = mobid;
		this.mobile_number = mobile_number;
		this.customeridobj = customeridobj;
	}



	public Customer_MobileNo(String mobile_number, Customer customeridobj) {
		super();
		this.mobile_number = mobile_number;
		this.customeridobj = customeridobj;
	}



	public int getMobid() {
		return mobid;
	}



	public void setMobid(int mobid) {
		this.mobid = mobid;
	}



	public String getMobile_number() {
		return mobile_number;
	}



	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}


	@JsonIgnore
	public Customer getCustomeridobj() {
		return customeridobj;
	}


//	@JsonIgnore
	public void setCustomeridobj(Customer customeridobj) {
		this.customeridobj = customeridobj;
	}



	@Override
	public String toString() {
		return "Customer_MobileNo [mobid=" + mobid + ", mobile_number=" + mobile_number + ", customeridobj="
				+ customeridobj + "]";
	}


	
	
}
