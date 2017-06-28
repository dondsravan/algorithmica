package com.algorithmica.tree;

public class DisplayRootToLeafPaths {

	private static void auxDisplayPaths(TreeNode root, String prefix) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			System.out.println(prefix + root.data);
			return;
		}
		auxDisplayPaths(root.left, prefix + root.data + "->");
		auxDisplayPaths(root.right, prefix + root.data + "->");
	}

	// Time Complexity - O(n)
	// Space - O(h)
	public static void displayPaths(TreeNode root) {
		auxDisplayPaths(root, "");
	}

	public static void main(String[] args) {

		TreeNode root = BinaryTreeUtils.createBinaryTree(Integer.parseInt(args[0]));
		BinaryTreeUtils.displayLevelTree(root);
		System.out.println("\n");
		DisplayRootToLeafPaths.displayPaths(root);
	}
}
