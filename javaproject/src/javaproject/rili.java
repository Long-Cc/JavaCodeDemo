package javaproject;

import java.util.Scanner;

public class rili {

	public static void main(String[] args) {
		for (int g = 0; g < 100; g++) {
			Scanner in = new Scanner(System.in);
			System.out.println("\n请输入年份：");
			int year = in.nextInt();
			System.out.println("请输入月份：");
			int month = in.nextInt();
			int sum = 0;
			int k = 0;
			for (int i = 1; i <= month - 1; i++) {
				if (i == 2) {
					if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
						sum = sum + 29;
					} else {
						sum = sum + 28;
					}
				} else {
					if (i == 4 || i == 6 || i == 9 || i == 11) {
						sum = sum + 30;
					} else {
						sum = sum + 31;
					}
				}
			}
			for (int a = 1900; a <= year - 1; a++) {
				if (a % 4 == 0 && a % 100 != 0 || a % 400 == 0) {
					sum = sum + 366;
				} else {
					sum += 365;
				}
			}
			sum += 1;
			int wekday = sum % 7;
			System.out.println("日\t一\t二\t三\t四\t五\t六");
			for (int j = 1; j <= wekday; j++) {
				System.out.print("\t");
			}
			if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
				if (month == 2) {
					k = 29;
				} else if (month == 4 || month == 6 || month == 9 || month == 11) {
					k = 30;
				} else {
					k = 31;
				}
			} else {
				if (month == 2) {
					k = 28;
				} else if (month == 4 || month == 6 || month == 9 || month == 11) {
					k = 30;
				} else {
					k = 31;
				}
			}
			for (int i = 1; i <= k; i++) {
				if (sum % 7 == 6) {
					System.out.print(i + "\n");
				} else {
					System.out.print(i + "\t");
				}
				sum++;
			}
		}
	}
}