package com.chenlong.java_zixue_11;
//�������������ģʽ
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
		System.out.println("ѧ��д��ҵ");
	}
	
}
class TeacherWork implements Work{

	@Override
	public void doWork() {
		System.out.println("��ʦ������ҵ");
	}
	
}