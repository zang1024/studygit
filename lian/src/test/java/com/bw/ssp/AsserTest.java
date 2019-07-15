package com.bw.ssp;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

public class AsserTest {
	
	//1.true,ͨ������    false,��ͨ������
	@Test
	public void fun1Test(){
		try {
			AsserUtil.isTrue(false, "�ⲻ��һ��true");
		} catch (CRuntimeException e) {
			e.printStackTrace();
		}
	}
	
	
	//2.true,��ͨ������    false,ͨ������
	@Test
	public void fun2Test(){
		try {
			AsserUtil.isFalsee(true, "�ⲻ��һ��false");
		} catch (CRuntimeException e) {
			e.printStackTrace();
		}
	}
	
	//3.�ַ���Ϊ�գ����Բ�ͨ��    �ַ�����Ϊ�ն���ͨ��
	@Test
	public void fun3Test(){
		try {
			AsserUtil.isNotNull("fdsf", "�ⲻ��һ���ַ���");
		} catch (CRuntimeException e) {
			e.printStackTrace();
		}
	}
	
	//4.�ַ���Ϊ�գ�����ͨ��    �ַ�����Ϊ�ն��Բ�ͨ��
		@Test
		public void fun4Test(){
			try {
				AsserUtil.isNull1("", "����һ���ַ���");
			} catch (CRuntimeException e) {
				e.printStackTrace();
			}
		}
	
	//5.�ַ���Ϊ�գ�����ͨ��    �ַ�����Ϊ�ն��Բ�ͨ��
	@Test
	public void fun5Test(){
		try {
				
			ArrayList<Integer> arrayList = new ArrayList<Integer>();
			arrayList.add(55);
			AsserUtil.collectionNotNull(arrayList, "�ⲻ��һ�����ϻ��߼���Ϊ��");
	} catch (CRuntimeException e) {
			e.printStackTrace();
		}
	}
	
	//6.�ַ���Ϊ�գ�����ͨ��    �ַ�����Ϊ�ն��Բ�ͨ��
		@Test
		public void fun6Test(){
			try {
				HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
				hashMap.put(1, "4512");
				AsserUtil.mapNotNull(hashMap, "�ⲻ��һ��map���ϻ���map����Ϊ��");
		} catch (CRuntimeException e) {
				e.printStackTrace();
			}
		}
	
	//7.�ַ���Ϊ�գ�����ͨ��    �ַ�����Ϊ�ն��Բ�ͨ��
	@Test
	public void fun7Test(){
		try {
			AsserUtil.isLength("hsdfsjk hsj shjk", "�ⲻ��һ���ַ���");
		} catch (CRuntimeException e) {
				e.printStackTrace();
			}
		}

	
	//7.�ַ���Ϊ�գ�����ͨ��    �ַ�����Ϊ�ն��Բ�ͨ��
		@Test
		public void fun8Test(){
			try {
				AsserUtil.absInt(0, "�ⲻ��һ������");
			} catch (CRuntimeException e) {
					e.printStackTrace();
				}
			}
	
	
	
}
