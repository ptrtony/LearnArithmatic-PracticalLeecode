package zhy.leecode;

import java.util.Arrays;

public class Leecode076 {

	/**
	 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。

	  请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

      示例 1：

      输入：nums = [3,2,1,5,6,4], k = 2
      输出：5
      示例 2：

      输入：nums = [3,2,3,1,2,4,5,5,6], k = 4
       输出：4
	 */
	public static void main(String[] args) {
		int[] nums = new int[] {3,2,1,5,6,4};
		System.out.print(" result 1 = " + findKthLargest(nums, 2) + "nums = " + Arrays.toString(nums));
		int[] nums2 = new int[] {3,2,3,1,2,4,5,5,6};
		System.out.print(" result 2 = " + findKthLargest(nums2, 4) + "nums = " + Arrays.toString(nums2));
	}
	
	 public static int findKthLargest(int[] nums, int k) {
		 return __quickSort(nums, 0, nums.length - 1, k);
	 }
	 
	 private static int __quickSort(int[] nums, int l, int r, int k) {
		 if(l >= r) {
			 return nums[nums.length - k];
		 }
		 
		 int seed = (int) (l + Math.random() * ( r - l + 1));
		 int t = nums[seed];
		 nums[seed] = nums[l];
		 nums[l] = t;
		 
		 int v = nums[l];
		 int lt = l;
		 int gt = r + 1;
		 int i = l + 1;
		 while(i < gt) {
			 if(nums[i] < v) {
				 int temp = nums[i];
				 nums[i] = nums[lt + 1];
				 nums[lt + 1] = temp;
				 lt++;
				 i++;
			 } else if(nums[i] > v) {
				 int temp = nums[i];
				 nums[i] = nums[gt - 1];
				 nums[gt - 1] = temp;
				 gt--;
			 } else {
				 i++;
			 }
		 }
		 int temp = nums[l];
		 nums[l] = nums[lt];
		 nums[lt] = temp;
		 int targetIndex = nums.length - k;
		 if(targetIndex < lt) {
			 __quickSort(nums, l, lt - 1, k);
		 } else {
			 __quickSort(nums, gt, r, k);
		 }
		 return nums[nums.length - k];
	 }
	 
	 
	 private static int __quickSort1(int[] nums, int l, int r, int k) {
		 if(l >= r) {
			 return nums[nums.length - k];
		 }
		 int seed = l + (int) (Math.random() * (r - l + 1));
		 int t = nums[seed];
		 nums[seed] = nums[l];
		 nums[l] = t;
		 int v = nums[l];
		 int lt = l;
		 int gt = r + 1;
		 int i = l + 1;
		 while(i < gt) {
			 if(nums[i] < v) {
				 int temp = nums[i];
				 nums[i] = nums[lt + 1];
				 nums[lt + 1] = temp;
				 i++;
				 lt++;
			 } else if (nums[i] > v) {
				 int temp = nums[i];
				 nums[i] = nums[gt - 1];
				 nums[gt - 1] = temp;
				 gt--;
			 } else {
				 i++;
			 }
		 }
		 int temp = nums[l];
		 nums[l] = nums[lt];
		 nums[lt] = temp;
		 int targeIndex = nums.length - k;
		 if (targeIndex < lt) {
			 __quickSort(nums, l, lt - 1, k);
		 } else {
			 __quickSort(nums, gt, r, k);
		 }
		 return nums[nums.length - k];
	 }
}
