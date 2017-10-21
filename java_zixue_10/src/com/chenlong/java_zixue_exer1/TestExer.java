package com.chenlong.java_zixue_exer1;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class TestExer {
	// 使用字节流实现内容输出
	@Test
	public void test1() {
		BufferedOutputStream bos=null;
		try {
			FileOutputStream fos = new FileOutputStream(new File("wenjian.txt"));
			bos = new BufferedOutputStream(fos);
			String str = "首先一个任何站立连招接前C（等于ZC），"
					+ "ZC之后都能接VXCC，连招有，CCCC+前C+VXCC（悬崖边VXCC可以换ZX推人），\n"
					+ "XXX+前C+VXCC（同样可以换成ZX），跑CC+VXCC，跑CZ+前C+VXCC，\n"
					+ "如果高度够可以连续接两次跑X（敌人跳过来中了第一次跳X会飞的老高，之后再接跑X），\n"
					+ "反击接跑CC+VXCC，靠墙反击接跑CZ+前C+VXCC，\n"
					+ "爆气接跑CC+VXCC，跑CZZ和CCCCZ都是接跑必杀的，\n"
					+ "VXZ接跳必杀，跳必杀之后可以转身接VXCC（或者转身接两次跑X），站比杀之后接跑CC+VXCC";
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
