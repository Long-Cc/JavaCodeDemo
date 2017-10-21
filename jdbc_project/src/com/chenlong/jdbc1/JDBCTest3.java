package com.chenlong.jdbc1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import org.junit.Test;

public class JDBCTest3 {
	@Test
	// 获取id=2的customers数据表的纪录，并打印
	public void testResultSet() {

		Connection conn = null;
		Statement sta = null;
		ResultSet rs = null;
		try {
			// 1.获取Connection
			conn = JDBCTools.getConnection();

			// 2.获取Statement
			sta = conn.createStatement();

			// 3.准备SQL
			String sql = "SELECT id,name,email,birth " + "FROM customers";

			// 4.执行查询，得到ResultSet
			rs = sta.executeQuery(sql);

			// 5.处理ResultSet
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString("name");
				String email = rs.getString(3);
				Date birth = rs.getDate(4);

				System.out.println(id);
				System.out.println(name);
				System.out.println(email);
				System.out.println(birth);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6.关闭数据库资源
			JDBCTools.release(sta, conn, rs);
		}
	}

}
