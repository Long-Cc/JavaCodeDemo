package jdbctools;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTools {
	/**
	 * 获取数据库连接
	 * 
	 * @throws IOException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection() throws IOException, SQLException,
			ClassNotFoundException {
		Properties properties = new Properties();
		InputStream inStream = JDBCTools.class.getClassLoader()
				.getResourceAsStream("jdbc_mysql.properties");
		properties.load(inStream);
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		String jdbcUrl = properties.getProperty("jdbcUrl");
		String driver = properties.getProperty("driver");

		Class.forName(driver);
		return DriverManager.getConnection(jdbcUrl, user, password);
	}

	/**
	 * 进行insert,update,delete等操作
	 */
	public static void update(String sql) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = JDBCTools.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		JDBCTools.release(connection, preparedStatement, null);
	}

	/**
	 * 关闭ResultSet,Statement,Connection
	 */
	public static void release(Connection connection, Statement statement,
			ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭Statement,Connection
	 */
	public static void release(Connection connection, Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
