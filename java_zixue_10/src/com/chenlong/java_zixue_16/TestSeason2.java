package com.chenlong.java_zixue_16;

public class TestSeason2 {
	public static void main(String[] args) {
		Season2 spring = Season2.SPRING;
		spring.show();
		System.out.println(spring.toString());
		System.out.println(spring.getSeasonName());
		System.out.println("==================");
		//.values()方法
		Season2[] season=Season2.values();
		for(int i=0;i<season.length;i++){
			System.out.println(season[i]);
		}
		System.out.println("==================");
		//.valuesOf(String name)方法
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
	SPRING("春天", "春暖花开"){
		public void show(){
			System.out.println("春");
		}
	}, 
	SUMMER("夏天", "烈日炎炎"){
		public void show(){
			System.out.println("夏");
		}
	}, 
	AUTUMN("秋天", "秋高气爽"){
		public void show(){
			System.out.println("秋");
		}
	}, 
	WINTER("冬天", "白雪皑皑"){
		public void show(){
			System.out.println("冬");
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
//		System.out.println("这是一个季节");
//	}
}
