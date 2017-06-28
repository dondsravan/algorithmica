package com.algorithmica.assignment.three;

import java.util.HashSet;
import java.util.Set;

public class LinkedListUtils {

	public static int getListLength(ListNode head) {
		int length = 0;
		while (head != null) {
			head = head.next;
			++length;
		}
		return length;
	}

	public static void displayList(ListNode head) {
		if (head == null) {
			System.out.println("Linked list is empty.");
			return;
		}
		ListNode current = head;
		while (current.next != null) {
			System.out.print(current.data + " -> ");
			current = current.next;
		}
		System.out.println(current.data);
	}

	public static void displayLoopList(ListNode head) {
		if (head == null) {
			System.out.println("Linked list is empty.");
			return;
		}
		ListNode current = head;
		Set<ListNode> listSet = new HashSet<ListNode>();
		while (current.next != null && !listSet.contains(current)) {
			System.out.print(current.data + " -> ");
			listSet.add(current);
			current = current.next;
		}
		System.out.println(current.data);
		if (current.next == null)
			System.out.println("Loop not available");
		else
			System.out.println("Loop available, node: " + current.data);
	}
}
