package com.avisys.cim;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface CustomerMobileNoRepository extends JpaRepository<Customer_MobileNo, Integer> 
{

	@Query("SELECT c FROM Customer_MobileNo c WHERE c.mobile_number = :mobno")
	Customer_MobileNo getCustomerByNumber(@Param("mobno") String mobno);
}
