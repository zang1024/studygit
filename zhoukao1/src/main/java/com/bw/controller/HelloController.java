package com.bw.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bw.entity.Result;
import com.bw.entity.Student;
import com.bw.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.cj.exceptions.RSAException;

@Controller
public class HelloController {
	
	@Autowired
	StudentService studentService;
	
	@ResponseBody
	@RequestMapping("/get")
	public String get() {
		
		return "hello springboot";
	}
	
	@ResponseBody
	@RequestMapping("students")
	public List<Student> students(){
		
		return studentService.getStudents(null);
		
	}

	
	
	@RequestMapping("list")
	public String list(Model model,@RequestParam(defaultValue="1",required=false)Integer pageNum,Student student){
		
		PageHelper.startPage(pageNum, 3);
		List<Student> list = studentService.getStudents(student);
		
		
		PageInfo<Student> page = new PageInfo<>(list);
		model.addAttribute("page", page);
		model.addAttribute("student", student);
		//model.addAttribute("students", list);
		return "list";
		
	}

	@ResponseBody
	@RequestMapping("page")
	public PageInfo<Student> page(Model model,@RequestParam(defaultValue="1",required=false)Integer pageNum){
		
		PageHelper.startPage(pageNum, 3);
		List<Student> list = studentService.getStudents(null);
		
		
		PageInfo<Student> page = new PageInfo<>(list);
		model.addAttribute("page", page);
		//model.addAttribute("students", list);
		return page;
		
	}
	
	@ResponseBody
	@RequestMapping("del")
	public Result del(Integer[] ids) {
		
		Result result = new Result();
		List<Integer> list = Arrays.asList(ids);
		int num = studentService.del(list);
		
		if(num>0) {
			result.setCode(1);
			result.setMsg("删除成功");
			
		}else {
			result.setCode(2);
			result.setMsg("删除失败");
		}
		return result;
	}
	
	
	@RequestMapping("edit")
	public String edit(Integer sid,Model model) {
		Student student = studentService.get(sid);
		model.addAttribute("student", student);
		return "edit";
	}
	

}
