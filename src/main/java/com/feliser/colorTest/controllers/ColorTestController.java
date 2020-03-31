package com.feliser.colorTest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.feliser.colorTest.models.ColorTestDatabaseRequestModel;
import com.feliser.colorTest.services.ColorTestDatabaseService;

@Controller
public class ColorTestController {
	
	@Autowired
	ColorTestDatabaseService databaseService;
	
	@GetMapping("/test")
	public String getTest(Model model,
			@RequestParam(value = "leftColor", required = false, defaultValue = "Green") String leftColor,
			@RequestParam(value = "rightColor", required = false, defaultValue = "Yellow") String rightColor) {
		model.addAttribute("leftColor", leftColor);
		model.addAttribute("rightColor", rightColor);
		return "test"; // returns the test.jsp view
	}
	
	@GetMapping(value="/results")
	public String getResults(Model model, 
			@RequestParam(value = "leftColor", required = true) String leftColor, 
			@RequestParam(value = "rightColor", required = true) String rightColor, 
			@RequestParam(value = "score", required = true) double score) {
		model.addAttribute("leftColor", leftColor);
		model.addAttribute("rightColor", rightColor);
		model.addAttribute("score", score);
		model.addAttribute("average", databaseService.getAverage(leftColor, rightColor));
		return "results"; // returns the results.jsp view
	}
}