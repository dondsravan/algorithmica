package com.algorithmica.assignment.three;

import java.util.Random;

public class ListMainClass {

	public static void testSplitAndCombine(String[] args) {

		int length = Integer.parseInt(args[0]);
		Random rand = new Random();
		ListNode head, current, prev;
		if (length > 0)
			head = new ListNode(length);
		else
			head = null;
		prev = head;
		LinkedListUtils utils = new LinkedListUtils();
		SplitAndCombine sac = new SplitAndCombine();

		for (int i = 1; i < length; ++i) {
			current = new ListNode(rand.nextInt(length) + 1);
			prev.next = current;
			prev = current;
		}
		utils.display(head);
		head = sac.splitAndCombine(head);
		utils.display(head);
	}

	public static void main(String[] args) {

		testSplitAndCombine(args);
	}

}
