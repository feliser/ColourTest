package com.feliser.colorTest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.feliser.colorTest.entities.ColorTestDatabaseScoreEntity;
import com.feliser.colorTest.entities.ColorTestDatabaseSumEntity;
import com.feliser.colorTest.models.ColorTestDatabaseRequestModel;
import com.feliser.colorTest.repositories.ColorTestScoreRepository;
import com.feliser.colorTest.repositories.ColorTestSumRepository;

@Service
public class ColorTestDatabaseService {
	static int MAX_ENTRIES = 1000;
	@Autowired
	private ColorTestScoreRepository colorTestScoreRepository;
	
	@Autowired
	private ColorTestSumRepository colorTestSumRepository;

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
				|| request.getLeftColor().equals("Black")) || !(request.getRightColor().equals("Green") 
				|| request.getRightColor().equals("Cyan") || request.getRightColor().equals("Blue") 
				|| request.getRightColor().equals("Purple") || request.getRightColor().equals("Magenta") 
				|| request.getRightColor().equals("Red") || request.getRightColor().equals("Orange") 
				|| request.getRightColor().equals("Yellow") || request.getRightColor().equals("Lime") 
				|| request.getRightColor().equals("White") || request.getRightColor().equals("Black"))) {
			// LeftColor or RightColor have invalid values
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request");
		}
		if(request.getScore() <= 0 || request.getScore() >= 1) { 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request");
		}
		ColorTestDatabaseScoreEntity c = new ColorTestDatabaseScoreEntity();
		c.setScore(request.getScore()); c.setLeftColor(request.getLeftColor()); c.setRightColor(request.getRightColor());
		colorTestScoreRepository.save(c);		
		double average = calculateSum(c);

		return ResponseEntity.status(HttpStatus.OK).body(String.valueOf(average));
	}
	
	private double calculateSum(ColorTestDatabaseScoreEntity c) {
		List<ColorTestDatabaseScoreEntity> scoreList = colorTestScoreRepository.findByLeftColorAndRightColorOrderByTimestamp(c.getLeftColor(), c.getRightColor());
		if(scoreList.isEmpty()) return -1;
		ColorTestDatabaseSumEntity sumEntity;
		if(colorTestSumRepository.findByLeftColorAndRightColor(c.getLeftColor(), c.getRightColor()).size() == 0) {
			sumEntity = new ColorTestDatabaseSumEntity();
			for(ColorTestDatabaseScoreEntity entry : scoreList) {
				sumEntity.setValue(sumEntity.getValue() + entry.getScore());
			}
			sumEntity.setLeftColor(c.getLeftColor());
			sumEntity.setRightColor(c.getRightColor());
			colorTestSumRepository.save(sumEntity);
		} else {
			sumEntity = colorTestSumRepository.findByLeftColorAndRightColor(c.getLeftColor(), c.getRightColor()).get(0);
			sumEntity.setValue(sumEntity.getValue() + c.getScore());
			colorTestSumRepository.save(sumEntity);
		}
		if(scoreList.size() > MAX_ENTRIES) {
			// Remove Oldest Entry
			sumEntity.setValue(sumEntity.getValue() - scoreList.get(0).getScore());
			colorTestScoreRepository.delete(scoreList.get(0)); 
			scoreList.remove(0);
			if(scoreList.size() > MAX_ENTRIES) {
				// Something has gone wrong. Time to for a full recount. (happens when requests come in too fast)
				while(scoreList.size() > MAX_ENTRIES) {
					scoreList.remove(0);
				}
				colorTestSumRepository.delete(sumEntity);
				calculateSum(c);
			}
		}
		return sumEntity.getValue() / scoreList.size();
	}
	
	public double getAverage(String leftColor, String rightColor) {
		return colorTestSumRepository.findByLeftColorAndRightColor(leftColor, rightColor).get(0).getValue() / colorTestScoreRepository.findByLeftColorAndRightColorOrderByTimestamp(leftColor, rightColor).size();
	}
}