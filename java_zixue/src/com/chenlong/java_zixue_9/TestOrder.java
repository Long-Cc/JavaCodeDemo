package com.chenlong.java_zixue_9;

public class TestOrder {
	public static void main(String[] args) {
		Order o1=new Order();
		Order o2=new Order();
		System.out.println(o1);
		System.out.println(o2);
	}
}
/*���Ը�ֵ��
 *1�� ��ʽ�ĳ�ʼ��---private int orderId=1001;
 *2��������ʼ��---{
		orderId=1002;
		orderName="BB";
	}
 * 3����������ʼ��---public Order(int orederId, String orderName) {
		super();
		this.orderId = orederId;
		this.orderName = orderName;
	}
	4��ͨ�������Զ������Ӧ���Խ����޸�---setXxx()����
 *ִ��˳��1��2˳��ִ��-->������-->4
 *	
 */
class Order{
	private int orderId=1001;
	private String orderName;
	
	//����飬���δ����ֻ��static��û�У�����̬�����ͷǾ�̬����飻
	//��������ԣ���̬����Ǿ�̬����ʼ��,ͬʱҲ�ܵ��ñ��������ķ�������̬��Ǿ�̬��
	//�Ǿ�̬������ʼ��
	{
		orderId=1002;
		orderName="BB";
		System.out.println("���Ǿ�̬�Ĵ����");
	}
	//��̬�����--��������������䣬������ļ��ض����أ�����ֻ������һ�Σ�
	//��̬��������ڷǾ�̬�Ĵ����ִ��
	//��̬�Ĵ����ֻ��ִ�о�̬�Ľṹ(�����ԣ��෽��)
	static{
		System.out.println("���ǷǾ�̬�Ĵ����");
	}
	
	public Order(){
		super();
	}
	public Order(int orederId, String orderName) {
		super();
		this.orderId = orederId;
		this.orderName = orderName;
	}
	public int getOrederId() {
		return orderId;
	}
	public void setOrederId(int orederId) {
		this.orderId = orederId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderName=" + orderName + "]";
	}
	
	
}
