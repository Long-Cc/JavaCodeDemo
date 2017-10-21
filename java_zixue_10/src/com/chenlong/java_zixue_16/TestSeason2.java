package com.chenlong.java_zixue_16;

public class TestSeason2 {
	public static void main(String[] args) {
		Season2 spring = Season2.SPRING;
		spring.show();
		System.out.println(spring.toString());
		System.out.println(spring.getSeasonName());
		System.out.println("==================");
		//.values()����
		Season2[] season=Season2.values();
		for(int i=0;i<season.length;i++){
			System.out.println(season[i]);
		}
		System.out.println("==================");
		//.valuesOf(String name)����
		String str="AUTUMN";
		Season2 sea=Season2.valueOf(str);
		System.out.println(sea);
		sea.show();
	}
}
interface Info{
	void show();
}

enum Season2 implements Info{
	SPRING("����", "��ů����"){
		public void show(){
			System.out.println("��");
		}
	}, 
	SUMMER("����", "��������"){
		public void show(){
			System.out.println("��");
		}
	}, 
	AUTUMN("����", "�����ˬ"){
		public void show(){
			System.out.println("��");
		}
	}, 
	WINTER("����", "��ѩ����"){
		public void show(){
			System.out.println("��");
		}
	};

	private final String seasonName;
	private final String seasonDesc;

	private Season2(String seasonName, String seasonDesc) {
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

//	public void show() {
//		System.out.println("����һ������");
//	}
}
