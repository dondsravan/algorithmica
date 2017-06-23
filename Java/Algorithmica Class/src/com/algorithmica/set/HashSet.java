package com.algorithmica.set;

public class HashSet implements Set {

	private ListNode[] buckets;
	private int size;

	public HashSet() {
		buckets = new ListNode[11];
		for (int i = 0; i < buckets.length; ++i)
			buckets[i] = new ListNode(i);
		size = 0;
	}

	private int getHash(int hash, int length) {
		return hash % length;
	}

	private void rehash() {
		ListNode[] buckets_new = new ListNode[2 * buckets.length];
		for (int i = 0; i < buckets_new.length; ++i)
			buckets_new[i] = new ListNode(i);
		ListNode tmp;
		for (int i = 0; i < buckets.length; ++i) {
			for (ListNode current = buckets[i].next; current != null; current = tmp) {
				int key = getHash(current.data.hashCode(), buckets_new.length);
				tmp = current.next;
				current.next = buckets_new[key].next;
				buckets_new[key].next = current;
			}
		}
		buckets = buckets_new;
	}

	@Override
	public boolean add(Integer i) {
		float avgsize = size / buckets.length;
		if (avgsize > 10) {
			rehash();
		}
		if (contains(i))
			return false;
		int key = getHash(i.hashCode(), buckets.length);
		ListNode tmp = new ListNode(i);
		tmp.next = buckets[key].next;
		buckets[key].next = tmp;
		++size;
		return true;
	}

	// O(1) - Because of the constant bucket length
	@Override
	public boolean contains(Integer i) {
		int key = getHash(i.hashCode(), buckets.length);
		for (ListNode current = buckets[key].next; current != null; current = current.next) {
			if (current.data.equals(i))
				return true;
		}
		return false;
	}

	@Override
	public boolean remove(Integer i) {
		if (!contains(i))
			return false;
		int key = getHash(i.hashCode(), buckets.length);
		for (ListNode current = buckets[key]; current.next != null; current = current.next) {
			if (current.next.data.equals(i)) {
				current.next = current.next.next;
				--size;
				return true;
			}
		}
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	// O(n)
	@Override
	public void display() {
		for (int i = 0; i < buckets.length; ++i) {
			System.out.print("Bucket " + i + " : ");
			for (ListNode current = buckets[i].next; current != null; current = current.next) {
				System.out.print(current.data + " ");
			}
			System.out.println();
		}
	}

}
