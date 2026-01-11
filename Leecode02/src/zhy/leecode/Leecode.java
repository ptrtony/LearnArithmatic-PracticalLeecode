package zhy.leecode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Leecode {
	
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
	
	class CBTInserter {
		Deque<TreeNode> rootNodeDeque = new ArrayDeque<TreeNode>();
		private TreeNode root;
	    public CBTInserter(TreeNode root) {
	    	this.root = root;
	        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	        queue.offer(root);
	        while(!queue.isEmpty()) {
	        	TreeNode node = queue.poll();
	        	if(node.left == null || node.right == null) {
	        		rootNodeDeque.offer(node);
	        	}
	        	if(node.left != null) {
	        		queue.offer(node.left);
	        	}
	        	if(node.right != null) {
	        		queue.offer(node.right);
	        	}
	        }
	    }
	    
	    public int insert(int v) {
	    	TreeNode parentNode = rootNodeDeque.peekLast();
	    	TreeNode newNode = new TreeNode(v);
	    	if(parentNode.left == null) {
	    		parentNode.left = newNode;
	    	} else {
	    		parentNode.right = newNode;
	    		rootNodeDeque.pollLast();
	    	}
	    	rootNodeDeque.offerLast(newNode);
	    	return parentNode.val;
	    }

	    public TreeNode get_root() {
	        return root;
	    }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
	}
}
