package com.bw.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.bw.util.DateUtil;

public class DateTest {
	
	@Test
	public void funTest1(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = DateUtil.getDateByMonthInit(new Date());
		System.out.println(df.format(date));
	}
	
	@Test
	public void funTest2(){
		Calendar c = Calendar.getInstance();
		c.getTime();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = DateUtil.getDateByMonthLast(c.getTime());
		System.out.println(df.format(date));
	}
	
	@Test
	public void funTest3(){
		
	}
	
}
