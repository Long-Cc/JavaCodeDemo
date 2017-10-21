package shuzu;

public class shuzu2 {

	public static void main(String[] args) {
		int[][] arr=new int[3][];
		arr[0]=new int[2];
		arr[1]=new int[4];
		arr[2]=new int[6];
		for(int i=0;i<arr[0].length;i++){
			arr[0][i]=i+1;
		}
		System.out.println(arr[0][1]);
	}

}
