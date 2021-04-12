package com.cietrzew.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cietrzew.sm.DAO.StudentDAO;
import com.cietrzew.sm.api.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	public List<Student> loadStudents() {

		List<Student> studentList = studentDAO.loadStudents();
		
		return studentList;
	}

	@Override
	public void saveStudent(Student student) {
		
		if(student.getCountry().equals("UK")) {
			
			// write the email sending logic right here
			System.out.println("Mail sent to: " + student.getName());
		}

		studentDAO.saveStudent(student);
	}

	@Override
	public Student getStudent(int id) {

		Student student = studentDAO.getStudent(id);
		
		return student;
	}

	@Override
	public void updateStudent(Student student) {
		
		studentDAO.update(student);
		
	}

	@Override
	public void deleteStudent(int id) {

		studentDAO.deleteStudent(id);
		
	}

}
