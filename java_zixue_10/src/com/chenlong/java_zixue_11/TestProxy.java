package com.chenlong.java_zixue_11;
//�ӿڵ�Ӧ�ã�����ģʽ
public class TestProxy {
	public static void main(String[] args) {
		Object obj=new ProxyObject();
		obj.action();
	}
}
interface Object{
	void action();
}
//������
class ProxyObject implements Object{
	Object obj;
	public ProxyObject(){
		System.out.println("�����ഴ���ɹ�");
		obj=new ObjectImpl();
	}
	@Override
	public void action() {
		System.out.println("�����࿪ʼִ��");
		obj.action();
		System.out.println("���������");
		
	}
//��������	
}
class ObjectImpl implements Object{

	@Override
	public void action() {
				System.out.println("====�������࿪ʼִ��======");
	}
	
}