package zhy.arithmatic.heap;

public class MaxHeapInSpaceHelper {
	
	private static class MaxHeap<T extends Comparable<T>> {
		public void heapSort(T arr[], int n) {
			for(int i = (n - 1) / 2; i >= 0; i --) {
				shiftDown(arr, n, i);
			}
			for(int i = n - 1; i >= 0; i--) {
				swap(arr, 0, i);
				shiftDown(arr, i, 0);
			}
		}
		
		private void shiftDown(T arr[], int n, int k) {
			while((2 *k + 1) < n) {
				int j = 2 * k + 1;
				if ((2 * k + 2) < n && arr[j + 1].compareTo(arr[j]) > 0) {
					j++;
				}
				if(arr[k].compareTo(arr[j]) > 0) {
					break;
				}
				swap(arr, k, j);
				k = j;
			}
		}
		
		private void swap(T arr[], int i, int j) {
			T temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	
	}

}
