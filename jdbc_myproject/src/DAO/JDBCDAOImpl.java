package DAO;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDAOImpl<T> implements DAO<T>{
	
	public void batch(Connection connection, String sql, Object[]... args)
			throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public <E> E getForValue(Connection connection, String sql,
			Object[]... args) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public T get(Connection connection, String sql, Object[]... args) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Connection connection, String sql, Object... args) {
		// TODO Auto-generated method stub
		
	}

}
