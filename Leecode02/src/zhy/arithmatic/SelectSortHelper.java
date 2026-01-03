package zhy.arithmatic;

public class SelectSortHelper {
	public int[] selectorSort(int[] a, int n) {
		for(int i = 0; i < n; i++) {
			//定义一个下标，
			int minIndex = i;
			for(int j = i + 1; j < n; j++) {
				if(a[minIndex] > a[j]) {
					minIndex = j;
				}
			}
			int temp = a[i];
			a[i] = a[minIndex];
			a[minIndex] = temp;
		}
		return a;
	}
}
