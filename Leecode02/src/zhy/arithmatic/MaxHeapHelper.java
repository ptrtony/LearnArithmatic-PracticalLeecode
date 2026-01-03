package zhy.arithmatic;

public class MaxHeapHelper {
	
	public static void main(String[] args) {
		MaxHeap<Integer> max = new MaxHeap<Integer>(100);	
	}
	public static class MaxHeap<T extends Comparable<T>> {
		private T[] data;
		private int count;
		private int capacity;
		public MaxHeap(int capacity) {
			data = (T[]) new Object[capacity];
			count = 0;
			this.capacity = capacity;
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
		
		public void insert(T item) {
			if(count + 1 > capacity) {
				return;
			}
			data[count+ 1] = item;
			count++;
			shiftUp(count);
		}
		
		private void shiftUp(int count) {
			int k = count - 1;
			while(k > 1 && data[k / 2].compareTo(data[k]) < 0) {
				T parentItem = data[k/2];
				data[k / 2] = data[k];
				data[k] =parentItem; 
				k = k / 2;
			}
		}
		
		public T removeFirst() {
			if(count < 0) {
				return null;
			}
			T res = data[1] ;
			data[1] = data[count];
			count--;
			shiftDown(1);
			return res;
		}
		
		private void shiftDown(int k) {
			while(2*k <= count) {
				int j = 2 * k;
				if(j + 1 <= count && data[j + 1].compareTo(data[j]) > 0) {
					j += 1;
				}
				if(data[k].compareTo(data[j]) > 0) {
					break;
				} 
				swap(k, j);
				k = j;
			}
		}
		
		private void swap(int i, int j) 
		{
			T temp = data[i];
			data[i] = data[j];
			data[j] = temp;
		}
	}
}
