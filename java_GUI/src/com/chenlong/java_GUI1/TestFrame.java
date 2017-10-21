package com.chenlong.java_GUI1;

import javax.swing.JFrame;

public class TestFrame {

	private static final int EXIT_ON_CLOSE = 0;
	private static int DISPOSE_ON_CLOSE;

	public static void main(String[] args) {
		JFrame frame1=new JFrame("´°¿Ú1");
		JFrame frame2=new JFrame("´°¿Ú2");
		frame1.setBounds(60, 100, 180, 100);
		frame2.setBounds(260, 100, 180, 100);
		frame1.setVisible(true);
		frame1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame2.setVisible(true);
		frame2.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
