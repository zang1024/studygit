package com.bw.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	private DateUtil(){};
	
	//根据传入的参数获取该日期的月初日期
	public static Date getDateByMonthInit (Date src) {
		//获取Calendar对象
		Calendar c = Calendar.getInstance();
		//初始化日历
		c.setTime(src);
		
		//获取日期的日，时，分，秒
		c.set(Calendar.DATE,1);
		c.set(Calendar.HOUR,0);
		c.set(Calendar.MINUTE,0);
		c.set(Calendar.SECOND,0);
		//返回日期
		return c.getTime();
	}
	
	//根据传入的参数获取该日器的月末日期
	public static Date getDateByMonthLast(Date src) {
		//获取Calendar对象
		Calendar c = Calendar.getInstance();
		//初始化日历
		c.setTime(src);
		
		//将月份加1
		c.add(Calendar.MONTH, 1);
		//获取月初
		Date monthstart = getDateByMonthInit(c.getTime());
		//将拿到的新的日期重新初始化
		c.setTime(monthstart);
		//将秒-1
		c.add(Calendar.SECOND, -1);
		
		//返回结果
		return c.getTime();
	}
	
	//根据传入的日期获取年龄
	public static int getAge (Date src) {
		Calendar now = Calendar.getInstance();
		
		int nowYear = now.get(Calendar.YEAR);
		int nowMonth = now.get(Calendar.MONTH);
		int nowDate = now.get(Calendar.DATE);
		
		int birthYear = src.getYear();
		int birthMonth = src.getMonth();
		int birthdDate = src.getDate();		
		
		int age = nowYear - birthYear;
		if(birthMonth > nowMonth){
			age --;
		}else if(birthMonth == nowMonth){
			if(birthdDate > nowDate){
				age--;
			}
		}
		
		return age;
	}
}
