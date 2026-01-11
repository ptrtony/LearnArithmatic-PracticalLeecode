package zhy.arithmatic.quicksort;

public class QuickSortHelper {
	
	public void quickSort(int[] arr, int n) {
		__quickSort(arr, 0, n - 1);
	}
	
	public void __quickSort(int[] arr, int l, int r) {
		if(l >= r) {
			return;
		}
		int p = __partition(arr,  l, r);
		__quickSort(arr, l, p - 1);
		__quickSort(arr, p + 1, r);
	}
	
	//返回P,使得arr[l, p - 1] < arr[p]; arr[p + 1] > arr[p]
	public int __partition(int[] arr, int l, int r) {
		int seed = (int) (Math.random() % (r - l + 1 + l));
		int t = arr[seed];
		arr[seed] = arr[l];
		arr[l] = t;
		int v = arr[l];
		int j = l;
		for(int i = l + 1; i <= r; i ++) {
			if(arr[i] < v) {
				int temp = arr[i];
				arr[i] = arr[j + 1];
				arr[++j] = temp;
			}
		}
		int temp = arr[l];
		arr[l] = arr[j];
		arr[j] = temp;
		return j;
	}
}
