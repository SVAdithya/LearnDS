package com.ds.java.tree.model;

public class BinaryNode {
	public int value, height = 1, balance =0;
	public BinaryNode left;
	public BinaryNode right;

	public BinaryNode(int value, BinaryNode left, BinaryNode right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public static int height(BinaryNode node) {
		if (node == null) return 0;
		return node.height;
	}
}
