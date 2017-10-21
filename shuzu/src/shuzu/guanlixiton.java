package shuzu;

import java.util.*;

public class guanlixiton {

	public static void main(String[] avgs) {
		Scanner in = new Scanner(System.in);
		System.out.println("请输入学生的人数：");
		int person = in.nextInt(); // 存储学生的人数
		System.out.println("请输入课程数目：");
		int courseNum = in.nextInt(); // 存储课程的数目
		String[] name = new String[person]; // 声明一个String数组name存储学生的姓名
		String[] course = new String[courseNum]; // 声明一个String数组course存储课程的名称
		int[][] number = new int[person][courseNum];
		int[] sum = new int[person];// 声明sum数组来存储总分
		int[] avg = new int[person];// 声明avg数组来存储平均分
		String[] str = new String[person];
		/*
		 * 用来循环存储课程的名称
		 */
		for (int i = 0; i < course.length; i++) {
			System.out.println("请定义第" + (i + 1) + "课程的名字：");
			course[i] = in.next();
		}
		/*
		 * 用来录入学生各科的成绩
		 */
		for (int i = 0; i < person; i++) {
			int s = 0;
			System.out.println("请输入第" + (i + 1) + "个同学的名字：");
			name[i] = in.next();
			String str11 = "";
			for (int j = 0; j < courseNum; j++) {
				System.out.println("请输入" + name[i] + "的" + course[j] + "成绩");
				number[i][j] = in.nextInt();
				s += number[i][j];
				str11 += number[i][j] + "\t";
			}
			sum[i] = s;// 求出这同学的总分存入总分sum数组
			avg[i] = s / courseNum;// 求出这同学的平均分存入平均分avg数组
			str[i] = name[i] + "\t" + str11 + sum[i] + "\t" + avg[i]; // 整合每行成一个字符串存入字符串数组str
		}
		for (int i = 0; i < sum.length - 1; i++) {
			for (int j = 0; j < sum.length - 1; j++) {
				if (sum[j] < sum[j + 1]) {
					int t1 = sum[j];
					String t2 = str[j];
					sum[j] = sum[j + 1];
					str[j] = str[j + 1];
					sum[j + 1] = t1;
					str[j + 1] = t2;
				}
			}
		}
		/*
		 * 效果输出
		 */
		System.out.print("学生");
		for (int i = 0; i < course.length; i++) {
			System.out.print("\t" + course[i]);
		}
		System.out.println("\t总分\t平均分\t排行榜");
		for (int i = 0; i < person; i++) {
			System.out.println(str[i] + "\t第" + (i + 1) + "名");
		}
	}

}
