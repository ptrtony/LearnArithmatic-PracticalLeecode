package zhy.arithmatic.insertsort;

public class InsertionSortHelper {
	public int[] insertionSort(int[] a, int n) {
		for(int i = 1; i < n; i ++) {
			for(int j = i; j > 0 && a[j] < a[j - 1]; j --) {
				int temp = a[j];
				a[j] = a[j - 1];
				a[j] = temp;
 			}
		}
		return a;
	}
	
	public int[] insertionSort1(int[] arr, int n) {
		for(int i = 1; i < n; i++) {
			int e = arr[i];
			int j;
			for(j = i; j > 0 && arr[j - 1] > e; j--) {
				arr[j] = arr[j - 1]; 
			}
			arr[j] = e;
		}
		return arr;
	}
}
