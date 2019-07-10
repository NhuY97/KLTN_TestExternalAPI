package com.test.api.demo.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.test.api.demo.entity.Student;

public class ApiResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String type;
	private String message;
	private List<Student> data = new ArrayList<>();

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Student> getData() {
		return data;
	}

	public void setData(List<Student> data) {
		this.data = data;
	}


}
