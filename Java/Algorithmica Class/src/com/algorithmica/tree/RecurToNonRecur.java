package com.algorithmica.tree;
import java.util.Stack;

class StackFrame {
	TreeNode node;
	boolean flag;

	public StackFrame(TreeNode node) {
		this.node = node;
		this.flag = false;
	}
}

public class RecurToNonRecur {

	// TAIL RECURSION
	public static void template0R(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.getData() + " ");
		if (root.getData() % 2 == 0)
			template0R(root.getLeft());
		else
			template0R(root.getRight());
	}

	public static void template0NR(TreeNode root) {
		while (root != null) {
			System.out.print(root.getData() + " ");
			if (root.getData() % 2 == 0)
				root = root.getLeft();
			else
				root = root.getRight();
		}
	}

	// PRE ORDER TRAVERSAL
	// Time Complexity - O(n)
	// Space Complexity - O(n)
	public static void template1R(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.getData() + " ");
		template1R(root.getLeft());
		template1R(root.getRight());
	}

	// Time Complexity -> n * 2 * O(1) -> O(n)
	// Space Complexity -> O(n)
	public static void template1NR(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		while (true) {
			while (root != null) {
				System.out.print(root.getData() + " ");
				stack.push(root);
				root = root.getLeft();
			}
			if (stack.isEmpty())
				break;
			root = stack.pop().getRight();
		}
	}

	// POST ORDER TRAVERSAL
	public static void template2R(TreeNode root) {
		if (root == null)
			return;
		template2R(root.getLeft());
		template2R(root.getRight());
		System.out.print(root.getData() + " ");
	}

	public static void template2NR(TreeNode root) {
		Stack<StackFrame> stack = new Stack<>();
		while (true) {
			while (root != null) {
				stack.push(new StackFrame(root));
				root = root.getLeft();
			}
			if (stack.isEmpty())
				break;
			if (stack.peek().flag) {
				System.out.print(stack.pop().node.getData() + " ");
				root = null;
			} else {
				stack.peek().flag = true;
				root = stack.peek().node.getRight();
			}
		}
	}

	public static void main(String[] args) {
		TreeNode root = BinaryTreeUtils.createBinaryTree(Integer.parseInt(args[0]));
		BinaryTreeUtils.displayLevelTree(root);
		template2R(root);
		System.out.println();
		template2NR(root);
	}
}
