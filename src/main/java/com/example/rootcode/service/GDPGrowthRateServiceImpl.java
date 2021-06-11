package com.example.rootcode.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rootcode.dto.GDPDto;
import com.example.rootcode.entity.CountryCode;
import com.example.rootcode.entity.GDP;
import com.example.rootcode.exception.GDPGrowthRateNotFoundException;
import com.example.rootcode.repository.CountryCodeRepository;
import com.example.rootcode.repository.GDPRepository;
import com.example.rootcode.tranformer.GDPTransformer;

@Service
public class GDPGrowthRateServiceImpl implements GDPGrowthRateService{
	
	@Autowired
	private GDPRepository gDPRepository;
	
	@Autowired
	private CountryCodeRepository countryCodeRepository;
	
	@Autowired
	GDPTransformer gDPTransformer;

	@Override
	public GDPDto getGrowthrateByYearAndCountryCode(String year, String alphaCode) throws GDPGrowthRateNotFoundException {
		Optional<GDP> gdp = null ;
		if (alphaCode.length() == 2) {
			Optional <CountryCode> countryCode = countryCodeRepository.findByAlpha2(alphaCode);
			
			if (!countryCode.isPresent()) {
				throw new GDPGrowthRateNotFoundException("Country Code Not Found..");
			}
			
			gdp = gDPRepository.findByAlpha3AndYear(countryCode.get().getAlpha3() ,Integer.parseInt(year));
			
			if (!gdp.isPresent()) {
				throw new GDPGrowthRateNotFoundException("GDP Growth Rate not found for given parameters..");
			}
		} else {
			
			gdp = gDPRepository.findByAlpha3AndYear(alphaCode ,Integer.parseInt(year));
			
			if (!gdp.isPresent()) {
				throw new GDPGrowthRateNotFoundException("GDP Growth Rate not found for given parameters..");
			}
			
			
		}
		
		return gDPTransformer.transformDomainToDTO(gdp);
		
	}
	
}
