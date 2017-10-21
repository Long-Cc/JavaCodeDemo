package com.chenlong.java_zhixue_6;

public class Mankind {
	private int sex;
	private int salary;
	
	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void manOrWoman(){
		if(sex==1)
			System.out.println("Man");
		else if(sex==0)
			System.out.println("Woman");
		else
			System.out.println("ÊäÈëÓÐÎó£¡");
	}
	public void employeed(){
		if(salary==0)
			System.out.println("no job!");
		else if(salary>0)
			System.out.println("job£¡");
	}
}
