package com.chenlong.java_zixue_exer1;

import java.util.List;

public class TestDAO {
	public static void main(String[] args) {
		DAO<User> dao=new DAO<>();
		
		dao.save("1001", new User(1, 45, "AA"));
		dao.save("1002", new User(2, 46, "CC"));
		dao.save("1003", new User(3, 55, "DD"));
		User u=dao.get("1003");
		System.out.println(u);
		dao.update("1002",new User(1,32,"FF"));
		dao.delete("1001");
		List<User> list=dao.list();
		System.out.println(list);
	}
}
