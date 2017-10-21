package com.chenlong.java_zhixue_1;

public class TestArray {

	public static void main(String[] args) {
		int[] arr=new int[]{12,4,76,0,-98,-54,4,100};
		
		int max=ArrayUtil.getMax(arr);
		System.out.println("最大值为："+max);
		int avg=ArrayUtil.getAvg(arr);
		System.out.println("平均数为："+avg);
		
		ArrayUtil.printArray(arr);
		System.out.println("反转数组为：");
		ArrayUtil.reverse(arr);
		ArrayUtil.printArray(arr);
		
		System.out.println("数组排序：");
		ArrayUtil.sort(arr);
		ArrayUtil.printArray(arr);
	}
}
