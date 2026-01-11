package zhy.arithmatic.binarysearch;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BinarySearchTreeHelper {
	static class Node<K extends Comparable<K>, V extends Comparable<V>> {
		public K key;
		public V value;
		public Node left;
		public Node right;
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			left = null;
			right = null;
		}
	}
	
	Node root;
	int count;
	
	int size() {
		return count;
	}
	
	boolean isEmpty() {
		return count == 0;
	}
	
	public <K extends Comparable<K>, V extends Comparable<V>> void insert(K key, V value) {
		 root = insert(root, key, value);
	}
	
	private <K extends Comparable<K>, V extends Comparable<V>> Node insert(Node node, K key, V value) {
		if (node == null) {
			count++;
			return new Node(key, value);
		}
		if (key == node.key) {
			node.value = value;
		} else if(node.key.compareTo(key) > 0) {
			node.left = insert(node.left, key, value);
		} else {
			node.right = insert(node.right, key, value);
		}
		return node;
	}
	
	public <Key extends Comparable<Key>>boolean contains(Key key) {
		return contains(root, key);
	}
	
	private <Key extends Comparable<Key>>boolean contains(Node node, Key key) {
		if (node == null) {
			return false;
		}
		if(node.key == key) {
			return true;
		}
		if(node.key.compareTo(key) > 0) {
			return contains(node.left, key);
		} else {
			return contains(node.right, key);
		}
	}
	
	<V extends Comparable<V>, K extends Comparable<K>> V search(K key) {
		return search(root, key);
	}
	
	<V extends Comparable<V>, K extends Comparable<K>> V search(Node node, K key) {
		if (node == null) {
			return null;
		}
		if(node.key == key) {
			return (V) node.value;
		}
	
		if(node.key.compareTo(key) > 0)  {
			return search(node.left, key);
		} else {
			return search(node.right, key);
		}
	}
	
	//前序遍历
	public void preOrder() {
		preOrder(root);
	}
	
	//中序遍历
	public void inOrder() {
		inOrder(root);
	}
	
	//后序遍历
	public void postOrder() {
		postOrder(root);
	}
	
	//层序遍历
	void levelOrder() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			System.out.print("----key = " + node.key + " --- value = " + node.value);
			if(node.left != null) {
				queue.offer(node.left);
			}
			if(node.right != null) {
				queue.offer(node.right);
			}
		}
	}
	
	private void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.println("key: " + node.key + " value: " + node.value);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	private void inOrder(Node node) {
		if (node == null) {
			return;
		}
		preOrder(node.left);
		System.out.println("key: " + node.key + " value: " + node.value);
		preOrder(node.right);
	}
	
	private void postOrder(Node node) {
		if (node == null) {
			return;
		}
		preOrder(node.left);
		preOrder(node.right);
		System.out.println("key: " + node.key + " value: " + node.value);
	}
	
	
	public <K extends Comparable<K>> K minimum() {
		return minimum(root);
	}
	
	private <K extends Comparable<K>> K minimum(Node node) {
		if(node.left == null) {
			return (K) node.key;
		}
		return minimum(node.left);
	}
	
	public <K extends Comparable<K>> K maximum() {
		return maximum(root);
	}
	
	private <K extends Comparable<K>> K maximum(Node node) {
		if(node.right == null) {
			return (K) node.key;
		}
		return maximum(node.right);
	}
	
	public void removeMin() {
		if(root == null) {
			return;
		}
		root = removeMin(root);
	}
	
	public void removeMax() {
		if (root == null) {
			return;
		}
		root = removeMax(root);
	}
	
	private Node removeMin(Node node) {
		if(node.left == null) {
			Node rightNode = node.right;
			node.right = null;
			count--;
			node.left = rightNode;
			return rightNode;
		}
		node.left = removeMin(node.left);
		return node;
	}
	
	private Node removeMax(Node node) {
		if(node.right == null) {
			Node leftNode = node.left;
			count--;
			node.left = null;
			return leftNode;
		}
		node.right = removeMax(node.right);
		return node;
	}
	
	public<Key extends Comparable<Key>> void remove(Key key) {
		root = remove(root, key);
	}
	
	private <Key extends Comparable<Key>> Node remove(Node node, Key key) {
		if(node == null) {
			return null;
		}
		if(node.key.compareTo(key) > 0) {
			return remove(node.left, key);
		} else if(node.key.compareTo(key) < 0) {
			return remove(node.right, key);
		} else {
			if(node.left == null) {
				return removeMin(node);
			} else if(node.right == null) {
				return removeMax(node);
			} else {
				Node minNode = minimum(node.right);
				Node targetNode = copy(minNode, new Node(0));
			}
		}
	}
	
	private void copy(Node src, Node dest) {
		dest.key = src.key;
		dest.left = src.left;
		dest.value = src.value;
	}
}
