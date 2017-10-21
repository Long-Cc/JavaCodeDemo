package com.chenlong.java_zixue_23;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import org.junit.Test;

public class TestUDP {
	//发送端
	@Test
	public void send(){
		DatagramSocket ds=null;
		try {
			ds = new DatagramSocket();
			byte[] b="我是发送端发的数据".getBytes();
			DatagramPacket packet=new DatagramPacket(b, 0, b.length, InetAddress.getByName("192.168.1.111"),8986);
			ds.send(packet);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(ds!=null){
				ds.close();
				
			}
		}
	}
	//接收端
	@Test
	public void rceive(){
		DatagramSocket ds=null;
		try {
			ds = new DatagramSocket(8986);
			byte[] b=new byte[1024];
			DatagramPacket pack=new DatagramPacket(b,0,b.length);
			ds.receive(pack);
			String str=new String(pack.getData(),0,pack.getLength());
			System.out.println(str);
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(ds!=null){
				ds.close();
			}
		}
	}
}
