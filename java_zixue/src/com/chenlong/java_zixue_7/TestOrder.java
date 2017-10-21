package com.chenlong.java_zixue_7;

public class TestOrder {

	public static void main(String[] args) {
		Order o1=new Order(12,"aa");
		Order o2=new Order(12,"aa");
		System.out.println(o1==o2);
		System.out.println(o1.equals(o2));
	}

}

class Order {
	private int orderId;
	private String orderName;

	public Order(int orderId, String orderName) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (orderId != other.orderId)
			return false;
		if (orderName == null) {
			if (other.orderName != null)
				return false;
		} else if (!orderName.equals(other.orderName))
			return false;
		return true;
	}

//	public boolean equals(Object obj) {
//		if (this == obj) {
//			return true;
//		} else if (obj instanceof Order) {
//			Order o1 = (Order) obj;
//			return this.orderName.equals(o1.orderName) && this.orderId == o1.orderId;
//		}
//		else
//			return false;
//	}
	
}
