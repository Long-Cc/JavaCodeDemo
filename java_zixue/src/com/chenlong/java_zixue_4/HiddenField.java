package com.chenlong.java_zixue_4;
	//��������
public class HiddenField {

	public static void main(String[] args) {
		OrdinaryPhone familyPhone=new OrdinaryPhone();
		familyPhone.internationalService=true;
		familyPhone.balance=50.0;
		System.out.println("���౻���ص���"+familyPhone.getBalance());
		if(familyPhone.chargeStyle(9)){
			System.out.println("�����ʣ���"+familyPhone.balance);
		}
	}

}
