package com.feliser.colorTest.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class ColorTestDatabaseScoreEntity {
	@Id
	@GeneratedValue
	private long id;
	@CreationTimestamp
    private LocalDateTime timestamp;
	private double score;
	private String leftColor;
	private String rightColor;
	
	public double getScore() {
		return score;
	}
	
	public void setScore(double score) {
		this.score = score;
	}
	
	public String getLeftColor() {
		return leftColor;
	}

	public void setLeftColor(String leftColor) {
		this.leftColor = leftColor;
	}
	
	public String getRightColor() {
		return rightColor;
	}
	
	public void setRightColor(String rightColor) {
		this.rightColor = rightColor;
	}
}