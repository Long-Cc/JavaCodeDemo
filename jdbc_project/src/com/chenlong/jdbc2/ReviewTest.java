package com.chenlong.jdbc2;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

public class ReviewTest {
	@Test
	public void testResultSet(){
		Connection conn=null;
		Statement state=null;
		ResultSet rs=null;
		
		try {
			conn=getConnection();
			state=conn.createStatement();
			String sql="select id,name,email,birth from customers";
			rs=state.executeQuery(sql);
			
			while(rs.next()){
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String email=rs.getString(3);
				Date birth=rs.getDate(4);
				System.out.println(id);
				System.out.println(name);
				System.out.println(email);
				System.out.println(birth);
				
				System.out.println();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeDB(rs, state, conn);
		}
	}
	@Test
	public void testStatement() {
		Connection conn = null;
		Statement state = null;
		try {
			// 1.获取数据库连接
			conn = getConnection();
			// 2.调用Connection 对象的 createStatement方法获取Statement对象
			state = conn.createStatement();
			// 3.准备SQL语句
			String sql = "update customers set name='jary',email='sina@123.com',birth='1994-12-25' where id=3 ";
			// 4.发送SQL语句:调用Statement对象的 executeUpdate(sql) 方法
			state.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5.关闭数据库资源：由里向外关闭
			closeDB(null, state, conn);
		}
	}

	@Test
	// 应用程序与数据库的一个连接
	public void testGetConnection() throws Exception {

		Connection conn = getConnection();

		System.out.println(conn);
	}

	// 获取数据库链接方法
	private Connection getConnection() throws Exception{

		Properties pro = new Properties();
		InputStream is = ReviewTest.class.getClassLoader().getResourceAsStream(
				"jdbc.properties");

		pro.load(is);

		String user = pro.getProperty("user");
		String password = pro.getProperty("password");
		String jdbcUrl = pro.getProperty("jdbcUrl");
		String driver = pro.getProperty("driver");

		Class.forName(driver);

		Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
		return conn;
	}

	// 关闭数据库资源方法
	public static void closeDB(ResultSet rs, Statement sta, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (sta != null) {
			try {
				sta.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
