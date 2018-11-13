package com.alice.service;

import java.util.List;

import com.alice.entity.Student;

public interface StudentService {

	List<Student> getAll();
	
	Student getStudentById(int id);
	
}
