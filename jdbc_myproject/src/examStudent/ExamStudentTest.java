package examStudent;

import java.util.List;
import java.util.Scanner;

public class ExamStudentTest {
	public static void main(String[] args) {
		ExamStudentDao examStudentDao = new ExamStudentDao();
		Scanner sc = new Scanner(System.in);
		System.out.println("输入1插入，输入2查询");
		int temp = sc.nextInt();
		try {
			if (temp == 1) {
				examStudentDao.update();
			} else if (temp == 2) {
				System.out.println("进入查询系统");
				System.out.println("请选择您要输入的类型：");
				System.out.println("3:准考证号");
				System.out.println("4:身份证号");
				int cardType = sc.nextInt();
				if (cardType == 3) {
					System.out.println("请输入证件号码：");
					String cardNum = sc.next();
					List<ExamStudent> list = examStudentDao
							.getExamCardBeanListHandler(cardNum);
					for (Object obj : list) {
						System.out.println(obj);
					}
				} else if (cardType == 4) {
					System.out.println("请输入证件号码：");
					String cardNum = sc.next();
					List<ExamStudent> list = examStudentDao
							.getIdCardBeanListHandler2(cardNum);
					if (list.isEmpty()) {
						System.out.println("查无此人");
					} else {
						for (Object obj : list) {
							System.out.println(obj);
						}
					}
				} else {
					System.out.println("系统异常退出");
				}
			} else {
				System.out.println("系统退出");
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			sc.close();
		}
	}
}
