package com.java.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	
	GamePanel game=new GamePanel();
	public MainFrame(){
		super("迷宫V1.0");
		this.setSize(Config.SWIDTH+6, Config.SHEIGHT+26);
//		this.setLocation(200, 0);
		this.add(game);
		this.setVisible(true);
		this.setResizable(false);//不能放大缩小
		this.setLocationRelativeTo(null);//居中
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					game.setDir(Config.UP);
					break;
				case KeyEvent.VK_LEFT:
					game.setDir(Config.LIFT);
					break;
				case KeyEvent.VK_RIGHT:
					game.setDir(Config.RIGHT);
					break;
				case KeyEvent.VK_DOWN:
					game.setDir(Config.DOWN);
					break;
				default:
					break;
				}
				game.playGame();
			}
		});
	}
	
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
