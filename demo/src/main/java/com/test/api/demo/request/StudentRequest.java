package com.test.api.demo.request;

import java.io.Serializable;

public class StudentRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3933006189062134296L;
	private String name;
	private Double score = 0D;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

}
