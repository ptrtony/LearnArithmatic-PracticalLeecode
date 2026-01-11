package zhy.arithmatic.mergesort;

public class MergesortBUHelper {
	public void mergeSortBU(int[] arr, int n) {
		for(int sz = 1; sz <= n; sz+= sz) {
			for(int i = 0; i + sz < n; i += sz + sz) {
				__merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
			}
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
