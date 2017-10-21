package com.chenlong.java_zixue_11;

public class SalariedEmployee extends Employee {
	private double monthlySalary;// ิยนคืส

	public SalariedEmployee(String name,int number,MyDate birthday,double monthlySalary) {
		super(name,number,birthday);
		this.monthlySalary = monthlySalary;
	}

	@Override
	public double earnings() {
		return monthlySalary;
	}

	@Override
	public String toString() {
		return "SalariedEmployee [" + super.toString() + "monthlySalary=" + monthlySalary + "]";
	}

}
