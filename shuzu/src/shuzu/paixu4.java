package shuzu;

public class paixu4 {

	public static void main(String[] args) {
		int[] arr={1,22,33,65,54,32,21,888,65,2,0};
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]>arr[j]){
					int t=arr[i];
					arr[i]=arr[j];
					arr[j]=t;
				}
			}
		}
		for(int i=0;i<arr.length;i++)
			System.out.print(" "+arr[i]);
	}

}
