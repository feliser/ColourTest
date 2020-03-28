package com.feliser.colorTest.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ColorTestDatabaseSumEntity {
	@Id
	@GeneratedValue
	private long id;
	private String leftColor;
	private String rightColor;
	private double value;
	
	public void setLeftColor(String leftColor) {
		this.leftColor = leftColor;
	}
	
	public String getLeftColor() {
		return this.leftColor;
	}
	
	public void setRightColor(String leftColor) {
		this.rightColor = leftColor;
	}
	
	public String getRightColor() {
		return this.rightColor;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	public double getValue() {
		return this.value;
	}
}