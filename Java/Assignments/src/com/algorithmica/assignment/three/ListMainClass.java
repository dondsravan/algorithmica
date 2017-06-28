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
		SplitAndCombine sac = new SplitAndCombine();

		for (int i = 1; i < length; ++i) {
			current = new ListNode(rand.nextInt(length) + 1);
			prev.next = current;
			prev = current;
		}
		LinkedListUtils.displayList(head);
		head = sac.splitAndCombine2(head);
		LinkedListUtils.displayList(head);
	}

	public static void testLoopRemoval(String[] args) {

		int length = Integer.parseInt(args[0]);
		Random rand = new Random();
		ListNode head, current, prev;
		if (length > 0)
			head = new ListNode(length);
		else
			head = null;
		prev = head;

		int flag = 1;
		ListNode random = null;
		for (int i = 1; i < length; ++i) {
			current = new ListNode(rand.nextInt(length) + 1);
			if (flag == length / 2)
				random = current;
			prev.next = current;
			prev = current;
			++flag;
		}
		prev.next = random;
		LinkedListUtils.displayLoopList(head);
		LoopRemoval.removeLoop(head);
		LinkedListUtils.displayLoopList(head);
	}

	public static void testSortLinkedList(String[] args) {

		int length = Integer.parseInt(args[0]);
		Random rand = new Random();
		ListNode head, current, prev;
		if (length > 0)
			head = new ListNode(length);
		else
			head = null;
		prev = head;
		for (int i = 1; i < length; ++i) {
			current = new ListNode(rand.nextInt(length) + 1);
			prev.next = current;
			prev = current;
		}

		SortLinkedList sort = new SortLinkedList();

		long start = System.currentTimeMillis();
		head = sort.sortList(head);
		long end = System.currentTimeMillis();

		LinkedListUtils.displayList(head);

		System.out.println("Length: " + LinkedListUtils.getListLength(head));
		System.out.println("Time: " + (end - start) / 1000.0);
	}

	public static void main(String[] args) {

		testSplitAndCombine(args);
		// testLoopRemoval(args);
		// testSortLinkedList(args);

	}

}
