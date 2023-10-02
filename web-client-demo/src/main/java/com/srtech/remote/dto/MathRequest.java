package com.srtech.remote.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MathRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3230875645443016776L;
	private Integer no1;
	private Integer no2;
	private String mathOperator;
	public Integer getNo1() {
		return no1;
	}
	public void setNo1(Integer no1) {
		this.no1 = no1;
	}
	public Integer getNo2() {
		return no2;
	}
	public void setNo2(Integer no2) {
		this.no2 = no2;
	}
	public String getMathOperator() {
		return mathOperator;
	}
	public void setMathOperator(String mathOperator) {
		this.mathOperator = mathOperator;
	}
	
}

