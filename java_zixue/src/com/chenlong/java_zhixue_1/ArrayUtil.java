package com.chenlong.java_zhixue_1;

public class ArrayUtil {
	// 求数组的最大值
	public static int getMax(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}

	// 求数组的最小值
	public static int getMin(int[] arr) {
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		return min;
	}

	// 遍历数组元素
	public static void printArray(int[] arr) {
		System.out.println("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println("]");
	}

	// 求数组的平均数
	public static int getAvg(int[] arr) {
		int sum = getSum(arr);
		return sum / arr.length;
	}

	// 求数组的总和
	public static int getSum(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

	// 求数组的反转
	public static int[] reverse(int[] arr) {
		for (int x = 0, y = arr.length - 1; x < y; x++, y--) {
			swap(arr, x, y);
		}
		return arr;
	}

	// 实现数组的复制
	public static int[] copy(int[] arr) {
		int[] arr1 = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			arr1[i] = arr[i];
		}
		return arr1;
	}

	// 对数组进行排序
	public static void sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
