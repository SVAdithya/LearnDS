package com.ds.java.search;

import com.ds.java.tree.model.BinaryNode;

import static com.ds.java.tree.model.BinaryNode.height;

public class AVLBalancedTree {
	public static void main(String[] args) {
		BinaryNode root = null;
		int[] a = {1, 5, 653, 45, 4657, 5, 0,4646, 55, 32, 435, 565, 4658};
		for(int i: a) {
			root = insert(root, i);
		}
		print(root);
		root = delete(root, 1);
		print(root);
		root = delete(root, 11);
		print(root);

	}

	private static BinaryNode delete(BinaryNode root, int key) {
		if(root != null) {
			if (key < root.value) {
				root.left = delete(root.left, key);
			} else if(key > root.value) {
				root.right = delete(root.right, key);
			} else {
				// comparing left and right height to delete root node and re-alight left and right nodes
				if(root.left.height > root.right.height) {   //1 > 6

				} else {

				}
			}
			return root;
		}
		return null;
	}
	private static BinaryNode insert(BinaryNode root, int data) {
		if(root != null) { // dont create Leaf node until it reaches  compared point, even though un-balanced
			if (root.value > data){ // left insertion as value is less than new data, don't touch right
				root.left = insert(root.left, data);
			} else if (root.value < data) { // right insertion as value is greater than new data, don't touch left
				root.right = insert(root.right, data);
			} // balancing at insertion
			root.height = Math.max(height(root.left), height(root.right)) + 1;
			root.balance = height(root.left) - height(root.right);
			return root;
		} else { // only point for adding value to tree where node is empty
			return new BinaryNode(data, null, null);
		}
	}

	private static void print(BinaryNode root) {
		System.out.println();
		printTree(root, "", true);
	}

	private static void printTree(BinaryNode node, String prefix, boolean isLeft) {
		if (node != null) {
			System.out.print(prefix + (isLeft ? "├── " : "└── ") + node.value +  "(" + node.height + "/" + node.balance + ")\n");
			printTree(node.left, prefix + (isLeft ? "│   " : "    "), true);
			printTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
		}
	}

	/**
	 *	Left rotate
	 *     x                      y
	 *    / \                    /  \
	 *   T1  y    ---->         x    T3
	 *      / \                / \
	 *     T2  T3             T1  T2
	 *
	 */
	private static BinaryNode leftRotate(BinaryNode root) {
		return null;
	}

	private static BinaryNode rightRotate(BinaryNode root) {
		return null;
	}
}

