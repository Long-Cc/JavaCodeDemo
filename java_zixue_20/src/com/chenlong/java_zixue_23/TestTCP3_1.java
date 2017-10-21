package com.chenlong.java_zixue_23;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

//从客户端发送文件给 服务器，服务器保存到本地，并返回“发送成功”给客户端，并关闭相应的连接。
public class TestTCP3_1 {
	@Test
	// 客户端
	public void client() throws Exception {
		// 1、创建一个Socket的对象
		Socket socket = new Socket(InetAddress.getByName("192.168.1.111"), 8986);
		// 2、从本地获取一个文件发送给服务端
		OutputStream os = socket.getOutputStream();
		FileInputStream fis = new FileInputStream(new File("1.jpg"));
		byte[] b = new byte[1024];
		int len;
		while ((len = fis.read(b)) != -1) {
			os.write(b, 0, len);
		}
		socket.shutdownOutput();
		// 3、接收服务端反馈的信息
		InputStream is = socket.getInputStream();
		byte[] b1 = new byte[1024];
		int len1;
		while ((len1 = is.read(b1)) != -1) {
			String str = new String(b1, 0, len1);
			System.out.println(str);
		}
		// 4、关闭Socket及相应的流
		is.close();
		fis.close();
		os.close();
		socket.close();
	}

	@Test
	// 服务器端
	public void server() throws Exception {
		// 1、创建ServerSocket的对象
		ServerSocket ss = new ServerSocket(8986);
		// 2、调用其accept()方法，返回一个Socket的对象
		Socket socket = ss.accept();
		// 3、接收客户端发送的文件保存到本地
		InputStream is = socket.getInputStream();
		OutputStream fos = new FileOutputStream(new File("2.jpg"));
		byte[] b = new byte[1024];
		int len;
		while ((len = is.read(b)) != -1) {
			fos.write(b, 0, len);
		}
		// 4、发送“接收成功”信息反馈给客户端
		OutputStream os = socket.getOutputStream();
		os.write("我已成功接收你发的图片".getBytes());
		os.close();
		fos.close();
		is.close();
		socket.close();
		ss.close();

	}
}