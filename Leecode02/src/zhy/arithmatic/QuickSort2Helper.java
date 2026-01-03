package zhy.arithmatic;

public class QuickSort2Helper {
	public void quickSort(int[] arr, int n) {
		__quickSort(arr, 0, n - 1);
	}
	
	private void __quickSort(int[] arr, int l, int r) {
		if(l >= r) {
			return;
		}
		int p = __partition(arr, l, r);
		__quickSort(arr, l, p - 1);
		__quickSort(arr, p + 1, r);
	}
	
	private int __partition(int[] arr, int l, int r) {
		int seed = (int) (Math.random() % (r - l + 1 + l));
		int t = arr[seed];
		arr[seed] = arr[l];
		arr[l] = t;
		int v = arr[l];
		int i = l + 1;
		int j = r;
		while(true) {
			while(i <= r && arr[i] < v) i++;
			while(j >= l + 1 && arr[j] > v) j--;
			if(i > j) {
				break;
			}
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		int temp = arr[l];
		arr[l] = arr[j];
		arr[j] = temp;
		return j;
	}
}
