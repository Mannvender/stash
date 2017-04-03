package class6;

public class deleteTHIS {

	public static void main(String[] args) {
		// Part1
		int[] arr;
		
		arr = new int[3];
		
		// Part2
		arr[0] = 100;
//		arr[1] = 12;
		arr[2] = 200;
//		arr[3] = 400; index out of bound (0 to n - 1)
		
		
		// Part3
		int j = arr[1];
		
		// Part4
		System.out.println(arr);
		
		// Part5
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
		
		// Part6
		System.out.println("**************************");
		for(int val: arr){
			val = val + 1; // readonly, forward only
			System.out.println(val);
		}
		
		// Part 7
		System.out.println("**************************");
		for(int val: arr){
			System.out.println(val);
		}
	}

}
