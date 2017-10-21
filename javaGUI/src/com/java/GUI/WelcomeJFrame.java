package com.java.GUI;

import javax.swing.JFrame;

public class WelcomeJFrame extends JFrame {
	public  WelcomeJFrame(String name){
		
			super("登陆成功！！！Welcom:"+name);
			this.setSize(600, 400);
			this.setLocation(200, 200);
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
