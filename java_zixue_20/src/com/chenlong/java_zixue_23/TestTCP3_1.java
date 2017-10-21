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

//�ӿͻ��˷����ļ��� �����������������浽���أ������ء����ͳɹ������ͻ��ˣ����ر���Ӧ�����ӡ�
public class TestTCP3_1 {
	@Test
	// �ͻ���
	public void client() throws Exception {
		// 1������һ��Socket�Ķ���
		Socket socket = new Socket(InetAddress.getByName("192.168.1.111"), 8986);
		// 2���ӱ��ػ�ȡһ���ļ����͸������
		OutputStream os = socket.getOutputStream();
		FileInputStream fis = new FileInputStream(new File("1.jpg"));
		byte[] b = new byte[1024];
		int len;
		while ((len = fis.read(b)) != -1) {
			os.write(b, 0, len);
		}
		socket.shutdownOutput();
		// 3�����շ���˷�������Ϣ
		InputStream is = socket.getInputStream();
		byte[] b1 = new byte[1024];
		int len1;
		while ((len1 = is.read(b1)) != -1) {
			String str = new String(b1, 0, len1);
			System.out.println(str);
		}
		// 4���ر�Socket����Ӧ����
		is.close();
		fis.close();
		os.close();
		socket.close();
	}

	@Test
	// ��������
	public void server() throws Exception {
		// 1������ServerSocket�Ķ���
		ServerSocket ss = new ServerSocket(8986);
		// 2��������accept()����������һ��Socket�Ķ���
		Socket socket = ss.accept();
		// 3�����տͻ��˷��͵��ļ����浽����
		InputStream is = socket.getInputStream();
		OutputStream fos = new FileOutputStream(new File("2.jpg"));
		byte[] b = new byte[1024];
		int len;
		while ((len = is.read(b)) != -1) {
			fos.write(b, 0, len);
		}
		// 4�����͡����ճɹ�����Ϣ�������ͻ���
		OutputStream os = socket.getOutputStream();
		os.write("���ѳɹ������㷢��ͼƬ".getBytes());
		os.close();
		fos.close();
		is.close();
		socket.close();
		ss.close();

	}
}