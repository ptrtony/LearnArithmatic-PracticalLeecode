package zhy.arithmatic;

public class QuickSortTestHelper {

	
	
	public void quickSortWay3(int[] arr, int n) {
		__quickSortWay3(arr, 0, n - 1);
	}
	
	private void __quickSortWay3(int[] arr, int l, int r) {
		int seed = (int) (Math.random() % (r - l + 1 + l));
		int t = arr[l];
		arr[l] = arr[seed];
		arr[seed] = t;
		int v = arr[l];
		int lt = l;
		int gt = r + 1;
		int i = l + 1;
		while(i < gt) {
			if(arr[i] > v) {
				int temp = arr[gt - 1];
				arr[gt - 1] = arr[i];
				arr[i] = temp;
				gt--;
			} else if(arr[i] > v) {
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
		__quickSortWay3(arr, l, lt - 1);
		__quickSortWay3(arr, gt, r);
	}
}
