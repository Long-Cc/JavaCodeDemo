package com.chenlong.jdbc3;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanUtils;

import com.chenlong.jdbc2.JDBCTools;

public class DAO {
	// update select insert 等操作
	public void update(String sql, Object... args) {
		Connection conn = null;
		PreparedStatement pre = null;

		try {
			conn = JDBCTools.getConnection();
			pre = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				pre.setObject(i + 1, args[i]);
			}
			pre.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTools.release(pre, conn, null);
		}
	}

	/**
	 * 1.获取Connection 2.获取PreparedStatement 3.填充占位符 4.进行查询，得到ResultSet
	 * 5.若ResultSet中有记录 准备一个Map<String,Object>:键：存放列的别名 值：存放列的值
	 * 6.得到ResultSetMetaData对象 7.处理ResultSet，把指针向下移动一个单位
	 * 8.由ResultSetMetaData对象得到结果集有多少列
	 * 9.由ResultSetMetaData得到每一列的别名,由ResultSet得到具体每一列的值 10.填充Map对象
	 * 11.用反射创建Class对应的对象 12.遍历Map对象，用反射填充对象对象的属性值： 属性名为Map中的Key，属性值为Map中的value
	 * 
	 * @author longc
	 */
	// 查询一条纪录,返回对应对象
	public <T> T get(Class<T> clazz, String sql, Object... args) {

		T entity = null;
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs = null;

		try {
			// 1.获取Connection
			conn = JDBCTools.getConnection();
			// 2.获取PreparedStatement
			pre = conn.prepareStatement(sql);
			// 3.填充占位符
			for (int i = 0; i < args.length; i++) {
				pre.setObject(i + 1, args[i]);
			}
			// 4.进行查询，得到ResultSet
			rs = pre.executeQuery();

			if (rs.next()) {
				// 5.若ResultSet中有记录 准备一个Map<String,Object>:键：存放列的别名 值：存放列的值
				Map<String, Object> values = new HashMap<String, Object>();
				// 6.得到ResultSetMetaData对象
				ResultSetMetaData rsmd = rs.getMetaData();
				// 7.处理ResultSet，把指针向下移动一个单位

				// 8.由ResultSetMetaData对象得到结果集有多少列
				int columCount = rsmd.getColumnCount();
				for (int i = 0; i < columCount; i++) {
					// 9.由ResultSetMetaData得到每一列的别名,由ResultSet得到具体每一列的值
					String columnLabel = rsmd.getColumnLabel(i + 1);
					Object columnValue = rs.getObject(i + 1);
					// 10.填充Map对象
					values.put(columnLabel, columnValue);
				}
				// 11.用反射创建Class对应的对象
				entity = clazz.newInstance();

				// 12.遍历Map对象，用反射填充对象对象的属性值： 属性名为Map中的Key，属性值为Map中的value
				for (Entry<String, Object> entry : values.entrySet()) {
					String propertyName = entry.getKey();
					Object value = entry.getValue();

					ReflectionUtils.setFieldValue(entity, propertyName, value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.release(pre, conn, rs);
		}
		return entity;
	}

	// 查询多条纪录,返回对应对象的集合
	/**
	 * 5.准备一个List<Map<String,Object>> :键 存放列的别名，值：存放列的值.其中一个Map对象对应一条记录
	 * 7.处理ResultSet，使用while循环 11.把填充好的Map对象放入5准备的list中 12.判断List
	 * 是否为空集合，若不为空， 则遍历List，得到一个一个的Map对象，再把一个Map对象转为一个Class参数对应的Object对象
	 * 13.把Object 对象放入到list中。
	 */
	public <T> List<T> getForList(Class<T> clazz, String sql, Object... args) {
		
		List<T> list = new ArrayList<T>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			//1.得到结果集
			connection = JDBCTools.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}
			resultSet = preparedStatement.executeQuery();
			//2.处理结果集，得到Map 的 List，其中一个Map对象
			//就是一条记录，Map的key为resultSet中列的别名，Map的value为列的值
			List<Map<String, Object>> values = 
					handleResluSetToMapList(resultSet);
			//3。把Map 的list 转为clazz对应的List
			//其中Map的key即为clazz 对应对象的propertyName，
			//而Map的value即位clazz对应对象的propertyValue，
			list = transfterMapListToBeanbList(clazz, values);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.release(preparedStatement, connection, resultSet);
		}
		return list;
	}

	private <T> List<T> transfterMapListToBeanbList(Class<T> clazz,
			List<Map<String, Object>> values) throws InstantiationException,
			IllegalAccessException, InvocationTargetException {

		List<T> result = new ArrayList<T>();

		T bean = null;

		if (values.size() > 0) {
			for (Map<String, Object> m : values) {
				bean = clazz.newInstance();
				for (Map.Entry<String, Object> entry : m.entrySet()) {
					String propertyName = entry.getKey();
					Object value = entry.getValue();

					BeanUtils.setProperty(bean, propertyName, value);
				}
				// 13.把Object 对象放入到list中。
				result.add(bean);
			}
		}
		return result;
	}

	private List<Map<String, Object>> handleResluSetToMapList(
			ResultSet resultSet) throws Exception, SQLException {
		// 5.准备一个List<Map<String,Object>>
		// :键 存放列的别名，值：存放列的值.其中一个Map对象对应一条记录
		List<Map<String, Object>> values = new ArrayList<Map<String, Object>>();

		List<String> columnLabels = getColumnLabels(resultSet);

		Map<String, Object> map = null;

		// 7.处理ResultSet，使用while循环
		while (resultSet.next()) {
			map = new HashMap<String, Object>();
			for (String columnLabel : columnLabels) {
				Object columnValue = resultSet.getObject(columnLabel);
				map.put(columnLabel, columnValue);
			}
			values.add(map);
		}
		return values;
	}

	/*
	 * 
	 */
	private List<String> getColumnLabels(ResultSet rs) throws Exception {
		List<String> labels = new ArrayList<String>();
		ResultSetMetaData rsmd = rs.getMetaData();
		for (int i = 0; i < rsmd.getColumnCount(); i++) {
			labels.add(rsmd.getColumnLabel(i + 1));
		}
		return labels;
	}

	// 返回某条记录的某一个字段的值或一个统计的值(一共有多少条记录等)
	public <E> E getForValue(String sql, Object... args) {

		return null;
	}

}
