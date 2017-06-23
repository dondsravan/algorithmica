package com.algorithmica.cache;

import java.util.HashMap;

public class LinkedHashCache implements Cache {

	private HashMap<String, DListNode> index;
	private DoublyLinkedList list;
	private int size;

	public LinkedHashCache(int size) {
		this.size = size;
		index = new HashMap<String, DListNode>();
		list = new DoublyLinkedList();
	}

	private boolean isFull() {
		return false;
	}

	// O(1)
	@Override
	public Integer get(String key) {
		DListNode tmp = index.get(key);
		Integer res = null;
		if (tmp != null) {
			res = tmp.value;
			list.removeAddLast(tmp);
			return res;
		}
		return res;
	}

	@Override
	public void put(String key, Integer value) {
		DListNode tmp = index.get(key);
		if (tmp != null) {
			tmp.value = value;
			list.removeAddLast(tmp);
		} else {
			if (isFull()) {
				DListNode lru = list.removeFirst();
				index.remove(lru.key);
			}
			DListNode last = list.addLast(key);
			index.put(key, last);
		}
	}

	@Override
	public void display() {
		list.display();
	}

}
