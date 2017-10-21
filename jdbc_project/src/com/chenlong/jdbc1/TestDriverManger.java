package com.chenlong.jdbc1;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.junit.Test;

public class TestDriverManger {
	/*1����׼���������ݿ��4���ַ���
	 * 1.����Properties����
	 * 2.��ȡJDBC.properties��Ӧ��������
	 * 3.����2�ж�Ӧ��������
	 * 4.����ȷ��user��password��4���ַ�����
	 */
	@Test
	public void testDriverManager() throws Exception {
		//1.׼���������ݿ��4���ַ�����
		/*
		 * 1.����Properties����
		 * 2.��ȡJDBC.properties��Ӧ��������
		 * 3.����2�ж�Ӧ��������
		 * 4.����ȷ��user��password��4���ַ�����
		 */
		//������ȫ����
		String driverClass = null;
		//JDBC URL
		String jdbcUrl = null;
		//user
		String user = null;
		//password
		String password = null;

		// ��ȡ��·���µ�JDBC.properties�����ļ�
		InputStream in = getClass().getClassLoader().getResourceAsStream(
				"jdbc.properties");
		Properties properties = new Properties();
		properties.load(in);
		driverClass = properties.getProperty("driver");
		jdbcUrl = properties.getProperty("jdbcUrl");
		user = properties.getProperty("user");
		password = properties.getProperty("password");
		
		//2.���ݿ���������
		Class.forName(driverClass);
		
		//3.ͨ��DriverManager��getConnection()������ȡ���ݿ����ӡ�
		Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
		System.out.println(conn);
	}

}
