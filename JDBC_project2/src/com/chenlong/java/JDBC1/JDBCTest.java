package com.chenlong.java.JDBC1;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCTest {

	@Test 
	public void testC3P02() throws Exception{
		DataSource dataSource=
				new ComboPooledDataSource("helloc3p0");
		System.out.println(dataSource.getConnection());
		ComboPooledDataSource comboPooledDataSource=
				(ComboPooledDataSource) dataSource;
		System.out.println(comboPooledDataSource.getMaxStatements());
				
	}
	
	
	@Test 
	public void testC3P0() throws Exception{
		ComboPooledDataSource cpds=new ComboPooledDataSource();
		cpds.setDriverClass("com.mysql.jdbc.Driver");
		cpds.setJdbcUrl("jdbc:mysql:///mydata");
		cpds.setUser("root");
		cpds.setPassword("root");
		System.out.println(cpds.getConnection());
	}
	
	
	
	/**
	 * 1������dbcp��properties�����ļ��������ļ��еļ���Ҫ����BasicDataSource������
	 * 2������BasicDataSourceFactory��createDataSource��������DataSourceʵ��
	 * 3����DataSourceʵ���л�ȡ���ݿ�����
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDBCP2() throws Exception {
		Properties properties = new Properties();
		InputStream inStream = JDBCTest.class.getClassLoader()
				.getResourceAsStream("dbcp.properties");
		properties.load(inStream);

		DataSource dataSource = BasicDataSourceFactory
				.createDataSource(properties);
		System.out.println(dataSource.getConnection());

		BasicDataSource basicDataSource = (BasicDataSource) dataSource;
		System.out.println(basicDataSource.getMaxWait());
	}

	/**
	 * ʹ��DBCP���ݿ����ӳ� 1������jar�� 2���������ݿ����ӳ� 3��Ϊ����Դʵ��ָ����������� 1)��ָ������Դ��һЩ��ѡ������
	 * 4��������Դ�л�ȡ���ݿ�����
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testDBCP() throws SQLException {
		// 1������DBCP����Դʵ��
		BasicDataSource basicDataSource = null;
		basicDataSource = new BasicDataSource();
		// 2��Ϊ����Դʵ��ָ�����������
		basicDataSource.setUsername("root");
		basicDataSource.setPassword("root");
		basicDataSource.setUrl("jdbc:mysql://localhost:3306/mydata");
		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		// 3��ָ������Դ��һЩ��ѡ������
		// 1)ָ�����ݿ����ӳ��г�ʼ�����ӵĸ���
		basicDataSource.setInitialSize(5);
		// 2)ָ������������:ͬһʱ�̿���ͬʱ�����ݿ������������
		basicDataSource.setMaxActive(5);
		// 3)ָ����С��������:�����ݿ����ӳ��б�������ٵĿ������ӵ�����
		basicDataSource.setMinIdle(2);
		// 4)��ĵȴ�ʱ��
		basicDataSource.setMaxWait(1000 * 5);// ��λ����
		// 4��������Դ�л�ȡ���ݿ�����
		Connection connection = basicDataSource.getConnection();
		System.out.println(connection.getClass());
		
		connection = basicDataSource.getConnection();
		System.out.println(connection.getClass());
		
		connection = basicDataSource.getConnection();
		System.out.println(connection.getClass());
		
		connection = basicDataSource.getConnection();
		System.out.println(connection.getClass());
		
		connection = basicDataSource.getConnection();
		System.out.println(">"+connection.getClass());
		
		connection = basicDataSource.getConnection();
		System.out.println(connection.getClass());
	}

	@Test
	// 3.ʹ��PreparedStatement.addBatch:����
	public void test3() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		JDBCTools.beginTx(connection);

		long begin = System.currentTimeMillis();

		try {
			connection = JDBCTools.getConnection();
			System.out.println(connection);
			String sql = "insert into customers values(?,?,?)";

			preparedStatement = connection.prepareStatement(sql);

			Date date = new Date(new java.util.Date().getTime());
			for (int i = 0; i < 100000; i++) {
				preparedStatement.setInt(1, i + 1);
				preparedStatement.setString(2, "name_" + i);
				preparedStatement.setDate(3, date);
				preparedStatement.addBatch();
				if ((i + 1) % 30 == 0) {
					preparedStatement.executeBatch();
					preparedStatement.clearBatch();
				}
			}
			if (1000000 % 300 != 0) {
				preparedStatement.executeBatch();
				preparedStatement.clearBatch();
			}
			long end = System.currentTimeMillis();
			System.out.println("long=" + (end - begin));// long=1710

			JDBCTools.commit(connection);
		} catch (Exception e) {
			e.printStackTrace();
			JDBCTools.rollback(connection);
		} finally {
			JDBCTools.release(preparedStatement, connection);
		}
	}

	@Test
	// 2.ʹ��PreparedStatement
	public void test2() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		JDBCTools.beginTx(connection);

		long begin = System.currentTimeMillis();

		try {
			connection = JDBCTools.getConnection();
			System.out.println(connection);
			String sql = "insert into customers values(?,?,?)";

			preparedStatement = connection.prepareStatement(sql);

			Date date = new Date(new java.util.Date().getTime());
			for (int i = 0; i < 100000; i++) {
				preparedStatement.setInt(1, i + 1);
				preparedStatement.setString(2, "name_" + i);
				preparedStatement.setDate(3, date);

				preparedStatement.executeUpdate();
			}
			long end = System.currentTimeMillis();
			System.out.println("long=" + (end - begin));// long=34603

			JDBCTools.commit(connection);
		} catch (Exception e) {
			e.printStackTrace();
			JDBCTools.rollback(connection);
		} finally {
			JDBCTools.release(preparedStatement, connection);
		}
	}

	/**
	 * ��oracle��customers���ݱ��в���10�������� ������β��룬��ʱ��� 1.ʹ��Statement
	 * 
	 */
	@Test
	public void test1() {
		Connection connection = null;
		Statement statement = null;
		JDBCTools.beginTx(connection);
		long begin = System.currentTimeMillis();
		try {
			connection = JDBCTools.getConnection();
			System.out.println(connection);
			statement = connection.createStatement();
			for (int i = 0; i < 100000; i++) {
				String sql = "insert into customers values(" + (i + 1)
						+ ",'name_" + i + "','29-6��-12')";
				statement.executeUpdate(sql);
			}
			long end = System.currentTimeMillis();
			System.out.println("long=" + (end - begin));// long=76429
			JDBCTools.commit(connection);
		} catch (Exception e) {
			e.printStackTrace();
			JDBCTools.rollback(connection);
		} finally {
			JDBCTools.release(statement, connection);
		}
	}

}
