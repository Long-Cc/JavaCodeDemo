package com.java.game;

public class Config {
	public static int SWIDTH=570;//窗口大小 10个wall
	public static int SHEIGHT=570;//10个wall宽
	public static int WIDTH=57;
	
	public static int LIFT=1;//左
	public static int RIGHT=2;//右
	public static int UP=3;//上
	public static int DOWN=4;//下
	//0是路，1是墙，2是入口，3是出口
	public static int ROAD=0;
	public static int WALL=1;
	public static int ENTER=2;
	public static int EXIT=3;
	public static int[][] map=new int [][]
	{
		{1,1,1,3,1,1,1,1,1,1},
		{1,0,1,0,0,0,1,1,0,1},
		{1,0,1,1,1,0,1,1,0,1},
		{1,0,0,0,0,0,0,0,0,1},
		{1,0,1,1,1,1,1,1,1,1},
		{1,0,0,0,0,0,1,1,0,1},
		{1,0,1,1,1,0,0,0,1,1},
		{1,1,0,0,1,1,1,0,0,1},
		{1,0,0,0,0,0,0,0,1,1},
		{1,2,1,1,1,1,1,1,1,1}
	};
}
