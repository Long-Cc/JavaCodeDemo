package com.chenlong.java_zixue_exer1;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class TestExer {
	// ʹ���ֽ���ʵ���������
	@Test
	public void test1() {
		BufferedOutputStream bos=null;
		try {
			FileOutputStream fos = new FileOutputStream(new File("wenjian.txt"));
			bos = new BufferedOutputStream(fos);
			String str = "����һ���κ�վ�����н�ǰC������ZC����"
					+ "ZC֮���ܽ�VXCC�������У�CCCC+ǰC+VXCC�����±�VXCC���Ի�ZX���ˣ���\n"
					+ "XXX+ǰC+VXCC��ͬ�����Ի���ZX������CC+VXCC����CZ+ǰC+VXCC��\n"
					+ "����߶ȹ�����������������X���������������˵�һ����X��ɵ��ϸߣ�֮���ٽ���X����\n"
					+ "��������CC+VXCC����ǽ��������CZ+ǰC+VXCC��\n"
					+ "��������CC+VXCC����CZZ��CCCCZ���ǽ��ܱ�ɱ�ģ�\n"
					+ "VXZ������ɱ������ɱ֮�����ת���VXCC������ת���������X����վ��ɱ֮�����CC+VXCC";
				bos.write(str.getBytes());
		}  catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(bos!=null){
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
