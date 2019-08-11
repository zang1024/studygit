package com.example.demo.controller;

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
import com.alibaba.fastjson.JSONArray;
import com.example.demo.bean.User;
import com.example.demo.bean.User2;
import com.example.demo.utils.SqlMain;
import com.example.demo.utils.TestStringUtils;
@Controller
public class UserController {


	@Resource
	private RedisTemplate<String, Object> redisTemplate;
	
	@RequestMapping("testJdk")
	public String testJdk() throws UnsupportedEncodingException {
		ListOperations<String, Object> opsForList = redisTemplate.opsForList();
		long begin = System.currentTimeMillis();
		
		for (int i = 0; i < 100000; i++) {
			User user = new User();
			user.setUid(i+1);
			user.setUname(SqlMain.getChinaName());
			user.setPhone("13"+TestStringUtils.getRandomString(9));
			user.setBirthday(new Date());
			/*StringRedisSerializer serializer = new StringRedisSerializer();
			byte[] serialize = serializer.serialize(user.getUid()+"");*/
			opsForList.leftPush(i+1+"", user);
		}
		long end = System.currentTimeMillis();
		System.out.println(end-begin);
		return "list";
	}
	@RequestMapping("testJdkList")
	public String testJdkList() throws UnsupportedEncodingException {
		ListOperations<String, Object> opsForList = redisTemplate.opsForList();
		long begin = System.currentTimeMillis();
		List<User> userList = new ArrayList<>();
		for (int i = 0; i < 100000; i++) {
			User user = new User();
			user.setUid(i+1);
			user.setUname(SqlMain.getChinaName());
			user.setPhone("13"+TestStringUtils.getRandomString(9));
			user.setBirthday(new Date());
			/*StringRedisSerializer serializer = new StringRedisSerializer();
			byte[] serialize = serializer.serialize(user.getUid()+"");*/
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
		
		for (int i = 0; i < 100000; i++) {
			User2 user = new User2();
			user.setUid(i+1);
			user.setUname(SqlMain.getChinaName());
			user.setPhone("13"+TestStringUtils.getRandomString(9));
			user.setBirthday(new Date());
			/*StringRedisSerializer serializer = new StringRedisSerializer();
			byte[] serialize = serializer.serialize(user.getUid()+"");*/
			Object json = JSON.toJSON(user);
			opsForList.leftPush(i+1+"",json);
		}
		long end = System.currentTimeMillis();
		System.out.println(end-begin);
		return "list";
	}
	@RequestMapping("testJsonList")
	public String testJsonList() throws UnsupportedEncodingException {
		ListOperations<String, Object> opsForList = redisTemplate.opsForList();
		long begin = System.currentTimeMillis();
		
		List<User2> userList = new ArrayList<>();
		for (int i = 0; i < 100000; i++) {
			User2 user = new User2();
			user.setUid(i+1);
			user.setUname(SqlMain.getChinaName());
			user.setPhone("13"+TestStringUtils.getRandomString(9));
			user.setBirthday(new Date());
			/*StringRedisSerializer serializer = new StringRedisSerializer();
			byte[] serialize = serializer.serialize(user.getUid()+"");*/
			userList.add(user);
		}
		Object json = JSONArray.toJSON(userList);
		opsForList.leftPush("userList", json);
		long end = System.currentTimeMillis();
		System.out.println(end-begin);
		return "list";
	}
	
	@RequestMapping("testHash")
	public String testHash() throws UnsupportedEncodingException {
		HashOperations<String, Object, Object> opsForHash = redisTemplate.opsForHash();
		long begin = System.currentTimeMillis();
		Map<String,Map<Object,Object>> m = new HashMap<>();
		for (int i = 0; i < 100000; i++) {
			Map<Object,Object> map = new HashMap<>();
			map.put("id", i+1);
			map.put("name", SqlMain.getChinaName());
			map.put("phone", "13"+TestStringUtils.getRandomString(9));
			map.put("date", new Date());
			m.put(i+"", map);
		}
		opsForHash.putAll("user", m);
		long end = System.currentTimeMillis();
		System.out.println(end-begin);
		return "list";
	}
	
	

}
