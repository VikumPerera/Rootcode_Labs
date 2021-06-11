package com.example.rootcode.controller;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rootcode.dto.GDPDto;
import com.example.rootcode.exception.GDPGrowthRateNotFoundException;
import com.example.rootcode.service.GDPGrowthRateService;

@RestController
public class GDPGrowthRateController {
	
	@Autowired
	private GDPGrowthRateService gDPGrowthRateService;
	
	private final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(GDPGrowthRateController.class);
	
	@GetMapping("/growthRate")
	public GDPDto getGrowthrateByYearAndCountryCode(
			@PathParam(value = "year") String year,
			@PathParam(value = "alphaCode") String alphaCode) throws GDPGrowthRateNotFoundException {
		
		LOGGER.info("Inside getGrowthrateByYearAndCountryCode of GDPGrowthRateController");
		
		return gDPGrowthRateService.getGrowthrateByYearAndCountryCode(year, alphaCode);
	}

}
