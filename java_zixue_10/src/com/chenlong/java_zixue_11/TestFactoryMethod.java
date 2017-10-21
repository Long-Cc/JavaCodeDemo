package com.chenlong.java_zixue_11;
//工厂方法的设计模式
class TestFactoryMethod{
	public static void main(String[] args) {
		IWorkFactory i=new StudentWorkFactory();
		i.getWork().doWork();
		
		IWorkFactory i2=new TeacherWorkFactory();
		i2.getWork().doWork();
	}
}
interface IWorkFactory{
	Work getWork();
}
class StudentWorkFactory implements IWorkFactory{

	@Override
	public Work getWork() {
		return new StudentWork();
	}
	
}
class TeacherWorkFactory implements IWorkFactory{

	@Override
	public Work getWork() {
		return new TeacherWork();
	}
	
}

interface Work{
	void doWork();
}
class StudentWork implements Work{

	@Override
	public void doWork() {
		System.out.println("学生写作业");
	}
	
}
class TeacherWork implements Work{

	@Override
	public void doWork() {
		System.out.println("老师批改作业");
	}
	
}