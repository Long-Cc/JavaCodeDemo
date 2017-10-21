package com.chenlong.jdbc1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import org.junit.Test;

public class JDBCTest3 {
	@Test
	// ��ȡid=2��customers���ݱ�ļ�¼������ӡ
	public void testResultSet() {

		Connection conn = null;
		Statement sta = null;
		ResultSet rs = null;
		try {
			// 1.��ȡConnection
			conn = JDBCTools.getConnection();

			// 2.��ȡStatement
			sta = conn.createStatement();

			// 3.׼��SQL
			String sql = "SELECT id,name,email,birth " + "FROM customers";

			// 4.ִ�в�ѯ���õ�ResultSet
			rs = sta.executeQuery(sql);

			// 5.����ResultSet
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
			// 6.�ر����ݿ���Դ
			JDBCTools.release(sta, conn, rs);
		}
	}

}
