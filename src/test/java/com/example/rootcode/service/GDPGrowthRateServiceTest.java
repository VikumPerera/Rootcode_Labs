//package com.example.rootcode.service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.util.Optional;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import com.example.rootcode.dto.GDPDto;
//import com.example.rootcode.entity.GDP;
//import com.example.rootcode.exception.GDPGrowthRateNotFoundException;
//import com.example.rootcode.repository.GDPRepository;
//
//class GDPGrowthRateServiceTest {
//	
//	@Autowired
//	private GDPGrowthRateService gDPGrowthRateService;
//	
//	@MockBean
//	GDPRepository gDPRepository;
//	
//	@BeforeEach
//	void setup() {
//		GDP gdp = GDP.builder()
//				.id(1L)
//				.country("Afghanistan")
//				.alpha3("AFG")
//				.year(2006)
//				.value(658000000d)
//				.build();
//		
//		
//		Mockito.when(gDPRepository.findByAlpha3AndYear("AFG", 2006)).thenReturn(Optional.of(gdp));
//	}
//	
//
//	@Test
//	public void  getGrowthrateByYearAndCountryCode() throws GDPGrowthRateNotFoundException {
//		GDPDto gdpDto = GDPDto.builder()
//				.country("Afghanistan")
//				.alpha3("AFG")
//				.year(2006)
//				.value(658000000d)
//				.build();
//		
//		GDPDto gdpFromDB =  gDPGrowthRateService.getGrowthrateByYearAndCountryCode("AFG", "2006");
//		assertEquals(gdpFromDB.getCountry(), gdpDto.getCountry());
//	}
//
//}
