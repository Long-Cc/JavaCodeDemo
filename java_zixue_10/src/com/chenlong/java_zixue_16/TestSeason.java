package com.chenlong.java_zixue_16;

public class TestSeason {
	public static void main(String[] args) {
		Season spring=Season.SPRING;
		spring.show();
		System.out.println(spring.toString());
		System.out.println(spring.getSeasonName());
	}
}

class Season {
	private final String seasonName;
	private final String seasonDesc;
	// 创建枚举类的对象
	public static final Season SPRING = new Season("春天", "春暖花开");
	public static final Season SUMMER = new Season("夏天", "烈日炎炎");
	public static final Season AUTUMN = new Season("秋天", "秋高气爽");
	public static final Season WINTER = new Season("冬天", "白雪皑皑");

	private Season(String seasonName, String seasonDesc) {
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}
	// Season s=new Season();

	public String getSeasonName() {
		return seasonName;
	}

	public String getSeasonDesc() {
		return seasonDesc;
	}

	@Override
	public String toString() {
		return "Season [seasonName=" + seasonName + ", seasonDesc=" + seasonDesc + "]";
	}

	public void show() {
		System.out.println("这是一个季节");
	}
}
