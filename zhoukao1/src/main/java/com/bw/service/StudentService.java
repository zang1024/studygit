package com.bw.service;

import java.util.List;

import com.bw.entity.Student;

public interface StudentService {

	
	public List<Student> getStudents(Student student);
	
	
	public int del(List<Integer> ids);
	
	
	public Student get(Integer sid);
}
