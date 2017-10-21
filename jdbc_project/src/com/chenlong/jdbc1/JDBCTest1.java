package com.chenlong.jdbc1;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.util.Properties;

import org.junit.Test;

public class JDBCTest1 {

	public Connection getConnection() throws Exception {
		String driverClass = null;
		String jdbcUrl = null;
		String user = null;
		String password = null;
		
		//读取类路径下的JDBC.properties配置文件
		InputStream in = getClass().getClassLoader().getResourceAsStream(
				"jdbc.properties");
		Properties properties = new Properties();
		properties.load(in);
		driverClass = properties.getProperty("driver");
		jdbcUrl = properties.getProperty("jdbcUrl");
		user = properties.getProperty("user");
		password = properties.getProperty("password");

		Driver driver = (Driver) Class.forName(driverClass).newInstance();
		Properties info = new Properties();
		info.put("user", user);
		info.put("password", password);
		Connection connection = driver.connect(jdbcUrl, info);

		return connection;
	}

	@Test
	public void testGetConnection() throws Exception {
		System.out.println(getConnection());
	}

}
