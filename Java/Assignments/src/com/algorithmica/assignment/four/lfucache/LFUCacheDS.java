package com.algorithmica.assignment.four.lfucache;

import java.util.HashMap;

public class LFUCacheDS {

	private int cacheSize;
	private HashMap<Integer, Integer> keyValuePairs;
	private HashMap<Integer, ListNode> frequencyNodes;
	private ListNode head;

	public LFUCacheDS(int cacheSize) {
		this.cacheSize = cacheSize;
		this.keyValuePairs = new HashMap<>();
		this.frequencyNodes = new HashMap<>();
		this.head = null;
	}

	public void putKeyValue(Integer key, Integer value) {
		this.keyValuePairs.put(key, value);
	}

	public Integer getValue(Integer key) {
		return this.keyValuePairs.get(key);
	}

	public void setFrequencyNode(Integer key, ListNode node) {
		this.frequencyNodes.put(key, node);
	}

	public ListNode getFrequencyNode(Integer key) {
		return this.frequencyNodes.get(key);
	}

	public ListNode getHeadNode() {
		return this.head;
	}

	public boolean isFull() {
		return cacheSize > keyValuePairs.size();
	}
}
