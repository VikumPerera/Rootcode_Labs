package com.example.rootcode.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.rootcode.entity.CountryCode;
@Repository
public interface CountryCodeRepository extends JpaRepository<CountryCode, Long>{
	
	@Query("Select COUNT(*) from CountryCode")
	int findCountryCodeEmptyOrNot();
	
	@Query("Select c from CountryCode c where c.alpha2 = :alpha2")
	Optional <CountryCode> findByAlpha2(String alpha2);
	
}
