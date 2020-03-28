package com.feliser.colorTest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ColorTestController {
	@GetMapping("/test")
	public String getTest(Model model,
			@RequestParam(value = "leftColor", required = false, defaultValue = "Green") String leftColor,
			@RequestParam(value = "rightColor", required = false, defaultValue = "Yellow") String rightColor) {
		model.addAttribute("leftColor", leftColor);
		model.addAttribute("rightColor", rightColor);
		return "test"; // returns the test.jsp view
	}
}