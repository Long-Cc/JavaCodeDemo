package com.chenlong.java_zixue_9;

public class TestOrder {
	public static void main(String[] args) {
		Order o1=new Order();
		Order o2=new Order();
		System.out.println(o1);
		System.out.println(o2);
	}
}
/*属性赋值：
 *1、 显式的初始化---private int orderId=1001;
 *2、代码块初始化---{
		orderId=1002;
		orderName="BB";
	}
 * 3、构造器初始化---public Order(int orederId, String orderName) {
		super();
		this.orderId = orederId;
		this.orderName = orderName;
	}
	4、通过方法对对象的相应属性进行修改---setXxx()方法
 *执行顺序：1与2顺序执行-->构造器-->4
 *	
 */
class Order{
	private int orderId=1001;
	private String orderName;
	
	//代码块，修饰代码块只有static或没有，即静态代码块和非静态代码块；
	//对类的属性（静态的与非静态）初始化,同时也能调用本类声明的方法（静态与非静态）
	//非静态代码块初始化
	{
		orderId=1002;
		orderName="BB";
		System.out.println("我是静态的代码块");
	}
	//静态代码块--里面可以有输出语句，随着类的加载而加载，而且只被加载一次；
	//静态代码块早于非静态的代码块执行
	//静态的代码块只能执行静态的结构(类属性，类方法)
	static{
		System.out.println("我是非静态的代码块");
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
