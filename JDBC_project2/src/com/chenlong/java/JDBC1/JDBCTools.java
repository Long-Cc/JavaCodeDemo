package com.chenlong.java.JDBC1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCTools {
	//处理数据库事务
	public static void commit(Connection connection){
		if(connection!=null){
			try {
				connection.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void rollback(Connection connection){
		if(connection!=null){
			try {
				connection.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void beginTx(Connection connection){
		if(connection!=null){
			try {
				connection.setAutoCommit(false);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static DataSource dataSource=null;
	//数据库连接池只被初始化一次
	static{
		dataSource=new ComboPooledDataSource("helloc3p0");
	}
	public static Connection getConnection() throws Exception{
		
		return dataSource.getConnection();
	}
	
	
	public static void release(Statement sta, Connection conn, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
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
				//数据库连接池的Connection对象进行Close时
				//并不是真的进行关闭，而是把该数据库连接会归还到数据库连接池中
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void release(Statement sta, Connection conn) {

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

//	public static Connection getConnection() throws Exception {
//
//		Properties proper = new Properties();
//		InputStream is = JDBCTools.class.getClassLoader().getResourceAsStream(
//				"JDBC.properties");
//		proper.load(is);
//		String user = proper.getProperty("user");
//		String password = proper.getProperty("password");
//		String jdbcUrl = proper.getProperty("jdbcUrl");
//		String driver = proper.getProperty("driver");
//
//		Class.forName(driver);
//		return DriverManager.getConnection(jdbcUrl, user, password);
//	}
}
