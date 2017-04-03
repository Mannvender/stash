package Lecture11;

public class LastIndex {

	public static void main(String[] args) {
		int[] arr = { 1, 5, 2, 3, 5, 6, 7 };
		//System.out.println(lastindex(arr, 5, arr.length - 1));
		System.out.println(newMethod(arr,5,0));
	}

	public static int newMethod(int[] arr, int num, int si) {
		if(si==arr.length){
			return -1;
		}
		int retVal=newMethod(arr, num, si+1);
		if(retVal==-1){
			if(arr[si]==num){
				return si;
			}
		}
		return retVal;
	}

	public static int lastindex(int[] arr, int num, int li) {
		if (li < 0) {
			return -1;
		}
		if (arr[li] == num) {
			return li;
		}
		int retVal = lastindex(arr, num, li - 1);
		return retVal;
	}
	

}
