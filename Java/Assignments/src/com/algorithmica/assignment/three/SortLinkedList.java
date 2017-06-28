package com.algorithmica.assignment.three;

public class SortLinkedList {

	public ListNode sortList(ListNode head) {

		if (head == null || head.next == null)
			return head;

		ListNode a = head;
		ListNode b = head.next;

		while (b != null && b.next != null) {
			head = head.next;
			b = b.next.next;
		}
		b = head.next;
		head.next = null;

		return mergeSortedLists(sortList(a), sortList(b));
	}

	private ListNode mergeSortedLists(ListNode a, ListNode b) {

		if (a == null)
			return b;
		if (b == null)
			return a;

		ListNode result = new ListNode();

		if (a.data < b.data) {
			result = a;
			result.next = mergeSortedLists(a.next, b);
		} else {
			result = b;
			result.next = mergeSortedLists(a, b.next);
		}

		return result;
	}
}
