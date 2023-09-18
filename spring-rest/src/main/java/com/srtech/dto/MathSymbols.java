package com.srtech.dto;

public enum MathSymbols{
	
	ADD("ADD"),
	MULTIPLY("MULTIPLY"),
	DIVISION("DIVISION");

	MathSymbols(String name) {
		this.opName=name;
	}
	
	private String opName;

	public String getOpName() {
		return opName;
	}

	public void setOpName(String opName) {
		this.opName = opName;
	}
	
}