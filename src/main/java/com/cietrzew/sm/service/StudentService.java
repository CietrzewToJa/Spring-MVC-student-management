package com.cietrzew.sm.service;

import java.util.List;

import com.cietrzew.sm.api.Student;

public interface StudentService {

	List<Student> loadStudents();
	void saveStudent(Student student);
	Student getStudent(int id);
	void updateStudent(Student student);
	void deleteStudent(int id);
}
