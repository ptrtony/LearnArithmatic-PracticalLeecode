package zhy.arithmatic.heap;

public class MinHeapHelper {
	
	public void headSort(int[] data, int n) {
		for(int i = (n - 1) / 2; i >= 0; i--) {
			shiftDown(data, n, i);
		}
		
		for(int i = n - 1; i >= 0; i--) {
			swap(data, data[0], data[i]);
			shiftDown(data, i, 0);
		}
	}
	
	private void shiftDown(int[] data, int n, int k) {
		while((k * 2 + 1) < n) {
			int j = k * 2 + 1;
			if((j + 1) < n && data[j + 1] < data[j]) {
				j++;
			}
			if(data[k] < data[j]) {
				break;
			}
			swap(data, k, j);
			k = j;
		}
	}
	
	private void swap(int[] data, int k, int j) {
		int temp = data[k];
		data[k] = data[j];
		data[j] = temp;
	}

}
