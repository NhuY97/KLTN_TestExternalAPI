package com.test.api.demo.service;

import java.util.List;

import com.test.api.demo.entity.Student;
import com.test.api.demo.request.StudentRequest;

public interface StudentService {
	
	public Student findById(Integer id);
	
	public List<Student> findAll();
	
	public Student update(Student student);
	
	public Student insert(StudentRequest studentRequest);
	
	public Student delete(Integer id);
}
