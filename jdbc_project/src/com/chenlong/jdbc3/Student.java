package com.chenlong.jdbc3;

public class Student {
	private int flowId;
	private int type;
	private String examCard;
	private String studentName;
	private int grade;
	
	
	public Student() {
		super();
	}
	public Student(int flowId, int type, String examCard, String studentName,
			int grade) {
		super();
		this.flowId = flowId;
		this.type = type;
		this.examCard = examCard;
		this.studentName = studentName;
		this.grade = grade;
	}

	public int getFlowId() {
		return flowId;
	}
	public void setFlowId(int flowId) {
		this.flowId = flowId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getExamCard() {
		return examCard;
	}
	public void setExamCard(String examCard) {
		this.examCard = examCard;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Student [flowId=" + flowId + ", type=" + type + ", examCard="
				+ examCard + ", studentName=" + studentName + ", grade="
				+ grade + "]"+"\n";
	}
	
}
