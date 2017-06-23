package com.algorithmica.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeDepth {

	// RECURSION
	// Space Complexity - O(n)
	// Time Complexity - O(n)
	public static int treeDepth1(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		int lh = treeDepth1(root.left);
		int rh = treeDepth1(root.right);
		return Math.max(lh, rh) + 1;
	}

	// Using QUEUE
	// Space Complexity - <=(n/2) - O(n)
	// Time Complexity - O(n)
	public static int treeDepth2(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		int levels = 0;
		queue.add(root);
		queue.add(null);
		while (true) {
			TreeNode tmp = queue.remove();
			if (tmp == null) {
				++levels;
				if (!queue.isEmpty())
					queue.add(null);
				else
					break;
			} else {
				if (tmp.left != null)
					queue.add(tmp.left);
				if (tmp.right != null)
					queue.add(tmp.right);
			}
		}
		return levels;
	}

	public static void main(String[] args) {

		TreeNode root = BinaryTreeUtils.createBinaryTree(Integer.parseInt(args[0]));
		BinaryTreeUtils.displayLevelTree(root);
		System.out.println(treeDepth1(root));
		System.out.println(treeDepth2(root));
	}
}
