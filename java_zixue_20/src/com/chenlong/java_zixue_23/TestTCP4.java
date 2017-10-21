package com.chenlong.java_zixue_23;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

//客户端给服务端发送文本，服务端会将文本转化为大写在返回给客户端
public class TestTCP4 {
	@Test
	// 客户端
	public void client() {
		Socket socket = null;
		OutputStream os = null;
		FileInputStream fis = null;
		InputStream is = null;
		try {
			socket = new Socket(InetAddress.getByName("192.168.1.111"), 8985);
			os = socket.getOutputStream();
			fis = new FileInputStream(new File("HelloWorld.txt"));
			byte[] b = new byte[20];
			int len;
			while ((len = fis.read(b)) != -1) {
				os.write(b, 0, len);
			}
			socket.shutdownOutput();
			is = socket.getInputStream();
			byte[] b1 = new byte[20];
			int len1;
			while ((len1 = is.read(b1)) != -1) {
				String str = new String(b1, 0, len1);
				System.out.print(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	// 服务端
	@Test
	public void server() {
		ServerSocket ss = null;
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		try {
			ss = new ServerSocket(8985);
			socket = ss.accept();
			is = socket.getInputStream();
			byte[] b = new byte[20];
			int len;
			String str = new String();
			while ((len = is.read(b)) != -1) {
				String str1 = new String(b, 0, len);
				str += str1;
			}
			String strUppCase = str.toUpperCase();
			os = socket.getOutputStream();
			os.write(strUppCase.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ss != null) {
				try {
					ss.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
