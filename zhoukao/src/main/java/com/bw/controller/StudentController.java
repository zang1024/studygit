package com.bw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bw.entity.Student;
import com.bw.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class StudentController {
	
	@Autowired
	StudentService  studentService;
	
	@RequestMapping("list")
	public String list(Model model,
			@RequestParam(defaultValue="1")Integer pageNum,
			Student student
			
			){
		PageHelper.startPage(pageNum, 3);
		List<Student> list = studentService.getlist(student);
		PageInfo<Student> pageInfo = new PageInfo<Student>(list);
		model.addAttribute("page",pageInfo);
		model.addAttribute("student", student);
		return "list";
	}
	
	@ResponseBody
	@RequestMapping("page")
	public PageInfo<Student> page(Model model,@RequestParam(defaultValue="1")Integer pageNum){
		PageHelper.startPage(pageNum, 3);
		List<Student> list = studentService.getlist(null);
		
		PageInfo<Student> page = new PageInfo<Student>(list);
		model.addAttribute("page",page);
		return page;
	}
}
