package com.algorithmica.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BinaryTreeUtils {

	private static TreeNode addToTree(TreeNode root, int data) {
		if (root == null)
			return new TreeNode(data);
		TreeNode parent = null, current = root;
		boolean addLeft = true;
		while (current != null) {
			parent = current;
			if (Math.random() < 0.5) {
				current = current.left;
				addLeft = true;
			} else {
				current = current.right;
				addLeft = false;
			}
		}
		current = new TreeNode(data);
		if (addLeft)
			parent.left = current;
		else
			parent.right = current;
		return root;
	}

	public static TreeNode createBinaryTree(int n) {
		Random rand = new Random();
		TreeNode root = null;
		for (int i = 0; i < n; ++i) {
			root = addToTree(root, rand.nextInt(n));
		}
		return root;
	}

	public static void displayLevelTree(TreeNode root) {
		if (root == null)
			System.out.println("Tree is empty");
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode dummy = new TreeNode(null);
		queue.add(root);
		queue.add(null);
		while (true) {
			TreeNode tmp = queue.remove();
			if (tmp == null) {
				System.out.println();
				if (!queue.isEmpty())
					queue.add(null);
				else
					break;
			} else {
				System.out.print(tmp.data + " ");
				if (tmp == dummy)
					continue;
				if (tmp.left != null)
					queue.add(tmp.left);
				else
					queue.add(dummy);
				if (tmp.right != null)
					queue.add(tmp.right);
				else
					queue.add(dummy);
			}
		}
	}

	public static void displayTree(TreeNode root) {

	}
}
