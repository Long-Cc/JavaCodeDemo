package com.chenlong.java_zhixue_1;

public class TestArray {

	public static void main(String[] args) {
		int[] arr=new int[]{12,4,76,0,-98,-54,4,100};
		
		int max=ArrayUtil.getMax(arr);
		System.out.println("���ֵΪ��"+max);
		int avg=ArrayUtil.getAvg(arr);
		System.out.println("ƽ����Ϊ��"+avg);
		
		ArrayUtil.printArray(arr);
		System.out.println("��ת����Ϊ��");
		ArrayUtil.reverse(arr);
		ArrayUtil.printArray(arr);
		
		System.out.println("��������");
		ArrayUtil.sort(arr);
		ArrayUtil.printArray(arr);
	}
}
