package com.chenlong.java_zixue_17;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {

	public static void main(String[] args) {
		File file1 = new File("C:\\Users\\ChenLong\\Desktop\\Collection.pdf");// Դ�ļ���һ������
		File file2 = new File("C:\\Users\\ChenLong\\Desktop\\Collection1.pdf");// Ҫ���Ƶ��ļ�Ŀ¼�����Բ����ڣ�

		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			byte[] b = new byte[20];// 20�������ļ���С
			int len;
			while ((len = fis.read(b)) != -1) {
				fos.write(b, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
}
