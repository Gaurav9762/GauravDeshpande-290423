package com.avisys.cim;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Transactional
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

	

	@Query("SELECT c FROM Customer c WHERE c.firstName LIKE %:fname%")
	List<Customer> getCustomerByFirstName( @Param("fname") String fname);

	@Query("SELECT c FROM Customer c WHERE c.lastName LIKE %:lname%")
	List<Customer> getCustomerByLastName(@Param("lname") String lname);

//	@Query("SELECT c FROM Customer c WHERE c.mobileNumber = :mobno")
//	Customer getCustomerByNumber(@Param("mobno") int mobno);


	
	

}
