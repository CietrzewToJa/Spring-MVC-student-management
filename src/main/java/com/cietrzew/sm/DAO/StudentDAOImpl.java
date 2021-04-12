package com.cietrzew.sm.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cietrzew.sm.api.Student;
import com.cietrzew.sm.rowmapper.StudentRowMapper;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Student> loadStudents() {
		
		String sql = "SELECT * FROM students";
		
		List<Student> theListOfStudent = jdbcTemplate.query(sql, new StudentRowMapper());
		
		return theListOfStudent;
	}

	@Override
	public void saveStudent(Student student) {

		Object[] sqlParameters = { student.getName(), student.getMobile(), student.getCountry() };
	
		String sql = "INSERT INTO students (name, mobile, country) VALUES(?,?,?)";
		
		jdbcTemplate.update(sql, sqlParameters);
		
		System.out.println("Record updated...");
	}

	@Override
	public Student getStudent(int id) {

		String sql = "SELECT * FROM students WHERE ID = ?";
		Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
		
		return student;
	}

	@Override
	public void update(Student student) {

		String sql = "UPDATE students SET name=?, mobile=?, country=? WHERE id=?";
		
		jdbcTemplate.update(sql, student.getName(), student.getMobile(), student.getCountry(), student.getId());
		System.out.println("Student updated");
	}

	@Override
	public void deleteStudent(int id) {

		String sql = "DELETE FROM students WHERE id=?";
		
		jdbcTemplate.update(sql, id);
		
	}

}
