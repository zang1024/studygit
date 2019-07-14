package com.bw.ssptest;

import java.math.BigDecimal;

import org.junit.Test;

public class BigDecimalTest {
	
	@Test
	public void test1(){
		BigDecimal big1 = new BigDecimal("111.2323");
		BigDecimal setScale = big1.setScale(0, BigDecimal.ROUND_HALF_UP);
		System.out.println(setScale);
	}
	
	@Test
	public void test2(){
		double num = 440.0002;
		BigDecimal big1 = BigDecimal.valueOf(num);
		BigDecimal big2 = new BigDecimal("440.0002");
		
		//BigDecimal big3 = big1.add(big2);
		//BigDecimal big3 = big1.subtract(big2);
		//BigDecimal big3 = big1.multiply(big2);
		BigDecimal big3 = big1.divide(big2);
		System.out.println(big3);
	}
	
}
