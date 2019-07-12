package com.bw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bw.entity.Student;
import com.bw.mapper.StudentMapper;
@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentMapper  studentMapper;
	
	@Override
	public List<Student> getlist(Student student) {
		// TODO Auto-generated method stub
		return studentMapper.getlist(student);
	}

}
