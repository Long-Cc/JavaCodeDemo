package com.chenlong.java_zixue_17;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class TestFileInputOutputStream {
	@Test
	public void testCopyFile(){
		long start=System.currentTimeMillis();
		String src="E:\\xunleiDownloads\\mojie.rmvb";
		String dest="E:\\xunleiDownloads\\mojie1.rmvb";
		copyFile(src,dest);
		long end=System.currentTimeMillis();
		System.out.println("���ѵ�ʱ���ǣ�"+ (end-start));
	}
	
	public void copyFile(String src, String dest) {
		File file1 = new File(src);
		File file2 = new File(dest);
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			byte[] b = new byte[1024];
			int len;
			while ((len = fis.read(b)) != -1) {
				fos.write(b, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// ��Ӳ���ж�ȡһ���ļ�����д�뵽��һ��λ�ã�(�൱���ļ��ĸ���)
	@Test
	public void testFileInputOutputStream() {
		// �ṩ���롢д�����ļ�
		File file1 = new File("Hello1.txt");
		File file2 = new File("Hello3.txt");
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			// ʵ���ļ��ĸ���
			byte[] b = new byte[20];
			int len;
			while ((len = fis.read(b)) != -1) {
				fos.write(b, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Test
	public void testFileOutputStream() {
		File file = new File("Hello2.txt");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			fos.write(new String("I love China !").getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	public void testFileInputStream3() {
		FileInputStream fis = null;
		try {
			File file = new File("Hello1.txt");
			fis = new FileInputStream(file);
			byte[] b = new byte[5];// ÿ�ζ��뵽byte�е��ֽڵĳ���
			int len;
			while ((len = fis.read(b)) != -1) {
				String str = new String(b, 0, len);
				System.out.print(str);
				// for (int i = 0; i < len; i++) {
				// System.out.println((char) b[i]);
				// }
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testFileInputStream2() {
		FileInputStream fis = null;
		try {
			File file1 = new File("Hello.txt");
			fis = new FileInputStream(file1);
			int b;
			while ((b = fis.read()) != -1) {
				System.out.print((char) b);
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
		}
	}

	/*
	 * ��Ӳ���д��ڵ�һ���ļ��У���ȡ�����ݵ������У�ʹ��FileInputStream
	 */
	@Test
	public void testFileInputStream1() throws Exception {
		// 1,����һ��File�����
		File file1 = new File("Hello.txt");
		// 2,����һ��FileInputStream�����
		FileInputStream fis = new FileInputStream(file1);
		// 3,����FileInputStream������ʵ��File�ļ��Ķ�ȡ
		int b = fis.read();// read()��ȡ�ļ�һ���ֽ�
		while (b != -1) {
			System.out.print((char) b);
			b = fis.read();
		}
		// 4,�ر���Ӧ����
		fis.close();
	}
}
