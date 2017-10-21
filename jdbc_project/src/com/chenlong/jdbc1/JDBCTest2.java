package com.chenlong.jdbc1;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.Test;

public class JDBCTest2 {
	// 1.��ȡ���ݿ�����
	// 2.׼�������SQL���
	// 3.ִ�в���
	// 1).��ȡ����SQL����Statement����.:����Connection��createStatement()������ȡ
	// 2)����Statement����executeUpdate(sql)ִ�е�SQL�����в���
	// 4.�ر�Statement����.
	// 5.�ر�����
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
