package com.algorithmica.assignment.four.lfucache;

import java.util.LinkedHashSet;

public class ListNode {

	private Integer frequency;
	private ListNode prev;
	private ListNode next;
	private LinkedHashSet<Integer> keys;

	protected ListNode() {
		this.prev = new ListNode();
		this.next = new ListNode();
		this.keys = new LinkedHashSet<>();
	}

	protected ListNode(Integer frequency) {
		this.frequency = frequency;
		this.prev = new ListNode();
		this.next = new ListNode();
		this.keys = new LinkedHashSet<>();
	}

	protected void addKey(Integer key) {
		this.keys.add(key);
	}

	protected void removeKey(Integer key) {
		this.keys.remove(key);
	}

	protected LinkedHashSet<Integer> getAllKeys() {
		return this.keys;
	}

	/**
	 * @return the frequency
	 */
	protected Integer getFrequency() {
		return frequency;
	}

	/**
	 * @param frequency
	 *            the frequency to set
	 */
	protected void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	/**
	 * @return the prev
	 */
	protected ListNode getPrev() {
		return prev;
	}

	/**
	 * @param prev
	 *            the prev to set
	 */
	protected void setPrev(ListNode prev) {
		this.prev = prev;
	}

	/**
	 * @return the next
	 */
	protected ListNode getNext() {
		return next;
	}

	/**
	 * @param next
	 *            the next to set
	 */
	protected void setNext(ListNode next) {
		this.next = next;
	}

}
