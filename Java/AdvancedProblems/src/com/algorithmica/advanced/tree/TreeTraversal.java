package com.algorithmica.advanced.tree;

public class TreeTraversal {

	// root-left-right
	// Time: O(n)
	// Space: O(1)
	public static void preOrder(TreeNode root) {

		while (root != null) {
			if (root.left == null) {
				System.out.println(root.data);
				root = root.right;
			} else {
				TreeNode temp = root.left;
				while (temp.right != null && temp.right != root)
					temp = temp.right;
				if (temp.right == null) {
					System.out.println(root.data);
					temp.right = root;
					root = root.left;
				} else {
					temp.right = null;
					root = root.right;
				}
			}
		}
	}

	// left-root-right
	// Time: O(n)
	// Space: O(1)
	public static void inOrder(TreeNode root) {

		while (root != null) {
			if (root.left == null) {
				System.out.println(root.data);
				root = root.right;
			} else {
				TreeNode temp = root.left;
				while (temp.right != null && temp.right != root)
					temp = temp.right;
				if (temp.right == null) {
					temp.right = root;
					root = root.left;
				} else {
					System.out.println(root.data);
					temp.right = null;
					root = root.right;
				}
			}
		}
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayLevelTree(root);
		inOrder(root);
	}
}
