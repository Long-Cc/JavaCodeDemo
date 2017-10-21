package com.chenlong.java.JDBC1;

import java.sql.Connection;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

public class DBUtilsTest {
	/**
	 * 测试QueryRunner类的Update方法
	 * 可以对数据库的数据表进行insert，update，delete
	 */
	@Test
	public void testDBUtils(){
		//1、创建QueryRunner的实现类
		QueryRunner queryRunner= new QueryRunner();
		//2、使用update方法
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
