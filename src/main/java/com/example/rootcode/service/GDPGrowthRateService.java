package com.example.rootcode.service;

import com.example.rootcode.dto.GDPDto;
import com.example.rootcode.exception.GDPGrowthRateNotFoundException;

public interface GDPGrowthRateService {

	GDPDto getGrowthrateByYearAndCountryCode(String year, String alphaCode) throws GDPGrowthRateNotFoundException;

}
