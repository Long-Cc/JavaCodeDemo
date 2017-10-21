package com.chenlong.java_zixue_23;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

//从客户端发送文件给 服务器，服务器保存到本地，并返回“发送成功”给客户端，并关闭相应的连接。
public class TestTCP3 {
	@Test
	// 客户端
	public void client() {
		// 1、创建一个Socket的对象
		Socket socket=null;
		// 2、从本地获取一个文件发送给服务端
		OutputStream os=null;
		FileInputStream fis=null;
		// 3、接收服务端反馈的信息
		InputStream is=null;
		try {
			socket = new Socket(InetAddress.getByName("192.168.1.111"), 8986);
			os = socket.getOutputStream();
			fis = new FileInputStream(new File("1.jpg"));
			byte[] b = new byte[1024];
			int len;
			while ((len = fis.read(b)) != -1) {
				os.write(b, 0, len);
			}
			socket.shutdownOutput();
			is = socket.getInputStream();
			byte[] b1 = new byte[1024];
			int len1;
			while ((len1 = is.read(b1)) != -1) {
				String str = new String(b1, 0, len1);
				System.out.println(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 4、关闭Socket及相应的流
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

	@Test
	// 服务器端
	public void server() {
		// 1、创建ServerSocket的对象
		ServerSocket ss=null;
		// 2、调用其accept()方法，返回一个Socket的对象
		Socket socket=null;
		// 3、接收客户端发送的文件保存到本地
		InputStream is=null;
		FileOutputStream fos=null;
		// 4、发送“接收成功”信息反馈给客户端
		OutputStream os=null;
		try {
			ss = new ServerSocket(8986);
			socket = ss.accept();
			is = socket.getInputStream();
			fos = new FileOutputStream(new File("2.jpg"));
			byte[] b = new byte[1024];
			int len;
			while ((len = is.read(b)) != -1) {
				fos.write(b, 0, len);
			}
			os = socket.getOutputStream();
			os.write("我已成功接收你发的图片".getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 5、关闭Socket/ServerSocket对象及相应的流
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
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
