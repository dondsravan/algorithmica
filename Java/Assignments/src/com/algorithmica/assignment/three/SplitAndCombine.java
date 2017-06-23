package com.algorithmica.assignment.three;

public class SplitAndCombine {

	public ListNode splitAndCombine(ListNode head) {

		int length = 0;
		ListNode current = head, tmp;
		while (current != null) {
			current = current.next;
			++length;
		}
		if (length <= 1)
			return head;

		current = head;
		for (int i = 1; i < length / 2; ++i) {
			current = current.next;
		}
		tmp = current.next;
		current.next = null;
		current = head;
		head = tmp;
		while (tmp.next != null)
			tmp = tmp.next;
		tmp.next = current;

		return head;
	}
}
