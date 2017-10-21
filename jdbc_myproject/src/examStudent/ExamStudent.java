package examStudent;

public class ExamStudent {
	private int flowId; // 流水号
	private int type; // 四级/六级
	private String idCard; // 身份证号码
	private String examCard; // 准考证号码
	private String studentName; // 学生姓名
	private String location; // 区域
	private int grade; // 成绩

	public int getType() {
		return type;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getExamCard() {
		return examCard;
	}

	public void setExamCard(String examCard) {
		this.examCard = examCard;
	}

	public void setFlowId(int flowId) {
		this.flowId = flowId;
	}

	public int getFlowId() {
		return flowId;
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

	public String getLocation() {
		return location;
	}

	public String toString() {
		return "ExamStudent [flowId=" + flowId + ", type=" + type + ", idCard="
				+ idCard + ", examCard=" + examCard + ", studentName="
				+ studentName + ", location=" + location + ", grade=" + grade
				+ "]";
	}

}
