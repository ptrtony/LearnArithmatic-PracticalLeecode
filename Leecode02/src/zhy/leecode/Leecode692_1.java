package zhy.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leecode692_1 {

	/**
	 * 给定一个单词列表 words 和一个整数 k ，返回前 k 个出现次数最多的单词。

返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序 排序。

 

示例 1：

输入: words = ["i", "love", "leetcode", "i", "love", "coding"], k = 2
输出: ["i", "love"]
解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
    注意，按字母顺序 "i" 在 "love" 之前。
示例 2：

输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
输出: ["the", "is", "sunny", "day"]
解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
    出现次数依次为 4, 3, 2 和 1 次。
 

注意：

1 <= words.length <= 500
1 <= words[i].length <= 10
words[i] 由小写英文字母组成。
k 的取值范围是 [1, 不同 words[i] 的数量]
	 */
	
	
	public static void main(String[] args) {
		String[] words = new String[] {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
		System.out.println("res = " + topKFrequent(words, 4));
		
		String[] words1 = new String[] {"i", "love", "leetcode", "i", "love", "coding"};
		System.out.println("res1 = " + topKFrequent(words1, 2));
	}
	
	
	
	public static List<String> topKFrequent(String[] words, int k) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i < words.length; i++) {
			map.put(words[i], map.getOrDefault(words[i], 0) + 1);
		}
		Item[] ans = new Item[map.size()];
		int count = 0;
		for(HashMap.Entry<String, Integer> e : map.entrySet()) {
			ans[count] = new Item(e.getKey(), e.getValue());
			count++;
		}
		for(int i = (ans.length - 1) / 2; i >= 0; i--) {
			shiftDown(ans, i, ans.length);
		}
		
		int size = ans.length;
		List<String> res = new ArrayList<String>();
		for(int i = 0; i < k; i++) {
			Item item = ans[0];
			res.add(item.word);
			ans[0] = ans[size - 1];
			size--;
			shiftDown(ans, 0, size);
		}
		return res;
	}
	
	private static void shiftDown(Item[] ans, int i, int n) {
		while((i * 2 + 1) < n) {
			int j = i * 2 + 1;
			if(j + 1 < n && compare(ans[j], ans[j + 1]) < 0) {
				j++;
			}
			if(compare(ans[i], ans[j]) < 0) {
				swap(ans, i, j);
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
	
	private static int compare(Item a, Item b) {
		if (a.freq != b.freq) {
			return a.freq - b.freq;
		}
		return b.word.compareTo(a.word);
	}
	
	private static class Item {
		String word;
		int freq;
		public Item(String word, int freq) {
			this.word = word;
			this.freq = freq;
		}
	}
}
