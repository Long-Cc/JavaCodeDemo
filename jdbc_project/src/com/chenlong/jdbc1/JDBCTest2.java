package com.chenlong.jdbc1;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.Test;

public class JDBCTest2 {
	// 1.获取数据库连接
	// 2.准备插入的SQL语句
	// 3.执行插入
	// 1).获取操作SQL语句的Statement对象.:调用Connection的createStatement()方法获取
	// 2)调用Statement对象executeUpdate(sql)执行的SQL语句进行插入
	// 4.关闭Statement对象.
	// 5.关闭连接
	@Test
	public void test() {
		String sql = "INSERT INTO customers (NAME,email,birth)"
				+ "VALUES ('xyz','long@qq.com','1993-10-20')";
		update(sql);
		System.out.println(sql);
		
	}

	public void update(String sql) {
		Connection conn = null;
		Statement sta = null;
		try {
			conn = JDBCTools.getConnection();
			sta = conn.createStatement();
			sta.execute(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTools.release(sta, conn);
		}
	}

}
