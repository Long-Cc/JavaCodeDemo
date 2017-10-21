package com.chenlong.java_zixue_13;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestException1 {
	public static void main(String[] args){
		try {
			method2();
		} catch (FileNotFoundException e1) {
			System.out.println(e1.getMessage());
		}catch (IOException e2){
			e2.printStackTrace();
		}	
	}
	
	
	public static void method2() throws FileNotFoundException, IOException{
		method1();
	}
	
	
	public static void method1() throws FileNotFoundException,IOException{
		FileInputStream fis=new FileInputStream(new File("Hello.txt"));
		int b;
		while((b=fis.read())!=-1){
			System.out.print((char)b);
		}
		fis.close();
	}
}

