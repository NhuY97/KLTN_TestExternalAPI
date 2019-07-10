package com.test.api.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.api.demo.entity.Student;
import com.test.api.demo.exception.TestApiException;
import com.test.api.demo.repository.StudentRepository;
import com.test.api.demo.request.StudentRequest;
import com.test.api.demo.util.ResponseEnum;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student findById(Integer id) {
		return studentRepository.findById(id).orElseThrow(() -> new TestApiException(ResponseEnum.NOT_FOUND));
	}

	@Override
	public Student update(Student student) {
		Student studentSave = studentRepository.findById(student.getId())
				.orElseThrow(() -> new TestApiException(ResponseEnum.NOT_FOUND));
		studentSave.setName(student.getName());
		studentSave.setScore(student.getScore());
		return studentRepository.save(studentSave);
	}

	@Override
	public Student insert(StudentRequest studentRequest) {
		Student studentSave = new Student();
		studentSave.setName(studentRequest.getName());
		studentSave.setScore(studentRequest.getScore());
		return studentRepository.save(studentSave);
	}

	@Override
	public Student delete(Integer id) {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new TestApiException(ResponseEnum.NOT_FOUND));
		studentRepository.delete(student);
		return student;
	}

	@Override
	public List<Student> findAll() {
		List<Student> list = new ArrayList<>();
		studentRepository.findAll().forEach(list::add);
		return list;
	}

}
