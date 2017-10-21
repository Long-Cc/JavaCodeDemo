package com.chenlong.jdbc1;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTools {
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

	public static Connection getConnection() throws Exception {

		Properties proper = new Properties();
		InputStream is = JDBCTools.class.getClassLoader().getResourceAsStream(
				"JDBC.properties");
		proper.load(is);
		String user = proper.getProperty("user");
		String password = proper.getProperty("password");
		String jdbcUrl = proper.getProperty("jdbcUrl");
		String driver = proper.getProperty("driver");

		Class.forName(driver);
		return DriverManager.getConnection(jdbcUrl, user, password);
	}
}
