package com.bw.ssp;

import java.util.Collection;
import java.util.Map;

public class AsserUtil {
	
	//1.����Ϊ��
	//expΪtrue����false
	//message Ϊ������Ϣ
	public static void isTrue(boolean exp,String message){
		if(!exp){
			throw new CRuntimeException(message);
		}
	}
	
	//2.����Ϊ��
	//expΪtrue����false
	//message Ϊ������Ϣ
	public static void isFalsee(boolean exp,String message){
		if(exp){
				throw new CRuntimeException(message);
		}
	}
	
	//3.���Զ���Ϊ��
	//expΪtrue����false
	//message Ϊ������Ϣ
	public static void isNotNull(String exp,String message){
		if(exp == null || exp.length() == 0){
			throw new CRuntimeException(message);
		}
	}
	
	//4.���Զ������Ϊ��
	//expΪtrue����false
	//message Ϊ������Ϣ
	public static void isNull1(String exp,String message){
		if(exp.length() > 0){
			throw new CRuntimeException(message);
		}
	}
	public static void isNull2(String exp,String message){
		if(exp != null){
			throw new CRuntimeException(message);
		}
	}
	
	//5.����List��Set���ϲ�Ϊ�գ�û��Ԫ��Ҳ���
	//expΪtrue����false
	//message Ϊ������Ϣ
	public static void collectionNotNull(Collection<?> col,String message){
		if(col == null || col.size() == 0){
			throw new CRuntimeException(message);
		}
	}
	
	//6.����Map���ϲ�Ϊ�գ�û��Ԫ��Ҳ���
	//expΪtrue����false
	//message Ϊ������Ϣ
	public static void mapNotNull(Map<?, ?> map,String message){
		if(map == null || map.size() == 0){
			throw new CRuntimeException(message);
		}
	}
	
	//7.�����ַ���������ֵ��ȥ���ո�󣬳��ȱ������0
	//expΪtrue����false
	//message Ϊ������Ϣ
	public static void isLength(String exp,String message){
		if(!(exp.trim().length() > 0)){
			throw new CRuntimeException(message);
			
			
			
		}
	}
	
	
	//8.����ֵ������������ֵ����0��
	//expΪtrue����false
	//message Ϊ������Ϣ
	public static void absInt(int exp,String message){
		if(exp <= 0){
			throw new CRuntimeException(message);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
