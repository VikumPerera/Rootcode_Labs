package com.example.rootcode.tranformer;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.rootcode.dto.GDPDto;
import com.example.rootcode.entity.GDP;

@Component
public class GDPTransformer {

	public GDPDto transformDomainToDTO(Optional<GDP> gdp) {
		GDPDto gDPDto = new GDPDto();
		
		gDPDto.setCountry(gdp.get().getCountry());
		gDPDto.setAlpha3(gdp.get().getAlpha3());
		gDPDto.setYear(gdp.get().getYear());
		gDPDto.setValue(gdp.get().getValue());
		
		return gDPDto;
	}
	
}
