package com.java.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {
	private BufferedImage wall = null;
	private BufferedImage left[] = new BufferedImage[4];
	private BufferedImage right[] = new BufferedImage[4];
	private BufferedImage up[] = new BufferedImage[4];
	private BufferedImage down[] = new BufferedImage[4];

	private int row = 0;
	private int col = 0;

	private int dir = 0;// 人物方向
	private int index = 0;// 1、2、3、4人物动画索引

	public GamePanel() {
		super();
		this.setSize(Config.SWIDTH, Config.SHEIGHT);
		initImag();
		this.setVisible(true);
	}

	// 初始化游戏中的图片
	public void initImag() {
		try {
			wall = ImageIO.read(this.getClass().getResource(
					"/com/java/img/wall.jpg"));
			for (int i = 0; i < 4; i++) {
				left[i] = ImageIO.read(this.getClass().getResource(
						"/com/java/img/2_" + (i + 1) + ".jpg"));
				right[i] = ImageIO.read(this.getClass().getResource(
						"/com/java/img/3_" + (i + 1) + ".jpg"));
				up[i] = ImageIO.read(this.getClass().getResource(
						"/com/java/img/4_" + (i + 1) + ".jpg"));
				down[i] = ImageIO.read(this.getClass().getResource(
						"/com/java/img/1_" + (i + 1) + ".jpg"));
			}
		} catch (IOException e) {
			System.out.println("ERROR_001_加载图片出错！！！");
			e.printStackTrace();
		}
	}

	// 初始化地图
	public void initMap(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, Config.SWIDTH, Config.SHEIGHT);
		for (int i = 0; i < Config.map.length; i++) {
			for (int j = 0; j < Config.map[i].length; j++) {
				// 将入口坐标放到row\col中
				if (Config.map[i][j] == Config.ENTER) {
					row = i;
					col = j;
				}
				if (Config.map[i][j] == Config.EXIT) {
					g.setColor(Color.green);
					g.fillRect(Config.WIDTH * j, Config.WIDTH * i,
							Config.WIDTH, Config.WIDTH);
					g.setColor(Color.yellow);
					g.fillOval(Config.WIDTH * j + 15, Config.WIDTH * i + 20,
							10, 10);
					g.fillOval(Config.WIDTH * j + 35, Config.WIDTH * i + 20,
							10, 10);
				}
				if (Config.map[i][j] == Config.WALL) {
					g.drawImage(wall, Config.WIDTH * j, Config.WIDTH * i, null);
				}
			}
			initEntery(g);
		}
	}

	// 画人物入口
	public void initEntery(Graphics g) {
		if (Config.map[row][col] == Config.ENTER) {
			if (col - 1 > 0 && Config.map[row][col - 1] == Config.ROAD) {
				dir = Config.LIFT;
				g.drawImage(left[0], Config.WIDTH * col, Config.WIDTH * row,
						null);
			} else if (col + 1 < 10 && Config.map[row][col + 1] == Config.ROAD) {
				dir = Config.RIGHT;
				g.drawImage(right[0], Config.WIDTH * col, Config.WIDTH * row,
						null);
			} else if (row - 1 > 0 && Config.map[row - 1][col] == Config.ROAD) {
				dir = Config.UP;
				g.drawImage(up[0], Config.WIDTH * col, Config.WIDTH * row, null);
			} else if (row + 1 < 10 && Config.map[row + 1][col] == Config.ROAD) {
				dir = Config.DOWN;
				g.drawImage(down[0], Config.WIDTH * col, Config.WIDTH * row,
						null);
			}
		}

	}
	public void isWin(int row,int col){
		if(row>=0&&row<10&&col>=0&&row<10&&Config.map[row][col] == Config.EXIT){
			int re=JOptionPane.showConfirmDialog(null, "成功！确定退出！");
			if(re==JOptionPane.YES_OPTION){
				System.exit(0);
			}
		}
	}
	// 游戏动作
	public void playGame() {
		if(index==4)index=0;
		Graphics g = this.getGraphics();
		if (dir == Config.LIFT) {
			isWin(col-1,row);
			if(col - 1 > 0 && Config.map[row][col-1] == Config.ROAD){
				g.drawImage(left[index], Config.WIDTH * (col-1), Config.WIDTH * row,
						null);
				fillBlock(g);
				index++;
				col--;
			}
		} else if (dir == Config.RIGHT) {
			isWin(col+1,row);
			if(col + 1 < 10 && Config.map[row][col + 1] == Config.ROAD){
				g.drawImage(right[index], Config.WIDTH * (col+1), Config.WIDTH * row,
						null);
				fillBlock(g);
				index++;
				col++;
			}
		} else if (dir == Config.UP) {
			isWin(col,row-1);
			if (row - 1 > 0 && Config.map[row - 1][col] == Config.ROAD) {
				g.drawImage(up[index], Config.WIDTH * col, Config.WIDTH
						* (row - 1), null);
				fillBlock(g);
				index++;
				row--;
			}
		} else if (dir == Config.DOWN) {
			isWin(col,row+1);
			if(row + 1 < 10 && Config.map[row + 1][col] == Config.ROAD){
				g.drawImage(down[index], Config.WIDTH * col, Config.WIDTH
						* (row + 1), null);
				fillBlock(g);
				index++;
				row++;
			}
		}
		
	}
	public void fillBlock(Graphics g){
		g.setColor(Color.white);
		g.fillRect(col*Config.WIDTH, row*Config.WIDTH, Config.WIDTH, Config.WIDTH);
	}
	@Override
	public void paint(Graphics g) {
		this.initMap(g);
//		this.repaint();
	}

	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return new Dimension(Config.SWIDTH, Config.SHEIGHT);
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

}
