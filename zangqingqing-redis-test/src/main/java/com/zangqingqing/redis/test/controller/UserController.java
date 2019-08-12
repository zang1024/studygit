package com.zangqingqing.redis.test.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.zangqingqing.redis.test.bean.User;
import com.zangqingqing.redis.test.bean.User2;
import com.zangqingqing.redis.test.utils.SqlMain;
import com.zangqingqing.redis.test.utils.TestStringUtils;

@Controller
public class UserController {
	
	@Resource
	private RedisTemplate<String,Object> redisTemplate;
	
	@RequestMapping("testJDK")
	public String testJDK() throws UnsupportedEncodingException {
		ListOperations<String, Object> opsForList = redisTemplate.opsForList();
		long begin = System.currentTimeMillis();
		
		for(int i=0;i<100000;i++) {
			User user = new User();
			user.setId(i+1);
			user.setUname(SqlMain.getChinaName());
			user.setPhone("13"+TestStringUtils.getRandomString(9));
			user.setEmail(TestStringUtils.getRandomString(10)+"@qq.com");
			user.setSex("男");
			user.setBirthday(new Date());
			opsForList.leftPush(i+1+"", user);
		}
		long end = System.currentTimeMillis();
		System.out.println(end-begin);
		return "list";
	}
	
	@RequestMapping("testJDKList")
	public String testJDKList() throws UnsupportedEncodingException {
		ListOperations<String, Object> opsForList = redisTemplate.opsForList();
		long begin = System.currentTimeMillis();
		List<Object> userList = new ArrayList<Object>();
		for(int i=0;i<100000;i++) {
			User user = new User();
			user.setId(i+1);
			user.setUname(SqlMain.getChinaName());
			user.setPhone("13"+TestStringUtils.getRandomString(9));
			user.setEmail(TestStringUtils.getRandomString(10)+"@qq.com");
			user.setSex("男");
			user.setBirthday(new Date());
			userList.add(user);
		}
		opsForList.leftPush("users", userList);
		long end = System.currentTimeMillis();
		System.out.println(end-begin);
		return "list";
	}
	
	@RequestMapping("testJson")
	public String testJson() throws UnsupportedEncodingException {
		ListOperations<String, Object> opsForList = redisTemplate.opsForList();
		long begin = System.currentTimeMillis();
		
		for(int i=0;i<100000;i++) {
			User2 user = new User2();
			user.setId(i+1);
			user.setUname(SqlMain.getChinaName());
			user.setPhone("13"+TestStringUtils.getRandomString(9));
			user.setEmail(TestStringUtils.getRandomString(10)+"@qq.com");
			user.setSex("男");
			user.setBirthday(new Date());
			Object json = JSON.toJSON(user);
			opsForList.leftPush("users", json);
		}
		long end = System.currentTimeMillis();
		System.out.println(end-begin);
		return "list";
	}
	
	@RequestMapping("testJsonList")
	public String testJsonList() throws UnsupportedEncodingException {
		ListOperations<String, Object> opsForList = redisTemplate.opsForList();
		long begin = System.currentTimeMillis();
		List<Object> userList = new ArrayList<>();
		for(int i=0;i<100000;i++) {
			User2 user = new User2();
			user.setId(i+1);
			user.setUname(SqlMain.getChinaName());
			user.setPhone("13"+TestStringUtils.getRandomString(9));
			user.setEmail(TestStringUtils.getRandomString(10)+"@qq.com");
			user.setSex("男");
			user.setBirthday(new Date());
			userList.add(user);
		}
		Object json = JSON.toJSON(userList);
		opsForList.leftPush("users", json);
		long end = System.currentTimeMillis();
		System.out.println(end-begin);
		return "list";
	}
	
	@RequestMapping("testHash")
	public String testHash() throws UnsupportedEncodingException {
		HashOperations<String, Object, Object> opsForHash = redisTemplate.opsForHash();
		long begin = System.currentTimeMillis();
		Map<String,Map<Object,Object>> m = new HashMap<>();
		for(int i=0;i<100000;i++) {
			Map<Object,Object> map = new HashMap<Object, Object>();
			map.put("id",i+1);
			map.put("name",SqlMain.getChinaName());
			map.put("phone","13"+TestStringUtils.getRandomString(9));
			map.put("email",TestStringUtils.getRandomString(10)+"@qq.com");
			map.put("birthday",new Date());
			m.put(i+1+"", map);
		}
		opsForHash.putAll("users", m);
		long end = System.currentTimeMillis();
		System.out.println(end-begin);
		return "list";
	}
}
