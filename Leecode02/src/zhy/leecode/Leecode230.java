package zhy.leecode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Leecode230 {
 /**
  * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（k 从 1 开始计数）。
示例 1：

输入：root = [3,1,4,null,2], k = 1
输出：1

示例 2：

输入：root = [5,3,6,2,4,null,null,1], k = 3
输出：3
  */
	
	
	
	 public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode() {}
		 TreeNode(int val) { this.val = val; }
		 TreeNode(int val, TreeNode left, TreeNode right) {
		     this.val = val;
		     this.left = left;
		     this.right = right;
		 }
	 }
	 
	 int temp = 0;
	 public int kthSmallest(TreeNode root, int k) {
		     int[] r = new int[k];
	         for(int i = 0; i < k; i++) {
	            r[i] = 0;
	         }
		     __kthSmallest(root, r, k);
		     return r[k - 1];
		 } 
		 
		 private void __kthSmallest(TreeNode root, int[] r, int k) {
			 if(root == null) {
				 return;
			 }
	          __kthSmallest(root.left, r, k);
	          if(temp < k) {
	              r[temp] = root.val;
	              temp++; 
	          }
			 __kthSmallest(root.right, r, k);
		 }
}
