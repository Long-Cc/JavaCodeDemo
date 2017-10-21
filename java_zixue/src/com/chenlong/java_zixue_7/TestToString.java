package com.chenlong.java_zixue_7;

public class TestToString {

	public static void main(String[] args) {
		/*Object类中toString()方法
		 *  public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
        }
		 */
		Person p1=new Person("aa",12);
		System.out.println(p1.toString());
		String str1="BB";
		String str2=new String("CC");
		System.out.println(str1.toString());
		System.out.println(str2.toString());
	}

}
