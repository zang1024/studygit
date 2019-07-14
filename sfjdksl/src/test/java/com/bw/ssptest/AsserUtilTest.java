package com.bw.ssptest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import org.junit.Test;

import com.bw.ssp.AsserUtil;
import com.bw.ssp.CRuntimeException;



public class AsserUtilTest {
	
	
    //	断言为真
	@Test
	public void fun1test(){
		try {
			AsserUtil.isTrue(false, "这Bu是真的");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void fun2test(){
		try {
			AsserUtil.isFalse(false, "这Bu是真的");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void fun5test(){
		try {
			HashMap<Integer, String> map = new HashMap<Integer, String>();
			
			AsserUtil.mapNotNull(map, "这Bu是真的");
		} catch (CRuntimeException e) {
			e.printStackTrace();
		}
	}
	
}
