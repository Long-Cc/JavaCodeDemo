package com.chenlong.java_zixue_23;

import java.net.InetAddress;
import java.net.UnknownHostException;

//InetAddress����IP��ַ
//InetAddress��һ���������һ��IP��ַ
public class TestInetAddress {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress inet = InetAddress.getByName("www.baidu.com");
		System.out.println(inet);
		System.out.println(inet.getHostAddress());//��ȡIP��ַ
		System.out.println(inet.getHostName());//��ȡIP��ַ������
		System.out.println();
		//��ȡ����IP��ַ
		InetAddress inet1 = InetAddress.getLocalHost();
		System.out.println(inet1);
		System.out.println(inet1.getHostAddress());
		System.out.println(inet1.getHostName());
	}

}
