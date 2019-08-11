package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import com.example.demo.bean.User;

public class TestSerialize {

	
	 @Test
	    public void testSerial(){
	        User userPO = new User(1,"小明_testRedis1","132456456987",new Date());
	        List<Object> list = new ArrayList<>();
	        for(int i=0;i<100000;i++){
	            list.add(userPO);
	        }
	        JdkSerializationRedisSerializer j = new JdkSerializationRedisSerializer();
	        GenericJackson2JsonRedisSerializer g = new GenericJackson2JsonRedisSerializer();
	        Jackson2JsonRedisSerializer j2 = new Jackson2JsonRedisSerializer(List.class);


	        Long j_s_start = System.currentTimeMillis();
	        byte[] bytesJ = j.serialize(list);
	        System.out.println("JdkSerializationRedisSerializer序列化时间："+(System.currentTimeMillis()-j_s_start) + "ms,序列化后的长度：" + bytesJ.length);
	        Long j_d_start = System.currentTimeMillis();
	        j.deserialize(bytesJ);
	        System.out.println("JdkSerializationRedisSerializer反序列化时间："+(System.currentTimeMillis()-j_d_start));


	        Long g_s_start = System.currentTimeMillis();
	        byte[] bytesG = g.serialize(list);
	        System.out.println("GenericJackson2JsonRedisSerializer序列化时间："+(System.currentTimeMillis()-g_s_start) + "ms,序列化后的长度：" + bytesG.length);
	        Long g_d_start = System.currentTimeMillis();
	        g.deserialize(bytesG);
	        System.out.println("GenericJackson2JsonRedisSerializer反序列化时间："+(System.currentTimeMillis()-g_d_start));

	        Long j2_s_start = System.currentTimeMillis();
	        byte[] bytesJ2 = j2.serialize(list);
	        System.out.println("Jackson2JsonRedisSerializer序列化时间："+(System.currentTimeMillis()-j2_s_start) + "ms,序列化后的长度：" + bytesJ2.length);
	        Long j2_d_start = System.currentTimeMillis();
	        j2.deserialize(bytesJ2);
	        System.out.println("Jackson2JsonRedisSerializer反序列化时间："+(System.currentTimeMillis()-j2_d_start));
	    }
	
}
