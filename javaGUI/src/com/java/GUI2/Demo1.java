package com.java.GUI2;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Demo1 extends JFrame {
	public Demo1() {
		initJFrame();
		initUI();
	}

	public void initUI() {
		JLabel lab=new JLabel();
		ImageIcon img = new ImageIcon(this.getClass().getResource(
				"/com/java/GUI/img/tu.jpg"));
		lab.setSize(453, 81);
		lab.setIcon(img);
		this.add(lab);
		
	}

	public void initJFrame() {
		this.setSize(800, 600);
		this.setTitle("TEST");
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Demo1();
	}
}
