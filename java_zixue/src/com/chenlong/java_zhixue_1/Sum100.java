package com.chenlong.java_zhixue_1;

public class Sum100{
	/**
	 * ����sum��ǰn���
	 */
	int sum=0;
	public int getSum100(int num){
		for(int i=0;i<=num;i++){
			sum+=i;
		}
		return sum;
	}
}
