package com.java.GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class Demo5 extends JFrame {
	MyButton mb=new MyButton();
	public Demo5(){
		super("demo5");
		this.setSize(600,400);
		this.setLocation(300, 300);
		this.add(mb);
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	
	public static void main(String[] args) {
		new Demo5();
	}
}
@SuppressWarnings("serial")
class MyButton extends JButton{
	public MyButton(){
		super();
		this.setSize(255, 83);
		this.setBorder(null);
		this.setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Image image;
		g.setColor(Color.blue);
		try {
			 image=
					ImageIO.read(this.getClass().getResource("/com/java/GUI/img/sdf.jpg"));
			g.drawImage(image, 0, 0, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
