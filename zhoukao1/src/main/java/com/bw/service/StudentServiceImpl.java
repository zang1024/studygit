package com.bw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bw.entity.Student;
import com.bw.mapper.StudentMapper;


@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentMapper studentMapper;
	
	@Override
	public List<Student> getStudents(Student student) {
	
		return studentMapper.getStudents(student);
	}
	
	
	public int del(List<Integer> ids) {
		
		return studentMapper.del(ids);
	}


	@Override
	public Student get(Integer sid) {
		// TODO Auto-generated method stub
		return studentMapper.get(sid);
	}

}
