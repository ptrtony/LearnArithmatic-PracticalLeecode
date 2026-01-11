package zhy.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Leecode692 {

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
	 */
	
	public static void main(String[] args) {
		String[] words = new String[] {"i", "love", "leetcode", "i", "love", "coding"};
		List<String> res = topKFrequent(words, 2);
		System.out.println("res = " + res.toString());
		String[] words1 = new String[] {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
		List<String> res2 = topKFrequent(words1, 4);
		System.out.println("res2 = " + res2.toString());
	}
	
	public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        for(int i = 0; i < words.length; i ++) {
        	hash.put(words[i], hash.getOrDefault(words[i], 0) + 1);
        }
        PriorityQueue<Item> queue = new PriorityQueue<Item>((a, b) -> {
        	if(a.freq != b.freq) {
        		return a.freq - b.freq;
        	} else {
        		return b.word.compareTo(a.word);
        	}
        });
        for(HashMap.Entry<String, Integer> entry : hash.entrySet()) {
        	String word = entry.getKey();
        	int freq = entry.getValue();
        	queue.offer(new Item(word, freq));
        	if(queue.size() > k) {
        		queue.poll();
        	}
        }
        List<String> res = new ArrayList<String>();
        for(int j = 0; j < k; j++) {
        	res.add(queue.poll().word);
        }
        return res.reversed();
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
