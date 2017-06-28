package com.algorithmica.assignment.three;

public class SplitAndCombine {

	public ListNode splitAndCombine1(ListNode head) {

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

	public ListNode splitAndCombine2(ListNode head) {

		if (head == null) {
			return head;
		}
		ListNode fast = head;
		ListNode slow = head;

		while (fast.next != null) {
			fast = fast.next;
			if (fast.next != null) {
				fast = fast.next;
				slow = slow.next;
			}
		}

		fast.next = head;
		head = slow.next;
		slow.next = null;

		return head;
	}
}
