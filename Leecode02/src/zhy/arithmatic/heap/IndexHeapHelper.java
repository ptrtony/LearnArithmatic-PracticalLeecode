package zhy.arithmatic.heap;

public class IndexHeapHelper {
	
	public static void main(String[] args) {
		MaxHeap<Integer> max = new MaxHeap<Integer>(100);	
	}
	public static class MaxHeap<T extends Comparable<T>> {
		private T[] data;
		private int count;
		private int capacity;
		private int[] indexs;
		private int[] reverse;
		public MaxHeap(int capacity) {
			data = (T[]) new Object[capacity + 1];
			count = 0;
			this.capacity = capacity;
			indexs = new int[capacity + 1];
			reverse = new int[capacity + 1];
			for(int i = 0; i <= capacity; i ++) {
				reverse[i] = 0;
			}
		}
		
		public MaxHeap(T[] arr, int n) {
			data = (T[])new Object[n + 1];
			capacity = n;
			for(int i = 0; i< n; i++) {
				data[i + 1] = arr[i];
			}
			count = n;
			for(int i = count / 2; i >= 1; i--) {
				shiftDown(i);
			}
		}
		
		public int size() {
			return count;
		}
		
		public boolean isEmpty() {
			return count == 0;
		}
		
		public void insert(int i, T item) {
			if(count + 1 > capacity) {
				return;
			}
			if(i + 1 > capacity && i + 1 < 1) {
				return;
			}
			data[i] = item;
			indexs[count + 1] = i;
			reverse[i] = count + 1;
			count++;
			shiftUp(count);
		}
		
		private void shiftUp(int count) {
			int k = count - 1;
			while(k > 1 && data[indexs[k / 2]].compareTo(data[indexs[k]]) < 0) {
				swapIndex(k / 2, k);
				reverse[indexs[k / 2]] = k/2;
				reverse[indexs[k]] = k;
				k = k / 2;
			}
		}
		
		public T removeFirst() {
			if(count < 0) {
				return null;
			}
			T res = data[indexs[1]] ;
			swapIndex(1, count);
			reverse[indexs[1]] = 1;
			reverse[indexs[count]] = 0;
			count--;
			shiftDown(1);
			return res;
		}
		
		public void change(int i, T newItem) {
			if (!contains(i)) {
				return;
			}
			i += 1;
			data[i] = newItem;
			int j = reverse[i];
			shiftUp(j);
			shiftDown(j);
		}
		
		boolean contains(int i) {
			if(i + 1 < 1 || i + 1 > capacity) {
				return false;
			}
			return reverse[i + 1] != 0;
		}
		
		private void shiftDown(int k) {
			while(2*k <= count) {
				int j = 2 * k;
				if(j + 1 <= count && data[indexs[j + 1]].compareTo(data[indexs[j]]) > 0) {
					j += 1;
				}
				if(data[indexs[k]].compareTo(data[indexs[j]]) > 0) {
					break;
				} 
				swapIndex(k, j);
				reverse[indexs[k]] = k;
				reverse[indexs[j]] = j;
				k = j;
			}
		}
		
		private void swap(int i, int j) 
		{
			T temp = data[i];
			data[i] = data[j];
			data[j] = temp;
		}
		
		private void swapIndex(int i, int j) {
			int temp = indexs[i];
			indexs[i] = indexs[j];
			indexs[j] = temp;
		}
	}
}
