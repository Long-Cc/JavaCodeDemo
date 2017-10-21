package com.java.GUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Demo3 extends JFrame {
//	private Box box0=Box.createHorizontalBox();
	private Box box1=Box.createHorizontalBox();
	private Box box2=Box.createHorizontalBox();
	private Box box3=Box.createHorizontalBox();
	private Box box4=Box.createVerticalBox();
	
	private Icon icon=null;
	private JLabel top=new JLabel();
	private JLabel luser=new JLabel("用户名：");
	private JLabel lpwd=new JLabel("密   码：");
	private JTextField user=new JTextField(25);
	private JPasswordField pwd=new JPasswordField(25);
	private JButton ok=new JButton("登陆");
	private JButton cancel=new JButton("取消");
	
	public void init(){
		icon=new ImageIcon(this.getClass().getResource("/com/java/GUI/img/sdf.jpg"));
		top.setSize(255,83);
		top.setIcon(icon);
//		box0.add(top);
		
		box1.add(Box.createHorizontalStrut(15));
		box1.add(luser);
		box1.add(user);
		box1.add(Box.createHorizontalStrut(40));
		
		box2.add(Box.createHorizontalStrut(17));
		box2.add(lpwd);
		box2.add(pwd);
		box2.add(Box.createHorizontalStrut(40));
		
		box3.add(Box.createHorizontalStrut(40));
		box3.add(ok);
		box3.add(Box.createHorizontalStrut(20));
		box3.add(cancel);
		
		box4.add(top);
		box4.add(Box.createVerticalStrut(30));
		box4.add(box1);
		box4.add(Box.createVerticalStrut(30));
		box4.add(box2);
		box4.add(Box.createVerticalStrut(30));
		box4.add(box3);
		
		
		this.add(box4);
	}
	
	public Demo3(){
		super("Login");
		this.setSize(300,300);//窗体大小
		//this.setLocation(200, 200);
		
		Toolkit tool=Toolkit.getDefaultToolkit();
		Dimension dim=tool.getScreenSize();
		int width=(int)dim.getWidth();//获取屏幕的长
		int height=(int)dim.getHeight();//获取屏幕的宽
		this.setLocation((width-400)/2, (height-300)/2);//窗口的位置
		
		init();
		ok.addActionListener(new ActionListener() {//事件监听
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name=user.getText();
				String password=new String(pwd.getPassword());
				if(name!=null&&password!=null&&"admin".equals(name)&&"123".equals(password)){
					new WelcomeJFrame(name);
					Demo3.this.dispose();
				}else{
					JOptionPane.showMessageDialog(null, "用户名或密码不正确！");
					user.setText("");
					pwd.setText("");
				}
				
				
			}
		});
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new Demo3();
	}
}
