package com.chenlong.java_zixue_17;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.Test;

public class TestRandomAccessFile {
	
	@Test
	public void test2() {
		RandomAccessFile raf = null;
		try {
			
			raf = new RandomAccessFile(new File("abc.txt"), "rw");
			
			raf.seek(4);
			byte[] b=new byte[10];
			int len;
			StringBuffer sb=new StringBuffer();
			while((len=raf.read(b))!=-1){
				sb.append(new String(b,0,len));
			}
			raf.seek(4);
			raf.write("zx".getBytes());
			raf.write(sb.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (raf != null) {
				try {
					raf.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}

	@Test
	public void test1() {
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(new File("abc.txt"), "rw");
			raf.seek(4);
			String str = raf.readLine();
			raf.seek(4);
			raf.write("zx".getBytes());
			raf.write(str.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (raf != null) {
				try {
					raf.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}

	@Test
	public void test() {
		RandomAccessFile raf1 = null;
		RandomAccessFile raf2 = null;
		try {
			raf1 = new RandomAccessFile(new File("bishaji.txt"), "r");
			raf2 = new RandomAccessFile(new File("bishaji3.txt"), "rw");
			byte[] b = new byte[20];
			int len;
			while ((len = raf1.read(b)) != -1) {
				raf2.write(b, 0, len);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (raf1 != null) {
				try {
					raf1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (raf2 != null) {
				try {
					raf2.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
