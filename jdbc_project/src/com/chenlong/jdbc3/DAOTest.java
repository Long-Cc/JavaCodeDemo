package com.chenlong.jdbc3;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.Test;

public class DAOTest {
	DAO dao = new DAO();

	@Test
	public void testUpdate() {
		String sql = "insert into customers (name,email,birth) values (?,?,?)";
		dao.update(sql, "xiaoming", "456@163.com", new Date(
				new java.util.Date().getTime()));
	}

	@Test
	public void testGet() {
		String sql = "select FlowID flowId,Type type,ExamCard examCard,StudentName studentName,Grade grade "
				+ "from student where FlowId=?";
		Student student = dao.get(Student.class, sql, 4);
		System.out.println(student);
	}

	@Test
	public void testGetForList() {
		String sql = "select FlowID flowId,Type type,ExamCard examCard,StudentName studentName,Grade grade "
				+ "from student";
		List<Student> students=dao.getForList(Student.class, sql);
		System.out.println(students);
	}

	@Test
	public void testGetForValue() {
		fail("Not yet implemented");
	}

}
