package com.bw.utils;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamUtil {
	public StreamUtil(){}
	
	//批量关闭流，参数能传无限个,
	//例如传入FileInputStream对象、JDBC中Connection对象都可以关闭
	public static void closeAll(Closeable... closeables) {
		if(closeables == null){
			
		}
		
	}
	
	//拷贝流，将InputStream流拷到OutputStream，可以用于快速读与文件、上传下载，为了提高性能，需要使用缓冲
	public static void copy(InputStream src, OutputStream out, boolean isCloseInputStream, boolean isCloseOutputStream)  throws IOException{
		
	}
	
	
	//传入一个文本文件对象，默认为UTF-8编码，返回该文件内容，
	//要求方法内部调用上面第2个方法拷贝流，结束后第1个方法关闭流
	public static String readTextFile(InputStream src) throws IOException{
		String result = null;
		return result;
	}
	
	//传入文本文件对象，返回该文件内容(3分)，并且要求内部调用上面第3个方法
	public static String readTextFile(File txtFile) throws FileNotFoundException, IOException{
		String result = null;
		return result;
	}
	
	//从控制台读取用户输入的字符串
	public static String readStringFromSystemIn(String message){
		String result = null;
		return result;
	}
	
	//从控制台读取用户输入的数字
	public static int readIntFromSystemIn(String message){
		int result = 0;
		return result;
	}
}
