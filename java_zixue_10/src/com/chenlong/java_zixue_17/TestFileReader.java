package com.chenlong.java_zixue_17;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class TestFileReader {
	@Test
	public void testFileReader1() {
		File file = new File("Hello2.txt");
		FileReader fr = null;
		try {
			fr = new FileReader(file);
			char[] c = new char[20];
			int len;
			while ((len = fr.read(c)) != -1) {
				String str = new String(c, 0, len);
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
