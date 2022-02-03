package com.zee.zee5app.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Register;

@Repository
public interface UserRepository extends JpaRepository<Register, String> {

	// Custom JPA method ===> We will not write any definition, just the signature(declaration)
	Boolean existsByEmailAndContactNumber(String email, BigDecimal contactNumber);
	//Boolean existsByContactNumber(BigDecimal contactNumber);
	
}
