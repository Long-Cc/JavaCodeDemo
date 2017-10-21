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
	 * 1、加载dbcp的properties配置文件：配置文件中的键需要来自BasicDataSource的属性
	 * 2、调用BasicDataSourceFactory的createDataSource方法创建DataSource实例
	 * 3、从DataSource实例中获取数据库连接
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
	 * 使用DBCP数据库连接池 1、加入jar包 2、创建数据库连接池 3、为数据源实例指定必须的属性 1)、指定数据源的一些可选的属性
	 * 4、从数据源中获取数据库连接
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testDBCP() throws SQLException {
		// 1、创建DBCP数据源实例
		BasicDataSource basicDataSource = null;
		basicDataSource = new BasicDataSource();
		// 2、为数据源实例指定必须的属性
		basicDataSource.setUsername("root");
		basicDataSource.setPassword("root");
		basicDataSource.setUrl("jdbc:mysql://localhost:3306/mydata");
		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		// 3、指定数据源的一些可选的属性
		// 1)指定数据库联接池中初始化连接的个数
		basicDataSource.setInitialSize(5);
		// 2)指定最大的连接数:同一时刻可以同时向数据库申请的连接数
		basicDataSource.setMaxActive(5);
		// 3)指定最小的连接数:在数据库连接池中保存的最少的空闲连接的数量
		basicDataSource.setMinIdle(2);
		// 4)最长的等待时间
		basicDataSource.setMaxWait(1000 * 5);// 单位毫秒
		// 4、从数据源中获取数据库连接
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
	// 3.使用PreparedStatement.addBatch:积攒
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
	// 2.使用PreparedStatement
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
	 * 向oracle的customers数据表中插入10万条数据 测试如何插入，用时最短 1.使用Statement
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
						+ ",'name_" + i + "','29-6月-12')";
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
