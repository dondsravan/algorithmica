package com.algorithmica.advanced.tree;

import java.util.HashMap;

/**
 * Given a Metro network with binary tree structure in which each station is
 * associated with expected profit. Constraint: No adjacent stations are allowed
 * for same business unit
 */
public class MaxSumNoAdjacent {

	public static long maxSum1(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return root.data;
		long exclusive_profit = maxSum1(root.left);
		exclusive_profit += maxSum1(root.right);
		long inclusive_profit = root.data;
		TreeNode lc = root.left;
		TreeNode rc = root.right;
		if (lc != null) {
			inclusive_profit += maxSum1(lc.left) + maxSum1(lc.right);
		}
		if (rc != null) {
			inclusive_profit += maxSum1(rc.left) + maxSum1(rc.right);
		}
		return Math.max(exclusive_profit, inclusive_profit);
	}

	// Time: O(n)
	// Space: O(n)
	public static long maxSum2(TreeNode root) {
		HashMap<TreeNode, Long> nodeMaxSums = new HashMap<>();
		auxMaxSum2(root, nodeMaxSums);
		return nodeMaxSums.get(root);
	}

	private static long getHashOrSum(HashMap<TreeNode, Long> nodeMaxSums, TreeNode node) {
		long temp = 0;
		temp += nodeMaxSums.get(node.left) != null ? nodeMaxSums.get(node.left) : auxMaxSum2(node.left, nodeMaxSums);
		temp += nodeMaxSums.get(node.right) != null ? nodeMaxSums.get(node.right) : auxMaxSum2(node.right, nodeMaxSums);
		return temp;
	}

	private static long auxMaxSum2(TreeNode root, HashMap<TreeNode, Long> nodeMaxSums) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return root.data;

		long exclusive_profit = getHashOrSum(nodeMaxSums, root);
		long inclusive_profit = root.data;

		TreeNode lc = root.left;
		TreeNode rc = root.right;
		if (lc != null) {
			inclusive_profit += getHashOrSum(nodeMaxSums, lc);
		}
		if (rc != null) {
			inclusive_profit += getHashOrSum(nodeMaxSums, rc);
		}
		long max = Math.max(exclusive_profit, inclusive_profit);
		nodeMaxSums.put(root, max);
		return max;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayLevelTree(root);
		System.out.println(maxSum1(root));
		System.out.println(maxSum2(root));
	}
}
