package com.zangqingqing.redis.test.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import com.zangqingqing.redis.test.bean.User;

public class TestSerial {
	@Test
	public void testSerival() {
		User userPo = new User(1,"周青——testSeri","13526441256",new Date(),"男","1935996900@qq.com");
		List<Object> list = new ArrayList<Object>();
		for(int i=0;i<100000;i++) {
			list.add(userPo);
		}
		
		JdkSerializationRedisSerializer j = new JdkSerializationRedisSerializer();
		GenericJackson2JsonRedisSerializer g = new GenericJackson2JsonRedisSerializer();
		Jackson2JsonRedisSerializer j2 = new Jackson2JsonRedisSerializer(List.class);
		
		Long j_s_start = System.currentTimeMillis();
		byte[] byteJ = j.serialize(list);
		System.out.println("JdkSerializationRedisSerializer序列化时间"+(System.currentTimeMillis()-j_s_start)+"ms,序列化后的长度"+byteJ.length);
		Long j_d_start = System.currentTimeMillis();
		j.deserialize(byteJ);
		System.out.println("JdkSerializationRedisSerializer反序列化时间"+(System.currentTimeMillis()-j_d_start));
		
		Long g_s_start = System.currentTimeMillis();
		byte[] byteG = g.serialize(list);
		System.out.println("GenericJackson2JsonRedisSerializer序列化时间"+(System.currentTimeMillis()-g_s_start)+"ms,序列化后的长度"+byteG.length);
		Long g_d_start = System.currentTimeMillis();
		g.deserialize(byteG);
		System.out.println("GenericJackson2JsonRedisSerializer反序列化时间"+(System.currentTimeMillis()-g_d_start));
		
		Long j2_s_start = System.currentTimeMillis();
		byte[] byteJ2 = j2.serialize(list);
		System.out.println("Jackson2JsonRedisSerializer序列化时间"+(System.currentTimeMillis()-j2_s_start)+"ms,序列化后的长度"+byteJ2.length);
		Long j2_d_start = System.currentTimeMillis();
		j2.deserialize(byteJ2);
		System.out.println("Jackson2JsonRedisSerializer反序列化时间"+(System.currentTimeMillis()-j2_d_start));
	}
}
