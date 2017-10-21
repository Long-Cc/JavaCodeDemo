package com.chenlong.java_zixue_15;

import java.util.ArrayList;
import java.util.List;

/*
 * 自定义泛型类
 */
public class Order<T> {
	private String orderName;
	private int orderId;
	private T t;
	List<T> list = new ArrayList<>();

	public void add() {
		list.add(t);
	}

	// 声明泛型方法
	public <E> E getE(E e) {
		return e;
	}

	// 实现数组到集合的复制
	public <E> List<E> fromArrayToList(E[] e, List<E> list) {
		for (E e1 : e) {
			list.add(e1);
		}
		return list;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

}
