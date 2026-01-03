package zhy.arithmatic;

public class MergeSortHelper {
	public static void main(String[] args) {
		
	}
	
	public void mergeSort(int[] arr, int n) {
		__mergeSort(arr, 0, n - 1);
	}
	
	private void __mergeSort(int[] arr, int l, int r) {
		if(l >= r) {
			return;
		}
		int mid = (l + r) / 2;
		__mergeSort(arr, l, mid);
		__mergeSort(arr, mid + 1, r);
		if(arr[mid] > arr[mid + 1]) {
			__merge(arr, l, mid, r);	
		}
	} 
	
	private void __merge(int[] arr, int l, int mid, int r) {
		int[] aux = new int[r - l + 1];
		for(int i = l; i <= r; i++) {
			aux[i - l] = arr[i];
		}
		int i = l, j = mid + 1;
		for(int k = l; k <= r; k ++) {
			if(i > mid) {
				arr[k] = aux[j - 1];
				j++;
			} else if(j > r) {
				arr[k] = aux[i - l];
				i++;
			} else if(aux[i - l] > aux[j - l]) {
				arr[k] = aux[j - l];
				j++;
			} else {
				arr[k] = aux[i - l];
				i++;
			}
		}
	}
}
