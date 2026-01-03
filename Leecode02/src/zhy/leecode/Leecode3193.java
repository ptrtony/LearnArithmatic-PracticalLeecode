package zhy.leecode;

public class Leecode3193 {
	
	public static void main(String[] args) {
		int[] arr1 = {8, 6, 2, 3, 1, 5, 7, 4};
		System.out.println(numberOfPermutations(arr1));
	}
	//求解这里面的逆序对个数
	 public static int numberOfPermutations(int[] arr) {
		   int[] count = {0};
	     __mergeSort(arr, 0, arr.length - 1, count);   
	     return count[0];
	 }
	 
	 private static void __mergeSort(int[] arr, int l, int r, int[] count) {
		if(l >= r) {
			return;
		}
		 int mid = l + (r - l) / 2;
		__mergeSort(arr, l, mid, count);
		__mergeSort(arr, mid + 1, r, count);
		__merge(arr, l, mid, r, count);
	 }
	 
	 private static void __merge(int[] arr, int l, int mid, int r, int[] count) {
		int[] aux = new int[r - l + 1];
		for(int i = l; i <= r; i++) {
			aux[i - l] = arr[i];
		}
		int i = l;
		int j = mid + 1;
		for(int k = l; k <= r; k++) {
			if(i > mid) {
				arr[k] = aux[j - l];
				j++;
			} else if(j > r) {
				arr[k] = aux[i - l];
				i++;
			} else if(aux[i - l] > aux[j - l]) {
				arr[k] = aux[j - l];
				j++;
				count[0] += (mid - i + 1);
			} else {
				arr[k] = aux[i - l]; 
				i++;
			}
		}
	 }
}
