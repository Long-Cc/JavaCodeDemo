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

//�ӿͻ��˷����ļ��� �����������������浽���أ������ء����ͳɹ������ͻ��ˣ����ر���Ӧ�����ӡ�
public class TestTCP3 {
	@Test
	// �ͻ���
	public void client() {
		// 1������һ��Socket�Ķ���
		Socket socket=null;
		// 2���ӱ��ػ�ȡһ���ļ����͸������
		OutputStream os=null;
		FileInputStream fis=null;
		// 3�����շ���˷�������Ϣ
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
			// 4���ر�Socket����Ӧ����
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
	// ��������
	public void server() {
		// 1������ServerSocket�Ķ���
		ServerSocket ss=null;
		// 2��������accept()����������һ��Socket�Ķ���
		Socket socket=null;
		// 3�����տͻ��˷��͵��ļ����浽����
		InputStream is=null;
		FileOutputStream fos=null;
		// 4�����͡����ճɹ�����Ϣ�������ͻ���
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
			os.write("���ѳɹ������㷢��ͼƬ".getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 5���ر�Socket/ServerSocket������Ӧ����
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
