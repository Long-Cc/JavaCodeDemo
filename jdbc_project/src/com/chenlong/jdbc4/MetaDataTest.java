package com.chenlong.jdbc4;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.junit.Test;

public class MetaDataTest {
	@Test
	public void testResultSetMetaData() {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			connection=JDBCTools.getConnection();
			String sql="select name student_name,email student_email,birth student_birth from customers";
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			
			ResultSetMetaData rsmd=resultSet.getMetaData();
			int columCount=rsmd.getColumnCount();//列的个数
			System.out.println(columCount);
			for(int i=0;i<columCount;i++){
				String columName=rsmd.getColumnName(i+1);//列名
				String columLable=rsmd.getColumnLabel(i+1);//列的别名
				System.out.println(columName+","+columLable);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCTools.release(preparedStatement, connection, resultSet);
		}
	}

	@Test
	public void testDatabaseMetaData() {
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			DatabaseMetaData data = null;
			connection = JDBCTools.getConnection();
			data = connection.getMetaData();

			int version = data.getDatabaseMajorVersion();
			System.out.println(version);

			String user = data.getUserName();
			System.out.println(user);

			resultSet = data.getCatalogs();
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.release(null, connection, null);
		}
	}
}
