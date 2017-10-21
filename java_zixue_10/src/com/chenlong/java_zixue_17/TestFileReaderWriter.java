package com.chenlong.java_zixue_17;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class TestFileReaderWriter {
	//ʹ��FileReader��FileWriter�ļ��ļ�����
	//���ڷ��ı��ļ�(��Ƶ�ļ�����Ƶ�ļ���ͼƬ��)ʹ��FileInputStream��FileOutputStream
	@Test
	public void testFileReaderWriter(){
		File file1=new File("Hello.txt");
		File file2=new File("bishaji.txt");
		FileReader fr=null;
		FileWriter fw=null;
		try{
			fr=new FileReader(file1);
			fw=new FileWriter(file2);
			char[] c=new char[20];
			int len;
			while((len=fr.read(c))!=-1){
				fw.write(c,0,len);
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(fr!=null){
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fw!=null){
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
