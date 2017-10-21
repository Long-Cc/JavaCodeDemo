package com.chenlong.java_zixue_16;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import org.junit.Test;

public class TestFile {
	@Test
	public void test3() throws IOException{
		File file1=new File("F:\\Test File IO\\test_io.txt");
		System.out.println(file1.delete());
		if(!file1.exists()){
			file1.createNewFile();
		}
		File file2=new File("F:\\test1\\test2");
		file2.delete();
		//.mkdir()��.mkdirs()����
		//mkdir()ֻ��ָ��·�������ļ�
		//mkdirs()��ָ��·����û�е��ļ�һ������
		if(!file2.exists()){
			System.out.println(file2.mkdirs());
		}
		
		File file3=new File("E:\\Ѹ������");
		String[] str=file3.list();
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
		
	}
	@Test
	public void test2(){
		File file1=new File("F:\\Test File IO\\test_io.txt");
		File file3=new File("F:\\test");
		System.out.println(file1.exists());
		System.out.println(file1.canWrite());
		System.out.println(file1.canRead());
		System.out.println(file1.isFile());
		System.out.println(file1.isDirectory());
		System.out.println(new Date(file1.lastModified()));
		System.out.println(file1.length());
	
		System.out.println(file3.exists());
		System.out.println(file3.canWrite());
		System.out.println(file3.canRead());
		System.out.println(file3.isFile());
		System.out.println(file3.isDirectory());
		System.out.println(new Date(file3.lastModified()));
		System.out.println(file3.length());
	
	
	
	}
	@Test
	public void test1(){
		File file1=new File("F:\\Test File IO\\test_io.txt");//����·��(�����̷�)
		File file2=new File("Hello1.txt");//���·������ǰ�����ļ��µ��ļ�
		File file3=new File("F:\\test_IO");
		File file4=new File("F:\\test");
		
		System.out.println(file1.getName());
		System.out.println(file1.getPath());
		System.out.println(file1.getParent());
		System.out.println(file1.getAbsolutePath());
		System.out.println(file1.getAbsoluteFile());
		

		System.out.println(file3.getName());
		System.out.println(file3.getPath());
		System.out.println(file3.getParent());
		System.out.println(file3.getAbsolutePath());
		System.out.println(file3.getAbsoluteFile());
		/*
		 * boolean b=file1.renameTo(file2);
		 * 	��file1�Ƶ�file2�в�������Ϊfile2(file1���ڣ�file2һ��������)
			��file2ͬΪ�ļ����ĵ�
		 */
		boolean b=file1.renameTo(file2);
		System.out.println(b);
		boolean b1=file3.renameTo(file4);
		System.out.println(b1);
	}
}
