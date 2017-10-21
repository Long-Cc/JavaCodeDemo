package com.chenlong.java.JDBC1;

import java.sql.Connection;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

public class DBUtilsTest {
	/**
	 * ����QueryRunner���Update����
	 * ���Զ����ݿ�����ݱ����insert��update��delete
	 */
	@Test
	public void testDBUtils(){
		//1������QueryRunner��ʵ����
		QueryRunner queryRunner= new QueryRunner();
		//2��ʹ��update����
		String sql="delete from customers where id in(?,?)";
		Connection connection=null;
		try {
			connection=JDBCTools.getConnection();
			queryRunner.update(connection, sql, 5,6);
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}finally{
			JDBCTools.release(null, connection);
		}
		
	}
}
