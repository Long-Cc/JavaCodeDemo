package com.chenlong.java_GUI1;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class WindowMenu extends JFrame{
	private static final long serialVersionUID = 1L;
	JMenuBar menubar;
	JMenu menu,subMenu;
	JMenuItem item1,item2;
	public WindowMenu(){};
	public WindowMenu(String s,int x,int y,int w,int h){
		init(s);
		setLocation(x,y);
		setSize(w,h);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	void init(String s){
		setTitle(s);
		menubar=new JMenuBar();
		menu=new JMenu("菜单");
		subMenu=new JMenu("子菜单");
		item1=new JMenuItem("菜单项1",new ImageIcon("1.jpg"));
		item2=new JMenuItem("菜单项2",new ImageIcon("1jpg"));
		item1.setAccelerator(KeyStroke.getKeyStroke("A"));
		item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
		menu.add(item1);
		menu.addSeparator();
		menu.add(item2);
		menu.add(subMenu);
		subMenu.add(new JMenuItem("子菜单里的菜单项",new ImageIcon("1.jpg")));
		menubar.add(menu);
		setJMenuBar(menubar);
	}
}
