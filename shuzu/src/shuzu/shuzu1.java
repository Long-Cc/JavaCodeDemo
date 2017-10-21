package shuzu;

import java.util.Scanner;

public class shuzu1 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("请输入分数：");
		int[] arr=new int[6];
		int sum=0;
		double arg=0;
		for(int i=0;i<=5;i++){
			arr[i]=in.nextInt();
			sum+=arr[i];
		}
		arg=sum/6;
		System.out.println("平均分是"+arg);

	}

}
