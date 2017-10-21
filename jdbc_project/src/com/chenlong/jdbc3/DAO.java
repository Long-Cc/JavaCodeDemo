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
	// update select insert �Ȳ���
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
	 * 1.��ȡConnection 2.��ȡPreparedStatement 3.���ռλ�� 4.���в�ѯ���õ�ResultSet
	 * 5.��ResultSet���м�¼ ׼��һ��Map<String,Object>:��������еı��� ֵ������е�ֵ
	 * 6.�õ�ResultSetMetaData���� 7.����ResultSet����ָ�������ƶ�һ����λ
	 * 8.��ResultSetMetaData����õ�������ж�����
	 * 9.��ResultSetMetaData�õ�ÿһ�еı���,��ResultSet�õ�����ÿһ�е�ֵ 10.���Map����
	 * 11.�÷��䴴��Class��Ӧ�Ķ��� 12.����Map�����÷�����������������ֵ�� ������ΪMap�е�Key������ֵΪMap�е�value
	 * 
	 * @author longc
	 */
	// ��ѯһ����¼,���ض�Ӧ����
	public <T> T get(Class<T> clazz, String sql, Object... args) {

		T entity = null;
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs = null;

		try {
			// 1.��ȡConnection
			conn = JDBCTools.getConnection();
			// 2.��ȡPreparedStatement
			pre = conn.prepareStatement(sql);
			// 3.���ռλ��
			for (int i = 0; i < args.length; i++) {
				pre.setObject(i + 1, args[i]);
			}
			// 4.���в�ѯ���õ�ResultSet
			rs = pre.executeQuery();

			if (rs.next()) {
				// 5.��ResultSet���м�¼ ׼��һ��Map<String,Object>:��������еı��� ֵ������е�ֵ
				Map<String, Object> values = new HashMap<String, Object>();
				// 6.�õ�ResultSetMetaData����
				ResultSetMetaData rsmd = rs.getMetaData();
				// 7.����ResultSet����ָ�������ƶ�һ����λ

				// 8.��ResultSetMetaData����õ�������ж�����
				int columCount = rsmd.getColumnCount();
				for (int i = 0; i < columCount; i++) {
					// 9.��ResultSetMetaData�õ�ÿһ�еı���,��ResultSet�õ�����ÿһ�е�ֵ
					String columnLabel = rsmd.getColumnLabel(i + 1);
					Object columnValue = rs.getObject(i + 1);
					// 10.���Map����
					values.put(columnLabel, columnValue);
				}
				// 11.�÷��䴴��Class��Ӧ�Ķ���
				entity = clazz.newInstance();

				// 12.����Map�����÷�����������������ֵ�� ������ΪMap�е�Key������ֵΪMap�е�value
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

	// ��ѯ������¼,���ض�Ӧ����ļ���
	/**
	 * 5.׼��һ��List<Map<String,Object>> :�� ����еı�����ֵ������е�ֵ.����һ��Map�����Ӧһ����¼
	 * 7.����ResultSet��ʹ��whileѭ�� 11.�����õ�Map�������5׼����list�� 12.�ж�List
	 * �Ƿ�Ϊ�ռ��ϣ�����Ϊ�գ� �����List���õ�һ��һ����Map�����ٰ�һ��Map����תΪһ��Class������Ӧ��Object����
	 * 13.��Object ������뵽list�С�
	 */
	public <T> List<T> getForList(Class<T> clazz, String sql, Object... args) {
		
		List<T> list = new ArrayList<T>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			//1.�õ������
			connection = JDBCTools.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}
			resultSet = preparedStatement.executeQuery();
			//2.�����������õ�Map �� List������һ��Map����
			//����һ����¼��Map��keyΪresultSet���еı�����Map��valueΪ�е�ֵ
			List<Map<String, Object>> values = 
					handleResluSetToMapList(resultSet);
			//3����Map ��list תΪclazz��Ӧ��List
			//����Map��key��Ϊclazz ��Ӧ�����propertyName��
			//��Map��value��λclazz��Ӧ�����propertyValue��
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
				// 13.��Object ������뵽list�С�
				result.add(bean);
			}
		}
		return result;
	}

	private List<Map<String, Object>> handleResluSetToMapList(
			ResultSet resultSet) throws Exception, SQLException {
		// 5.׼��һ��List<Map<String,Object>>
		// :�� ����еı�����ֵ������е�ֵ.����һ��Map�����Ӧһ����¼
		List<Map<String, Object>> values = new ArrayList<Map<String, Object>>();

		List<String> columnLabels = getColumnLabels(resultSet);

		Map<String, Object> map = null;

		// 7.����ResultSet��ʹ��whileѭ��
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

	// ����ĳ����¼��ĳһ���ֶε�ֵ��һ��ͳ�Ƶ�ֵ(һ���ж�������¼��)
	public <E> E getForValue(String sql, Object... args) {

		return null;
	}

}
