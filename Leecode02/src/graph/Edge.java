package com.example.test20260109.graph;

public class Edge {
	private int a, b;
	private Weight weight;
	
	public Edge(int a, int b, Weight weight) {
		this.a = a;
		this.b = b;
		this.weight = weight;
	}
	
	public int V() {
		return a;
	}
	
	public int W() {
		return b;
	}
	
	public Weight wt() {
		return weight;
	}
	
	public int other(int w) {
		assert(w == a || w == b);
		return w == a? b : a;
	}
	
	@Override
	public String toString() {
	    // 使用 String.format 或简单的字符串拼接
	   return a + "-" + b + ":" + weight;
	}
}
