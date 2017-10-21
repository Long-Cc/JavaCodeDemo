package com.chenlong.java.JDBC1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class TestBlob {
	@Test
	public void testReadBlob(){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet=null;
		try {
			connection=JDBCTools.getConnection();
			String sql="select id,name,email,birth,picture from customers where id=7";
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				int id=resultSet.getInt(1);
				String name=resultSet.getString(2);
				String email=resultSet.getString(3);
				System.out.println(id+","+name+","+email);
				
				Blob pictrue=resultSet.getBlob(5);
				InputStream in=pictrue.getBinaryStream();
				OutputStream out=new FileOutputStream("flowe.jpg");
				
				byte [] buffer=new byte[1024];
				int len=0;
				while((len=in.read(buffer))!=-1){
					out.write(buffer,0,len);
				}
				out.close();
				in.close();
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}finally{
			JDBCTools.release(preparedStatement, connection,resultSet);
		}
	}
	
	
	@Test
	public void testInsertBlob() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = JDBCTools.getConnection();
			String sql = "insert into customers(name,email,birth,picture) values (?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "ABCD");
			preparedStatement.setString(2, "12306@163.cm");
			preparedStatement.setDate(3,
					new Date(new java.util.Date().getTime()));

			InputStream inputStream = new FileInputStream("Koala.jpg");
			preparedStatement.setBlob(4, inputStream);

			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.release(preparedStatement, connection);

		}
	}
}
