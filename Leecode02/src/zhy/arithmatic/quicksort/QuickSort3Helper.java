package zhy.arithmatic.quicksort;

public class QuickSort3Helper {

	public void quickSort(int[] arr, int n) {
		__quickSort(arr, 0, n - 1);
	}
	
	private void __quickSort(int[] arr, int l, int r) {
		if(l >= r) {
			return;
		}
		int seed = (int) (Math.random() % (r - l + 1 + l));
		int t = arr[seed];
		arr[seed] = arr[l];
		arr[l] = t;
		int v = arr[l];
		int lt = l; //arr[l+1...lt] < v;
		int gt = r + 1;//arr[gt...r] > v;
		int i = l + 1;//arr[lt+1...i] == b;
		while(i < gt) {
			if(arr[i] > v) {
				int temp = arr[gt - 1];
				arr[gt - 1] = arr[i];
				arr[i] = temp;
				gt--;
			} else if (arr[i] < v){
				int temp = arr[lt + 1];
				arr[lt + 1] = arr[i];
				arr[i] = temp;
				lt++;
				i++;
			} else {
				i++;
			}
		}
		int temp = arr[lt];
		arr[lt] = arr[l];
		arr[l] = temp;
		__quickSort(arr, l, lt - 1);
		__quickSort(arr, gt, r);
	}
	

}
