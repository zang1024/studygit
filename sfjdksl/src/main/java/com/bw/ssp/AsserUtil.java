package com.bw.ssp;

import java.util.Collection;
import java.util.Map;

public class AsserUtil {
	
	public static void isTrue(Boolean exp,String message){
		if(!exp){
			throw new CRuntimeException();
		}
	}
	
	public static void isFalse(Boolean exp,String message){
		if(exp){
			throw new CRuntimeException();
		}
	}
	
	public static void isNotNull(String exp,String message){
		if(exp == null || exp.length() == 0){
			throw new CRuntimeException();
		}
	}
	
	public static void isNull(String exp,String message){
		if(exp != null || exp.length() >= 0){
			throw new CRuntimeException();
		}
	}
	
	public static void collectionNotNull(Collection<?> col,String message){
		if(col == null || col.size() == 0){
			throw new CRuntimeException();
		}
	}
	
	public static void mapNotNull(Map<?, ?> map,String message){
		if(map == null || map.size() == 0){
			throw new CRuntimeException();
		}
	}
	
	public static void islength(String exp,String message){
		if(!(exp.trim().length() > 0)){
			throw new CRuntimeException();
		}
	}
	
	public static void absInt(int exp,String message){
		if(exp <= 0){
			throw new CRuntimeException();
		}
	}
	
}
