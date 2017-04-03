package Lecture20;

public class delete {

	public static void main(String[] args) {
		String s1 = "1";
		String s2 = "1";
		int ls1=s1.length();
		int ls2=s2.length();
		int[][] arr = new int[s1.length() + 1][s2.length() + 1];
		for(int i=1;i<=ls2;i++){
			arr[0][i]=s2.length();
		}
		for(int j=1;j<=ls1;j++){
			arr[j][0]=s1.length();
		}
		class7.ARR2d.display(arr);
	}

}
