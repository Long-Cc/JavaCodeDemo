package com.chenlong.java.JDBC1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

public class TransationTest {

	@Test
	public void testTransation() {
		Connection connection = null;
		try {
			connection=JDBCTools.getConnection();
			connection.setAutoCommit(false);
			String sql="update user set balance=balance-500 where id=1";
			updata(connection, sql);
			
			sql="update user set balance=balance+500 where id=2";
			updata(connection, sql);
			
			connection.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			JDBCTools.release(null, connection, null);
		}
	}

	private void updata(Connection connection, String sql, Object... args) {
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(sql);

			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTools.release(preparedStatement, null);
		}
	}

}
