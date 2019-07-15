package com.bw.ssp;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

public class AsserTest {
	
	//1.true,通过断言    false,不通过断言
	@Test
	public void fun1Test(){
		try {
			AsserUtil.isTrue(false, "这不是一个true");
		} catch (CRuntimeException e) {
			e.printStackTrace();
		}
	}
	
	
	//2.true,不通过断言    false,通过断言
	@Test
	public void fun2Test(){
		try {
			AsserUtil.isFalsee(true, "这不是一个false");
		} catch (CRuntimeException e) {
			e.printStackTrace();
		}
	}
	
	//3.字符串为空，断言不通过    字符串不为空断言通过
	@Test
	public void fun3Test(){
		try {
			AsserUtil.isNotNull("fdsf", "这不是一个字符串");
		} catch (CRuntimeException e) {
			e.printStackTrace();
		}
	}
	
	//4.字符串为空，断言通过    字符串不为空断言不通过
		@Test
		public void fun4Test(){
			try {
				AsserUtil.isNull1("", "这是一个字符串");
			} catch (CRuntimeException e) {
				e.printStackTrace();
			}
		}
	
	//5.字符串为空，断言通过    字符串不为空断言不通过
	@Test
	public void fun5Test(){
		try {
				
			ArrayList<Integer> arrayList = new ArrayList<Integer>();
			arrayList.add(55);
			AsserUtil.collectionNotNull(arrayList, "这不是一个集合或者集合为空");
	} catch (CRuntimeException e) {
			e.printStackTrace();
		}
	}
	
	//6.字符串为空，断言通过    字符串不为空断言不通过
		@Test
		public void fun6Test(){
			try {
				HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
				hashMap.put(1, "4512");
				AsserUtil.mapNotNull(hashMap, "这不是一个map集合或者map集合为空");
		} catch (CRuntimeException e) {
				e.printStackTrace();
			}
		}
	
	//7.字符串为空，断言通过    字符串不为空断言不通过
	@Test
	public void fun7Test(){
		try {
			AsserUtil.isLength("hsdfsjk hsj shjk", "这不是一个字符串");
		} catch (CRuntimeException e) {
				e.printStackTrace();
			}
		}

	
	//7.字符串为空，断言通过    字符串不为空断言不通过
		@Test
		public void fun8Test(){
			try {
				AsserUtil.absInt(0, "这不是一个整数");
			} catch (CRuntimeException e) {
					e.printStackTrace();
				}
			}
	
	
	
}
