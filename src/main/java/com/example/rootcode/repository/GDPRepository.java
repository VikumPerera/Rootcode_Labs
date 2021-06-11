package com.example.rootcode.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.rootcode.entity.GDP;
@Repository
public interface GDPRepository extends JpaRepository<GDP, Long>{
	
	@Query("Select COUNT(*) from GDP")
	int findGDPEmptyOrNot();
	
	@Query("Select g from GDP g where g.alpha3 = :alpha3 AND g.year = :year")
	Optional <GDP> findByAlpha3AndYear(String alpha3, int year);
	
}
