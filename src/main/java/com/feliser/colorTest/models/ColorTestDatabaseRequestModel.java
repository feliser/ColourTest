package com.feliser.colorTest.models;

public class ColorTestDatabaseRequestModel {
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