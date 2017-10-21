package com.chenlong.jdbc1;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

public class JDBCTest {

	@Test
	public void testDriver() throws SQLException {
		Driver driver=new com.mysql.jdbc.Driver();
		
		String url="jdbc:mysql://localhost:3306/test";
		Properties info=new Properties();
		info.put("user", "root");
		info.put("password","root");
		
		Connection connection=driver.connect(url, info);
		System.out.println(connection);
	}

}
