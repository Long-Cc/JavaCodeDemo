package com.chenlong.jdbc5;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.chenlong.jdbc2.JDBCTools;

public class TestBlob {

	@Test
	public void testInsertBlob() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

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
			JDBCTools.release(preparedStatement, connection, resultSet);

		}
	}
}
