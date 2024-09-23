package com.ds.java.search;

class AVLTree {
	class TreeNode {
		int key, height;
		TreeNode left, right;

		TreeNode(int key) {
			this.key = key;
			this.height = 1; // New node is initially added at height 1
		}
	}

	private TreeNode root;

	// Get the height of a node
	int height(TreeNode node) {
		return (node == null) ? 0 : node.height;
	}

	// Get the balance factor of a node
	int getBalance(TreeNode node) {
		return (node == null) ? 0 : height(node.left) - height(node.right);
	}

	// Right rotation
	TreeNode rightRotate(TreeNode y) {
		TreeNode x = y.left;
		TreeNode T2 = x.right;

		// Perform rotation
		x.right = y;
		y.left = T2;

		// Update heights
		y.height = Math.max(height(y.left), height(y.right)) + 1;
		x.height = Math.max(height(x.left), height(x.right)) + 1;

		// Return new root
		return x;
	}

	// Left rotation
	TreeNode leftRotate(TreeNode x) {
		TreeNode y = x.right;
		TreeNode T2 = y.left;

		// Perform rotation
		y.left = x;
		x.right = T2;

		// Update heights
		x.height = Math.max(height(x.left), height(x.right)) + 1;
		y.height = Math.max(height(y.left), height(y.right)) + 1;

		// Return new root
		return y;
	}

	// Recursive function to insert a key in the subtree rooted with node
	TreeNode insert(TreeNode node, int key) {
		// 1. Perform the normal BST insertion
		if (node == null) return new TreeNode(key);

		if (key < node.key)
			node.left = insert(node.left, key);
		else if (key > node.key)
			node.right = insert(node.right, key);
		else // Duplicate keys not allowed
			return node;

		// 2. Update height of this ancestor node
		node.height = Math.max(height(node.left), height(node.right)) + 1;

		// 3. Get the balance factor of this node
		int balance = getBalance(node);

		// 4. If the node becomes unbalanced, there are 4 cases:

		// Case 1 - Left Left (LL)
		if (balance > 1 && key < node.left.key)
			return rightRotate(node);

		// Case 2 - Right Right (RR)
		if (balance < -1 && key > node.right.key)
			return leftRotate(node);

		// Case 3 - Left Right (LR)
		if (balance > 1 && key > node.left.key) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		// Case 4 - Right Left (RL)
		if (balance < -1 && key < node.right.key) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		// Return the (unchanged) node pointer
		return node;
	}

	// Function to insert a new key and maintain the AVL property
	public void insert(int key) {
		root = insert(root, key);
	}

	// Recursive function to delete a key from the subtree rooted with node
	TreeNode delete(TreeNode node, int key) {
		// STEP 1: PERFORM STANDARD BST DELETE
		if (node == null) return node;

		if (key < node.key)
			node.left = delete(node.left, key);
		else if (key > node.key)
			node.right = delete(node.right, key);
		else {
			// Node with only one child or no child
			if ((node.left == null) || (node.right == null)) {
				TreeNode temp = (node.left != null) ? node.left : node.right;

				// No child case
				if (temp == null) {
					temp = node;
					node = null;
				} else // One child case
					node = temp; // Copy the contents of the non-empty child
			} else {
				// Node with two children: Get the inorder successor (smallest in the right subtree)
				TreeNode temp = minValueNode(node.right);
				node.key = temp.key; // Copy the inorder successor's data to this node
				node.right = delete(node.right, temp.key); // Delete the inorder successor
			}
		}

		// If the tree had only one node, then return
		if (node == null) return node;

		// STEP 2: UPDATE THE HEIGHT OF THE CURRENT NODE
		node.height = Math.max(height(node.left), height(node.right)) + 1;

		// STEP 3: GET THE BALANCE FACTOR OF THIS NODE
		int balance = getBalance(node);

		// If this node becomes unbalanced, then there are 4 cases

		// Case 1 - Left Left (LL)
		if (balance > 1 && getBalance(node.left) >= 0)
			return rightRotate(node);

		// Case 2 - Right Right (RR)
		if (balance < -1 && getBalance(node.right) <= 0)
			return leftRotate(node);

		// Case 3 - Left Right (LR)
		if (balance > 1 && getBalance(node.left) < 0) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		// Case 4 - Right Left (RL)
		if (balance < -1 && getBalance(node.right) > 0) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		// Return the (unchanged) node pointer
		return node;
	}

	// Function to delete a key and maintain the AVL property
	public void delete(int key) {
		root = delete(root, key);
	}

	// Function to find the node with the minimum key value
	TreeNode minValueNode(TreeNode node) {
		TreeNode current = node;
		while (current.left != null)
			current = current.left;
		return current;
	}

	// Function to search for a key in the AVL tree
	public boolean search(int key) {
		return search(root, key);
	}

	// Recursive search function
	private boolean search(TreeNode node, int key) {
		if (node == null) return false;
		if (key < node.key)
			return search(node.left, key);
		else if (key > node.key)
			return search(node.right, key);
		else
			return true; // key is found
	}

	// In-order traversal of the AVL tree
	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(TreeNode node) {
		if (node != null) {
			inOrder(node.left);
			System.out.print(node.key + " ");
			inOrder(node.right);
		}
	}

	// Function to print the tree structure
	public void printTree() {
		System.out.println();
		printTree(root, "", true);
	}

	private void printTree(TreeNode node, String prefix, boolean isLeft) {
		if (node != null) {
			System.out.print(prefix + (isLeft ? "├── " : "└── ") + node.key + "\n");
			printTree(node.left, prefix + (isLeft ? "│   " : "    "), true);
			printTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
		}
	}
}

// Example usage
 class AVLTreeExample {
	public static void main(String[] args) {
		AVLTree tree = new AVLTree();

		// Insert nodes
		int[] keys = {10, 20, 30, 40, 50, 25};
		for (int key : keys) {
			tree.insert(key);
		}

		System.out.println("Inorder traversal of the AVL tree:");
		tree.inOrder(); // Output: 10 20 25 30 40 50
		tree.printTree();

		// Search for a key
		System.out.println("\nSearching for 25: " + tree.search(25)); // Output: true
		System.out.println("Searching for 15: " + tree.search(15)); // Output: false

		// Delete a node
		tree.delete(30);
		System.out.println("Inorder traversal after deleting 30:");
		tree.inOrder(); // Output: 10 20 25 40 50
		tree.printTree();
	}
}
