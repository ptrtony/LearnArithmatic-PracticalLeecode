package zhy.leecode;

import java.util.Arrays;
import java.util.HashMap;

public class Leecode347_1 {
	
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
		int[] nums = new int[] {1,1,1,2,2,3};
		System.out.println("res1 = " + Arrays.toString(topKFrequent(nums, 2)));
		
		int[] nums1 = new int[] {1,2,1,2,1,2,3,1,3,2};
		System.out.println("res2 = " + Arrays.toString(topKFrequent(nums1, 2)));
		
		int[] nums2 = new int[] {1};
		System.out.println("res3 = " + Arrays.toString(topKFrequent(nums2, 1)));
	}
	
	
	public static int[] topKFrequent(int[] nums, int k) { 
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		Item[] ans = new Item[map.size()];
		int count = 0;
		for(HashMap.Entry<Integer, Integer> e : map.entrySet()) {
			int num = e.getKey();
			int freq = e.getValue();
			ans[count] = new Item(num, freq);
			count++;
		}
		for(int i = (ans.length - 1) / 2; i >= 0; i--) {
			shiftDown(ans, i, ans.length);
		}
		int[] res = new int[k];
		int size = ans.length;
		for(int i = 0; i < k; i++) {
			Item item = ans[0];
			res[i] = item.num;
			ans[0] = ans[size - 1];
			size--;
			shiftDown(ans, 0, size);
		}
		return res;
	}
	
	private static void shiftDown(Item[] ans, int i, int n) {
		while((i * 2 + 1) < n) {
			int j = i * 2 + 1;
			if(j + 1 < n && ans[j].freq < ans[j].freq) {
				j ++;
			}
			if (ans[j].freq > ans[i].freq) {
				swap(ans, j, i);
				i = j;
			} else {
				break;
			}
		} 
	}
	
	private static void swap(Item[] ans, int a, int b) {
		Item temp = ans[a];
		ans[a] = ans[b];
		ans[b] = temp;
	}
	
	public static class Item {
		int num;
		int freq;
		public Item(int num, int freq) {
			this.num = num;
			this.freq = freq;
		}
	}
}
