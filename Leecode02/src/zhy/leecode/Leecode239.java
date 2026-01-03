package zhy.leecode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Leecode239 {
	/**
	 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

		返回 滑动窗口中的最大值 。
	 */
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,3,-1,-3,5,3,6,7};
		int[] result = maxSlidingWindow(arr, 3);
		System.out.println("arr = " + Arrays.toString(result));
	}
	
	public static int[] maxSlidingWindow(int[] nums, int k) {
	        if(nums.length == 1 || nums.length < k) {
	        	return new int[] { nums[0] };
	        }
	        int[] result = new int[nums.length - k + 1];
	        Deque<Integer> deque = new ArrayDeque<Integer>();
	        int i = 0;
	        int index = 0;
	        while(i < nums.length) {
	        	int e = nums[i];
        		if(deque.isEmpty()) {
        			deque.offer(e);
        		} else {
        			while(true) {
        				if(deque.isEmpty()) {
        					deque.offer(e);
        					break;
        				}
        				int last = deque.peekLast();
        				if(last > e) {
        					deque.offer(e);
        					break;
        				} else {
        					deque.pollLast();
        				}
        			}
        		}
	        	if(i >= k - 1) {
	        		int max = deque.peekFirst();
	        		result[index] = max;
	        		index++;
	        	} 
	        	i++;
	        }
	        return result;
	  }
}
