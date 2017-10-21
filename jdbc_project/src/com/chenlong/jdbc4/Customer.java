package com.chenlong.jdbc4;

import java.sql.Date;

public class Customer {
	int student_id;
	private String student_name;
	private String student_email;
	private Date student_birth;
	
	public Customer() {
		super();
	}

	public Customer(int student_id, String student_name, String student_email,
			Date student_birth) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_email = student_email;
		this.student_birth = student_birth;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getStudent_email() {
		return student_email;
	}

	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}

	public Date getStudent_birth() {
		return student_birth;
	}

	public void setStudent_birth(Date student_birth) {
		this.student_birth = student_birth;
	}

	@Override
	public String toString() {
		return "Customer [student_id=" + student_id + ", student_name="
				+ student_name + ", student_email=" + student_email
				+ ", student_birth=" + student_birth + "]";
	}
	

}
