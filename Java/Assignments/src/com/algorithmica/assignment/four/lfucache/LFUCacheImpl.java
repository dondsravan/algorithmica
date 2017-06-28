package com.algorithmica.assignment.four.lfucache;

import java.util.LinkedHashSet;

public class LFUCacheImpl implements LFUCache<Integer, Integer> {

	LFUCacheDS cache;

	public LFUCacheImpl(int cacheSize) {
		cache = new LFUCacheDS(cacheSize);
	}

	@Override
	public void put(Integer key, Integer value) {
		if (cache.isKeyAvailable(key)) {
			cache.putKeyValue(key, value);
			incrementFrequency(key);
		} else {
			if (cache.isFull()) {
				removeLeastFrequencyKey();
			}
			cache.putKeyValue(key, value);
			addNodeAtHead(key);
		}
	}

	@Override
	public Integer get(Integer key) {
		Integer value = cache.getValue(key);
		if (value != null) {
			incrementFrequency(key);
		}
		return value;
	}

	@Override
	public void clear() {
		cache.clearCache();
	}

	@Override
	public void display() {
		System.out.println("Key/Value pairs in cache:");
		cache.displayKeyValuePairs();
	}

	private void incrementFrequency(Integer key) {
		ListNode node = cache.getFrequencyNode(key);
		if (node.getNext() != null && node.getNext().getFrequency().equals(node.getFrequency() + 1))
			node.getNext().addKey(key);
		else {
			addNodeAfterNode(key, node, node.getFrequency() + 1);
		}
		node.removeKey(key);
		if (node.getAllKeys().isEmpty()) {
			removeNode(node);
		}
	}

	private void addNodeAtHead(Integer key) {
		ListNode temp = new ListNode(1);
		temp.addKey(key);
		if (cache.getHeadNode() != null) {
			temp.setPrev(cache.getHeadNode().getPrev());
			temp.setNext(cache.getHeadNode());
			cache.getHeadNode().setPrev(temp);
		}
		cache.setHeadNode(temp);
		cache.setFrequencyNode(key, temp);
	}

	private void addNodeAfterNode(Integer key, ListNode node, int frequency) {
		ListNode temp = new ListNode(frequency);
		temp.addKey(key);
		if (node.getNext() != null) {
			temp.setNext(node.getNext());
			node.getNext().setPrev(temp);
		}
		node.setNext(temp);
		temp.setPrev(node);
		cache.setFrequencyNode(key, temp);
	}

	private void removeNode(ListNode node) {
		if (cache.getHeadNode().equals(node)) {
			cache.setHeadNode(node.getNext());
			cache.getHeadNode().setPrev(null);
		} else if (node.getNext() == null) {
			node.getPrev().setNext(null);
		} else {
			node.getPrev().setNext(node.getNext());
			node.getNext().setPrev(node.getPrev());
		}
	}

	private Integer getFirstKey(LinkedHashSet<Integer> keys) {
		for (Integer i : keys)
			return i;
		return null;
	}

	private void removeLeastFrequencyKey() {
		ListNode head = cache.getHeadNode();
		Integer key = getFirstKey(head.getAllKeys());
		head.removeKey(key);
		if (head.getAllKeys().isEmpty())
			removeNode(head);
		cache.removeKeyValuePair(key);
		cache.setFrequencyNode(key, null);
		cache.removeFrequencyNode(key);
	}
}
