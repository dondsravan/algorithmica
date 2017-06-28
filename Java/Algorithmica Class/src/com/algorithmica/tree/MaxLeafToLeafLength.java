package com.algorithmica.tree;

// Longest leaf to leaf path
public class MaxLeafToLeafLength {

	private static int auxTreeDiameter(TreeNode root, MyInteger diameter) {
		if (root == null)
			return 0;
		int lh = auxTreeDiameter(root.left, diameter);
		int rh = auxTreeDiameter(root.right, diameter);
		diameter.set(Math.max(diameter.get(), lh + rh));
		return Math.max(lh, rh) + 1;
	}

	public static int treeDiameter(TreeNode root) {
		MyInteger diameter = new MyInteger();
		auxTreeDiameter(root, diameter);
		return diameter.get();
	}

	public static void main(String[] args) {
		int height = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(height);
		BinaryTreeUtils.displayLevelTree(root);
		System.out.println(treeDiameter(root));
	}
}
