package com.java.GUI;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;


@SuppressWarnings("serial")
public class Demo01 extends Frame {
	
	private Panel p=new Panel();
	private Button bt1=new Button("bt1");
	private Button bt2=new Button("clong");
	
	public Demo01(){
		
		super("demo01");
		this.setSize(400, 300);
		this.setLocation(200, 200);
		p.add(bt1);
		p.add(bt2);
		this.add(p);
		bt1.addActionListener(new MyClick());
		bt2.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				Demo01.this.setTitle("获得焦点");
//				JOptionPane.showMessageDialog(null,"获得焦点");
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		this.addWindowListener(new MyLisenter());
		this.setVisible(true);
		
	}
	 class MyClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "你单击了一个按钮"+e.getActionCommand());
		}
		
	}
	 class MyLisenter implements WindowListener{
		 
		 @Override
		 public void windowOpened(WindowEvent e) {
			 // TODO Auto-generated method stub
		 }
		 
		 @Override
		 public void windowClosing(WindowEvent e) {
			 // TODO Auto-generated method stub
		 }
		 
		 @Override
		 public void windowClosed(WindowEvent e) {
			 System.out.println("你关闭了窗口！");
		 }
		 
		 @Override
		 public void windowIconified(WindowEvent e) {
			 // TODO Auto-generated method stub
		 }
		 
		 @Override
		 public void windowDeiconified(WindowEvent e) {
			 // TODO Auto-generated method stub
		 }
		 
		 @Override
		 public void windowActivated(WindowEvent e) {
		 }
		 
		 @Override
		 public void windowDeactivated(WindowEvent e) {
			 // TODO Auto-generated method stub
		 }
		 
	 }
public static void main(String[] args) {
	new Demo01();
	}
}
