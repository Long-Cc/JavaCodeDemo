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
	// ����ö����Ķ���
	public static final Season SPRING = new Season("����", "��ů����");
	public static final Season SUMMER = new Season("����", "��������");
	public static final Season AUTUMN = new Season("����", "�����ˬ");
	public static final Season WINTER = new Season("����", "��ѩ����");

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
		System.out.println("����һ������");
	}
}
