package com.chenlong.java_zixue_2;

public class MethodDemo {
	/*
	 * 计算整型数组元素之和
	 */
	int getTotal(int[] nums) {
		if (nums == null) {
			return 0;
		}
		int total = 0;
		for (int num : nums) {
			total += num;
		}
		return total;
	}

	/**
	 * 取出数组中下标奇数的数
	 */
	int[] getPartDate(int[] nums) {
		if (nums == null) {
			return null;
		}
		int[] result = new int[nums.length % 2 == 0 ? nums.length / 2 : nums.length / 2 + 1];
		for (int i = 0; i < result.length; i++) {
			result[i] = nums[i * 2];
		}
		return result;
	}

	/**
	 * 
	 * @param s
	 * @param ss
	 * @return 如果存在返回true，不存在返回false
	 */
	boolean isExist(String s, String[] ss) {
		if (ss == null) {
			return false;
		}
		for (String string : ss) {
			if (s == null) {
				if (string == null) {
					return true;
				}
			} else {
				if (s.equals(string)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 5, 9 };
		MethodDemo demo = new MethodDemo();
		int total = demo.getTotal(nums);
		System.out.println(total);

		int[] partDate = demo.getPartDate(nums);
		for (int date : partDate) {
			System.out.print(date + "\t");
		}
		String[] ss = { "cs", "abc", "a", "def", "acd" };
		boolean b = demo.isExist(null, ss);
		System.out.println(b);
	}
}