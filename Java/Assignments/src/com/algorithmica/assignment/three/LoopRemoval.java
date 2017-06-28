package com.algorithmica.assignment.three;

import java.util.HashSet;
import java.util.Set;

public class LoopRemoval {

	public static void removeLoop(ListNode head) {
		if (head == null)
			System.out.println("LinkedList is empty");
		ListNode current = head;
		Set<ListNode> listSet = new HashSet<ListNode>();
		listSet.add(current);
		while (current.next != null && !listSet.contains(current.next)) {
			current = current.next;
			listSet.add(current);
		}
		if (current.next == null)
			System.out.println("LinkedList does not contain any loops");
		else
			current.next = null;
	}
}
