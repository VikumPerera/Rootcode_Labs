package com.example.rootcode.dto;

import com.example.rootcode.entity.GDP;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GDPDto {
	
	private String country;
	private String alpha3;
	private int year;
	private double value;
	
}
