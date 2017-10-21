package com.chenlong.java_GUI1;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class WindowText extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField text1,text2;
	public WindowText() {
		init();
		setBounds(100, 100, 236, 150);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	void init() {
		setLayout(new FlowLayout());
		text1=new JTextField("按法定几号放假",10);
		text1.setEditable(false);
		text1.setHorizontalAlignment(JTextField.CENTER);
		text2=new JTextField(10);
		add(text1);
		add(text2);
	}
}