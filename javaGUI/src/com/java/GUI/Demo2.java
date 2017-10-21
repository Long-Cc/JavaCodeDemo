package com.java.GUI;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class Demo2 extends Frame {
	
	private Button but=new Button("OK");
	private TextField tx=new TextField("input",25);
	private TextField pw=new TextField("pp",25);
	private Label lab=new Label("Hello");
	
	
	
	public Demo2(){
		super("Demo2");
		this.setSize(600,400);
		this.setLocation(200, 200);
		this.setLayout(new FlowLayout());
		this.add(but);
		this.add(tx);
		pw.setEchoChar('*');
		this.add(pw);
		this.add(lab);
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new Demo2();
	}
}
