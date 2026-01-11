package zhy.leecode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leecode347 {

	/**
	 * 347. 前 K 个高频元素
中等
相关标签
premium lock icon
相关企业
给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。

 

示例 1：

输入：nums = [1,1,1,2,2,3], k = 2

输出：[1,2]

示例 2：

输入：nums = [1], k = 1

输出：[1]

示例 3：

输入：nums = [1,2,1,2,1,2,3,1,3,2], k = 2

输出：[1,2]
	 */
	
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 1, 1, 2,2,3};
		int[] res = topKFrequent(nums, 2);
		System.out.println("res = " + Arrays.toString(res));
	}
	
	public static int[] topKFrequent(int[] nums, int k) { 
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length ; i ++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> 1);
		
		for(HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
			int num = entry.getKey();
			int freq = entry.getValue();
			if(minHeap.size() < k) {
				minHeap.offer(new int[] {num, freq});
			} else {
				if(freq > minHeap.peek()[1]) {
					minHeap.poll();
					minHeap.offer(new int[] {num, freq});
				}
			}
		}
		int[] res = new int[k];
		for(int j = 0; j < k; j++) {
			res[j] = minHeap.poll()[0];
		}
        return res;
    }

}
