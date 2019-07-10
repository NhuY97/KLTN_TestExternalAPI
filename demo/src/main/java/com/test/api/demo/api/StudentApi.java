package com.test.api.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.api.demo.entity.Student;
import com.test.api.demo.exception.InvalidException;
import com.test.api.demo.request.StudentRequest;
import com.test.api.demo.response.ApiResponse;
import com.test.api.demo.service.StudentService;
import com.test.api.demo.util.Const;
import com.test.api.demo.util.ResponseEnum;

@RestController
@RequestMapping("/api/student")
public class StudentApi {

	@Autowired
	private StudentService studentService;

	@RequestMapping(method = RequestMethod.GET, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<? extends ApiResponse> findStudentById(@PathVariable("id") Integer id) {
		Student student = studentService.findById(id);
		ApiResponse response = new ApiResponse();
		response.getData().add(student);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = Const.DEFAULT_URI, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findAllStudent() {
		List<Student> students = studentService.findAll();
		ApiResponse response = new ApiResponse();
		response.setData(students);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = Const.DEFAULT_URI, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<? extends ApiResponse> update(@RequestBody Student student) {
		if (student == null || (student.getScore() != null && (student.getScore() > 10 || student.getScore() <0))
				|| (student.getName() != null && student.getName().length() > 200)) {
			throw new InvalidException(ResponseEnum.INVALID_ERROR);
		}
		Student studentRespone = studentService.update(student);
		ApiResponse response = new ApiResponse();
		response.getData().add(studentRespone);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = Const.DEFAULT_URI, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<? extends ApiResponse> insert(@RequestBody StudentRequest studentRequest) {
		if (studentRequest == null || (studentRequest.getScore() != null && (studentRequest.getScore() > 10 || studentRequest.getScore() <0))
				|| (studentRequest.getName() != null && studentRequest.getName().length() > 200)) {
			throw new InvalidException(ResponseEnum.INVALID_ERROR);
		}
		Student studentResponse = studentService.insert(studentRequest);
		ApiResponse response = new ApiResponse();
		response.getData().add(studentResponse);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<? extends ApiResponse> delete(@PathVariable("id") Integer id) {
		Student studentResponse = studentService.delete(id);
		ApiResponse response = new ApiResponse();
		response.getData().add(studentResponse);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
