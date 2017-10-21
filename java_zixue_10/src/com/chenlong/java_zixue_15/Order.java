package com.chenlong.java_zixue_15;

import java.util.ArrayList;
import java.util.List;

/*
 * �Զ��巺����
 */
public class Order<T> {
	private String orderName;
	private int orderId;
	private T t;
	List<T> list = new ArrayList<>();

	public void add() {
		list.add(t);
	}

	// �������ͷ���
	public <E> E getE(E e) {
		return e;
	}

	// ʵ�����鵽���ϵĸ���
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
