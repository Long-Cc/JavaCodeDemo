package com.chenlong.java_zixue_4;
	//测试主类
public class HiddenField {

	public static void main(String[] args) {
		OrdinaryPhone familyPhone=new OrdinaryPhone();
		familyPhone.internationalService=true;
		familyPhone.balance=50.0;
		System.out.println("父类被隐藏的余额："+familyPhone.getBalance());
		if(familyPhone.chargeStyle(9)){
			System.out.println("子类的剩余金额："+familyPhone.balance);
		}
	}

}
