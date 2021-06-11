package com.example.rootcode.controller;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rootcode.service.ReadCSVAndWrtiteToDBService;

@RestController
public class SaveDataController {
	
	@Autowired
	private ReadCSVAndWrtiteToDBService readCSVAndWrtiteToDB;
	
	private final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(SaveDataController.class);
	
	@PostMapping("/saveData")
	public String saveData(@PathParam(value = "filename") String filename) {
		LOGGER.info("Inside saveData of SaveDataController");
		return readCSVAndWrtiteToDB.saveDataToDB(filename);
	}

}
