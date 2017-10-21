package com.java.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Demo4 extends JFrame {
	private JPanel p=new JPanel();//面板
	private JButton but=new JButton("OK");//按钮
	private JTextField tx=new JTextField(25);//显示框
	private JCheckBox jcb=new JCheckBox("数学",true);//单选框
	private JComboBox<String> jcom=new JComboBox<>(new String[]{"炸彈","按時","爆炸"});//复选框
	public  void initListener(){
		jcom.addItemListener(new ItemListener() {//复选框事件：
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				tx.setText(jcom.getSelectedItem().toString());
				
			}
		});
//		jcb.addChangeListener(new ChangeListener() {
//			
//			@Override
//			public void stateChanged(ChangeEvent e) {
//			//	JOptionPane.showMessageDialog(null, "----"+jcb.isSelected());
//				tx.setText("---"+jcb.isSelected());
//			}
//		});
		jcb.addActionListener(new ActionListener() {//单选框事件：显示框设为单选框的boolean类型数
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tx.setText("---"+jcb.isSelected());
				
			}
		});
		
		but.addActionListener(new ActionListener() {//按钮事件：按下时标题变为显示框的内容
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String txt=tx.getText();
//				JOptionPane.showMessageDialog(null, txt);
				Demo4.this.setTitle(txt);
			}
		});
		tx.addActionListener(new ActionListener() {//显示框事件：改变时标题变为里面的内容
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String txt=tx.getText();
				Demo4.this.setTitle(txt);	
			}
		});
		
	}
	public Demo4(){
		
		super("Demo4");
		this.setSize(600, 400);
		this.setLocation(300, 300);
		p.add(tx);
		p.add(but);
		p.add(jcb);
		p.add(jcom);
		this.add(p);
		this.initListener();
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new Demo4();
	}
}
