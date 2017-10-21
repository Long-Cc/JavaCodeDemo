package com.java.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Demo6 extends JFrame {
	public static void main(String[] args) throws IOException {

		BufferedImage img = new BufferedImage(400, 400,
				BufferedImage.TYPE_INT_RGB);
		Random ran = new Random();
		Graphics g = img.getGraphics();
		g.setColor(new Color(200, 200, 200));
		g.fillRect(0, 0, 400, 400);

		g.setColor(Color.blue);
		g.setFont(new Font("宋体", Font.BOLD, 40));
		for (int i = 0; i < 12; i++) {
			int x = ran.nextInt(300) + 50;
			int y = ran.nextInt(300) + 50;
			String str = String.valueOf((char) (ran.nextInt(26) + 65));
			int g1 = ran.nextInt(100) + 50;
			int g2 = ran.nextInt(100) + 50;
			int g3 = ran.nextInt(100) + 50;
			g.setColor(new Color(g1, g2, g3));
			g.drawString(str, x, y);
		}
		for (int i = 0; i < 200; i++) {
			int x = ran.nextInt(400);
			int y = ran.nextInt(400);
			int e = ran.nextInt(400);
			int f = ran.nextInt(400);
			int g1 = ran.nextInt(50) + 100;
			int g2 = ran.nextInt(50) + 100;
			int g3 = ran.nextInt(50) + 100;
			g.setColor(new Color(g1, g2, g3));
			g.drawLine(x, y, e, f);
		}
		ImageIO.write(img, "jpg", new File("d:\\tu2.jpg"));
		System.out.println("OK");
	}
}
