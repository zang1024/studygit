package com.bw.mapper;

import java.util.List;

import com.bw.entity.Student;

public interface StudentMapper {

	
	public List<Student> getStudents(Student student);
	
	public int del(List<Integer> ids);
	
	public Student get(Integer sid);
	
}
