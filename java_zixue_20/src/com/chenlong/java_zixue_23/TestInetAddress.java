package com.chenlong.java_zixue_23;

import java.net.InetAddress;
import java.net.UnknownHostException;

//InetAddress代表IP地址
//InetAddress的一个对象代表一个IP地址
public class TestInetAddress {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress inet = InetAddress.getByName("www.baidu.com");
		System.out.println(inet);
		System.out.println(inet.getHostAddress());//获取IP地址
		System.out.println(inet.getHostName());//获取IP地址的域名
		System.out.println();
		//获取本机IP地址
		InetAddress inet1 = InetAddress.getLocalHost();
		System.out.println(inet1);
		System.out.println(inet1.getHostAddress());
		System.out.println(inet1.getHostName());
	}

}
