package com.chenlong.jdbc2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import org.junit.Test;


public class JDBCTest1 {
	@Test
	public void testPreparedStatement(){
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=JDBCTools.getConnection();
			String sql="insert into customers (name,email,birth) values (?,?,?)";
			ps= conn.prepareStatement(sql);
			ps.setString(1,"Marry");
			ps.setString(2, "123@qq.com");
			ps.setDate(3, new Date(new java.util.Date().getTime()));
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCTools.release(ps, conn);
		}
	}
}
