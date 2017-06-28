package com.algorithmica.tree;

public class MaxRootToLeafSum {

	private static void auxMaxSum(TreeNode root, int sum, MyInteger maxSum) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			maxSum.set(Math.max(maxSum.get(), sum + root.data));
			return;
		}
		auxMaxSum(root.left, sum + root.data, maxSum);
		auxMaxSum(root.right, sum + root.data, maxSum);
	}

	// Recursion with prefix, working from top to bottom
	// Used our own DS
	// Time Complexity - O(n)
	public static int maxPathSum1(TreeNode root) {
		MyInteger maxSum = new MyInteger();
		auxMaxSum(root, 0, maxSum);
		return maxSum.get();
	}

	public static int maxPathSum2(TreeNode root) {
		int lsum, rsum;
		if (root == null)
			return 0;
		lsum = maxPathSum2(root.left);
		rsum = maxPathSum2(root.right);
		return Math.max(lsum, rsum) + root.data;
	}

	public static void main(String[] args) {

		TreeNode root = BinaryTreeUtils.createBinaryTree(Integer.parseInt(args[0]));
		BinaryTreeUtils.displayLevelTree(root);
		System.out.println("\n");
		System.out.println(maxPathSum1(root));
		System.out.println(maxPathSum2(root));
	}
}
