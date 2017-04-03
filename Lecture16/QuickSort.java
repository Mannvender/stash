package Lecture16;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr={5,1,9,12,15};
		QuickSort(arr, arr.length-1, 0);
		class6.arr1D.display(arr);
		
		
	}
	public static void QuickSort(int[] arr,int hi,int lo){
		if(hi<=lo){
			return;
		}
		int mid=(hi+lo)/2;
		int left=lo;
		int right=hi;
		int pivot=arr[mid];
		while(left<=right){
			while(arr[left]<pivot){
				left++;
			}
			while(arr[right]>pivot){
				right--;
			}
			if(left<=right){
				int temp=arr[left];
				arr[left]=arr[right];
				arr[right]=temp;
				left++;
				right--;
			}
		}
		QuickSort(arr, right, lo);
		QuickSort(arr, hi, left);
	}

}
