package examStudent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import jdbctools.JDBCTools;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

public class ExamStudentDao {
	QueryRunner queryRunner = new QueryRunner();

	public void update() {
		// 从控制台输入 Type,idCard,examCard,studentName,location,grade
		ExamStudent examStudent = new ExamStudent();
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入考生的详细信息");
		System.out.print("type:");
		int type = sc.nextInt();
		System.out.print("IDCard: ");
		String idCard = sc.next();
		System.out.print("ExamCard: ");
		String examCard = sc.next();
		System.out.print("StudentName: ");
		String studentName = sc.next();
		System.out.print("Location: ");
		String location = sc.next();
		System.out.print("Grade: ");
		int grade = sc.nextInt();
		sc.close();
		// 将从控制台输入的值分别写入ExamStudent中
		examStudent.setType(type);
		examStudent.setIdCard(idCard);
		examStudent.setExamCard(examCard);
		examStudent.setStudentName(studentName);
		examStudent.setLocation(location);
		examStudent.setGrade(grade);
		Connection connection = null;
		try {
			connection = JDBCTools.getConnection();
			String sql = "INSERT INTO student (TYPE,ID_CARD,EXAM_CARD,STUDENT_NAME,LOCATION,GRADE) VALUES (?,?,?,?,?,?)";
			queryRunner.update(connection, sql, type, idCard, examCard,
					studentName, location, grade);
			System.out.println("插入成功");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		JDBCTools.release(connection, null);
	}

	// 根据编号查询,返回一个Map
	public Map<String, Object> getMapHandler() {
		Connection connection = null;
		String sql = "select flow_id,type,id_card idCard,exam_card excaCard,"
				+ "student_name studentname,location,grade "
				+ "from student where flow_id=?";
		try {
			connection = JDBCTools.getConnection();
			Map<String, Object> map = queryRunner.query(connection, sql,
					new MapHandler(), 4);
			return map;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.release(connection, null);
		}
		return null;
	}

	// 根据身份证号码进行查询
	// 传统方法实现查询
	public List<Map<String, Object>> getIdCardBeanListHandler(String idCard) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			connection = JDBCTools.getConnection();
			String sql = "select flow_id flowId,type,id_card idCard,exam_card excaCard,"
					+ "student_name studentname,location,grade "
					+ "from student where id_card=" + idCard;
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int columnCount = resultSetMetaData.getColumnCount();
			while (resultSet.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 0; i < columnCount; i++) {
					String key = resultSetMetaData.getColumnLabel(i + 1);
					Object value = resultSet.getObject(i + 1);
					map.put(key, value);
				}
				list.add(map);
			}
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.release(connection, statement, resultSet);
		}
		return null;
	}

	// 使用dbutils 工具实现根据身份证号码进行查询
	/**
	 * 根据身份证号码进行查询 BeanListHandler: 把结果集转为一个 List, 该 List 不为 null, 但可能为
	 * 空集合(size() 方法返回 0)
	 * 
	 * @return
	 */
	public List<ExamStudent> getIdCardBeanListHandler2(String idCard) {
		Connection connection = null;
		try {
			connection = JDBCTools.getConnection();
			String sql = "select flow_id flowId,type,id_card idCard,exam_card examCard,"
					+ "student_name studentname,location,grade "
					+ "from student where id_card=?";
			List<ExamStudent> examStudent = queryRunner
					.query(connection, sql, new BeanListHandler<ExamStudent>(
							ExamStudent.class), idCard);
			return examStudent;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.release(connection, null, null);
		}
		return null;
	}

	// 根据准考证号码进行查询
	public List<ExamStudent> getExamCardBeanListHandler(String examCard) {
		Connection connection = null;
		try {
			connection = JDBCTools.getConnection();
			String sql = "select flow_id flowId,type,id_card idCard,exam_card examCard,"
					+ "student_name studentname,location,grade "
					+ "from student where exam_card=?";
			List<ExamStudent> examStudent = queryRunner.query(connection, sql,
					new BeanListHandler<ExamStudent>(ExamStudent.class),
					examCard);
			return examStudent;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.release(connection, null, null);
		}
		return null;
	}

	// 返回数据表中所有信息
	public void showAll() {
		Connection connection = null;
		try {
			connection = JDBCTools.getConnection();
			String sql = "select * from student";
			List<Map<String, Object>> list = queryRunner.query(connection, sql,
					new MapListHandler());
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.release(connection, null, null);
		}
	}
}
