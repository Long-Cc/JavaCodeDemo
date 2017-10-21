package com.chenlong.jdbc2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class JDBCTest2 {
	
	public <T> T get(Class<T> clazz,String sql,Object ... args ){
		T entity=null;
		//1.得到resultSet对象
		Connection connection=null;
		PreparedStatement prepardStatement=null;
		ResultSet resultSet=null;
		try {
			connection=JDBCTools.getConnection();
			prepardStatement=connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				prepardStatement.setObject(i+1, args[i]);
			}
			resultSet=prepardStatement.executeQuery();
			
			//2.得到ResultSetMetDate对象
			//3.创建一个Map<String,Object>对象,键:SQL查询的列的别名
			//值:列的值
			//4.处理结果集.利用ResultSetMetDate 填充3对应的Map对象
			//5.若Map不为空利用反射创建clazz对应的对象
			//遍历Map对象,利用反射为class对象的对应的属性赋值.
			
			if(resultSet.next()){
				entity=clazz.newInstance();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTools.release(prepardStatement, connection, resultSet);
		}
		return null;
	}
	public Customer getCustomer(String sql,Object ... args){
		Customer customer=null;
		Connection connection=null;
		PreparedStatement prepardStatement=null;
		ResultSet resultSet=null;
		
		try {
			connection=JDBCTools.getConnection();
			prepardStatement=connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				prepardStatement.setObject(i+1, args[i]);
			}
			resultSet=prepardStatement.executeQuery();
			if(resultSet.next()){
				
				customer=new Customer();
				customer.setId(resultSet.getInt(1));
				customer.setName(resultSet.getString(2));
				customer.setEmail(resultSet.getString(3));
				customer.setBirth(resultSet.getDate(4));
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTools.release(prepardStatement, connection, resultSet);
		}
		return customer;
	}
	
}
