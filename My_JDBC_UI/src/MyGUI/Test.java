package MyGUI;

public class Test {

	public static void main(String[] args) {
		int[] a = { 2, 3, 6, 4, 5, 9, 2, 3, 2, 3 };
		int[] b=new int[a.length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if(a[i]<a[j]){
					int temp=a[j];
					a[j]=a[i];
					a[i]=temp;
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
		System.out.println(a[i]);
	
		}
	}

}
