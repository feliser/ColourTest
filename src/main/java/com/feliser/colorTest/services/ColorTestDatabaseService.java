package com.feliser.colorTest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.feliser.colorTest.models.ColorTestDatabaseModel;
import com.feliser.colorTest.models.ColorTestDatabaseRequestModel;
import com.feliser.colorTest.repositories.ColorTestRepository;

@Service
public class ColorTestDatabaseService {
	@Autowired
	private ColorTestRepository colorTestRepository;

	public ResponseEntity uploadScore(ColorTestDatabaseRequestModel request) {
		if (request.getLeftColor().equals(request.getRightColor())) {
			// LeftColor and RightColor are the same
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request");
		}
		if (!(request.getLeftColor().equals("Green") || request.getLeftColor().equals("Cyan")
				|| request.getLeftColor().equals("Blue") || request.getLeftColor().equals("Purple")
				|| request.getLeftColor().equals("Magenta") || request.getLeftColor().equals("Red")
				|| request.getLeftColor().equals("Orange") || request.getLeftColor().equals("Yellow")
				|| request.getLeftColor().equals("Lime") || request.getLeftColor().equals("White")
				|| request.getLeftColor().equals("Black")) || !(request.getRightColor().equals("Green") || request.getRightColor().equals("Cyan")
				|| request.getRightColor().equals("Blue") || request.getRightColor().equals("Purple")
				|| request.getRightColor().equals("Magenta") || request.getRightColor().equals("Red")
				|| request.getRightColor().equals("Orange") || request.getRightColor().equals("Yellow")
				|| request.getRightColor().equals("Lime") || request.getRightColor().equals("White")
				|| request.getRightColor().equals("Black"))) {
			// LeftColor or RightColor have invalid values
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request");
		}
		ColorTestDatabaseModel m = new ColorTestDatabaseModel();
		m.setScore(request.getScore());
		m.setLeftColor(request.getLeftColor());
		m.setRightColor(request.getRightColor());
		colorTestRepository.save(m);
		return ResponseEntity.status(HttpStatus.OK).body("OK");
	}
}
