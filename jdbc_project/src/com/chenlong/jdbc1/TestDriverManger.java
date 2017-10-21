package com.chenlong.jdbc1;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.junit.Test;

public class TestDriverManger {
	/*1——准备连接数据库的4个字符串
	 * 1.创建Properties对象
	 * 2.获取JDBC.properties对应的输入流
	 * 3.加载2中对应的输入流
	 * 4.具体确定user，password等4个字符串。
	 */
	@Test
	public void testDriverManager() throws Exception {
		//1.准备连接数据库的4个字符串。
		/*
		 * 1.创建Properties对象
		 * 2.获取JDBC.properties对应的输入流
		 * 3.加载2中对应的输入流
		 * 4.具体确定user，password等4个字符串。
		 */
		//驱动的全类名
		String driverClass = null;
		//JDBC URL
		String jdbcUrl = null;
		//user
		String user = null;
		//password
		String password = null;

		// 读取类路径下的JDBC.properties配置文件
		InputStream in = getClass().getClassLoader().getResourceAsStream(
				"jdbc.properties");
		Properties properties = new Properties();
		properties.load(in);
		driverClass = properties.getProperty("driver");
		jdbcUrl = properties.getProperty("jdbcUrl");
		user = properties.getProperty("user");
		password = properties.getProperty("password");
		
		//2.数据库驱动程序
		Class.forName(driverClass);
		
		//3.通过DriverManager的getConnection()方法获取数据库连接。
		Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
		System.out.println(conn);
	}

}
