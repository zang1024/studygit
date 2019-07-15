package com.bw.ssp;

import java.math.BigDecimal;

import org.junit.Test;

public class BigDecimalTest {
	
	@Test
	public void test1(){
		BigDecimal big1 = new BigDecimal("123.09080706050403");
		BigDecimal setScale = big1.setScale(0, BigDecimal.ROUND_HALF_UP);
		System.out.println(setScale);
	}
	
	@Test
	public void test2(){
		double num = 43.252252;
		BigDecimal big1 = BigDecimal.valueOf(num);
		BigDecimal big2 = new BigDecimal("44.000001");
		if(big2.compareTo(big1)==0){
			System.out.println("big2=big1");
		}else if(big2.compareTo(big1)==1){
			System.out.println("big2>big1");
		}else{
			System.out.println("big2<big1");
		}
		System.out.println(big2.compareTo(big1));
	}
	
	/*
	 * 
	 * BigDecimal
	 */
	@Test
	public void test3(){
		double num = 440.00001;
		BigDecimal big1 = BigDecimal.valueOf(num);
		BigDecimal big2 = new BigDecimal("44.000001");
		//BigDecimal big3 = big1.add(big2);                     ��
		//BigDecimal big3 = big1.subtract(big2);                ��
		//BigDecimal big3 = big1.multiply(big2);                ��
		BigDecimal big3 = big1.divide(big2);					//��
		System.out.println(big3);
		System.out.println(big3.intValue());
	}
	
	@Test
	public void test4(){
		BigDecimal big1 = new BigDecimal("123.09080706050403");
		BigDecimal setScale = big1.setScale(0, BigDecimal.ROUND_HALF_UP);
		System.out.println(setScale);
	}
}
