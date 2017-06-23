package com.algorithmica.assignment.three;

public class LinkedListUtils {

	public void display(ListNode head) {
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
}
