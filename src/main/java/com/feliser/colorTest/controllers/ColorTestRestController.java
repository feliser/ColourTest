package com.feliser.colorTest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feliser.colorTest.models.ColorTestDatabaseRequestModel;
import com.feliser.colorTest.services.ColorTestDatabaseService;

@RestController
public class ColorTestRestController {
	
	@Autowired
	ColorTestDatabaseService databaseService;
	
	@PostMapping(value="/submit", consumes="application/json")
	public ResponseEntity uploadResults(@RequestBody ColorTestDatabaseRequestModel request) {
		return databaseService.uploadScore(request);
	}
}