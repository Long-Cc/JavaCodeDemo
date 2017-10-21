package com.chenlong.java_zixue_12;

public class TestProduct {
	public static void main(String[] args) {
		
		
		TestProduct t=new TestProduct();
		NoteBook n=new NoteBook();
		t.show(n);
		
		
		//创建了一个实现Product接口的匿名类的匿名对象
		t.show(new Product(){

			@Override
			public void getName() {
				System.out.println("Iphone 5s");
			}

			@Override
			public void getPrice() {
				System.out.println("￥5880");
			}
			
		});	
		
		
	}
	public void show(Product p){
		p.getName();
		p.getPrice();
	}
		
}
interface Product{
	void getName();
	void getPrice();
}
class NoteBook implements Product{

	@Override
	public void getName() {
		System.out.println("HP笔记本");
	}

	@Override
	public void getPrice() {
		System.out.println("￥5000");
	}
	
}