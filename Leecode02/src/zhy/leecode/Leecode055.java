package zhy.leecode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leecode055 {
	
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
	 
	
	class BSTIterator {
		
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
	    public BSTIterator(TreeNode root) {
	    	pushLeft(root);
	    }
	    
	    private void pushLeft(TreeNode node) {
	    	while(node != null) {
	    		stack.push(node.left);
	    		node = node.left;
	    	}
	    }
	    
	    public int next() {
	    	TreeNode node = stack.pop();
	    	if(node.right != null) {
	    		pushLeft(node.right);
	    	}
	    	return node.val;
	    }
	    
	    public boolean hasNext() {
	    	return !stack.isEmpty();
	    }
	}


}
