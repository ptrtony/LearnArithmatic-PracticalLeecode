package zhy.arithmatic.binarysearch;

public class BinarySearchHelper {
	public int binarySearch(int data[], int n, int target) {
		//在data[l, r] 之中查找target
		int l = 0, r = n - 1;
		while(l <= r) {
			int mid = l + (r - l) / 2;
			if(data[mid] == target) {
				return mid; 
			}
			if(data[mid] > target) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;
	}
}
