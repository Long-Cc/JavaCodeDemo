package com.chenlong.jdbc2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class JDBCTest2 {
	
	public <T> T get(Class<T> clazz,String sql,Object ... args ){
		T entity=null;
		//1.�õ�resultSet����
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
			
			//2.�õ�ResultSetMetDate����
			//3.����һ��Map<String,Object>����,��:SQL��ѯ���еı���
			//ֵ:�е�ֵ
			//4.��������.����ResultSetMetDate ���3��Ӧ��Map����
			//5.��Map��Ϊ�����÷��䴴��clazz��Ӧ�Ķ���
			//����Map����,���÷���Ϊclass����Ķ�Ӧ�����Ը�ֵ.
			
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
