package com.chenlong.java_zixue_17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.junit.Test;

public class TestOtherStream {
	/*
	 * ��׼����������� ��׼���������System.out ��׼����������System.in
	 */
	@Test
	public void test2() {
		BufferedReader br = null;
		try {
			InputStream is = System.in;
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String str;
			while (true) {
				System.out.println("�������ַ�����");
				str = br.readLine();
				if (str.equalsIgnoreCase("e") || str.equalsIgnoreCase("exit")) {
					break;
				}
				String str1 = str.toUpperCase();
				System.out.println(str1);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	/*
	 * ת������InputStreamReader��OuputStreamWriter ���룺�ַ���--->�ֽ����� ���룺�ֽ�����--->�ַ���
	 */
	@Test
	public void test1() {
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			// ����
			File file1 = new File("bishaji.txt");
			FileInputStream fis = new FileInputStream(file1);
			InputStreamReader isr = new InputStreamReader(fis, "GBK");
			br = new BufferedReader(isr);
			// ����
			File file2 = new File("bishaji2.txt");
			FileOutputStream fos = new FileOutputStream(file2);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK");
			bw = new BufferedWriter(osw);

			String str;
			while ((str = br.readLine()) != null) {
				bw.write(str);
				bw.newLine();
				bw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}
}
