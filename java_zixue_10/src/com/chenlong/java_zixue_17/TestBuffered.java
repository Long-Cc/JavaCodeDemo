package com.chenlong.java_zixue_17;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class TestBuffered {

	public void copyFileMethod(String src, String dest) {

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			File file1 = new File(src);
			File file2 = new File(dest);
			FileInputStream fis = new FileInputStream(file1);
			FileOutputStream fos = new FileOutputStream(file2);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			byte[] b = new byte[1024];
			int len;
			while ((len = bis.read(b)) != -1) {
				bos.write(b, 0, len);
				bos.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/*
	 * ʹ��BufferedIuputStream��BuiieredOutputStreamʵ�ַ��ı��ļ�����
	 */
	@Test
	public void testBufferedInputOutputStream() {
		// �������Ľڵ����Ķ�����Ϊ�βδ��ݸ��������Ĺ�������
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			File file1 = new File("flower.jpg");
			File file2 = new File("flower2.jpg");
			FileInputStream fis = new FileInputStream(file1);
			FileOutputStream fos = new FileOutputStream(file2);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			byte[] b = new byte[1024];
			int len;
			while ((len = bis.read(b)) != -1) {
				bos.write(b, 0, len);
				bos.flush();//ע�⣬��flush();ˢ��
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
