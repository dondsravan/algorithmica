package com.algorithmica.assignment.four.lfucache;

import java.util.HashMap;

public class LFUCacheDS {

	private int maxCacheSize;
	private int currentCacheSize;
	private HashMap<Integer, Integer> keyValuePairs;
	private HashMap<Integer, ListNode> frequencyNodes;
	private ListNode head;

	protected LFUCacheDS(int cacheSize) {
		maxCacheSize = cacheSize;
		keyValuePairs = new HashMap<>();
		frequencyNodes = new HashMap<>();
		head = null;
	}

	protected void clearCache() {
		currentCacheSize = 0;
		keyValuePairs.clear();
		frequencyNodes.clear();
		head = null;
	}

	protected void putKeyValue(Integer key, Integer value) {
		if (!isKeyAvailable(key))
			++currentCacheSize;
		keyValuePairs.put(key, value);
	}

	protected Integer getValue(Integer key) {
		return keyValuePairs.get(key);
	}

	protected boolean isKeyAvailable(Integer key) {
		return keyValuePairs.containsKey(key);
	}

	protected void removeKeyValuePair(Integer key) {
		if (keyValuePairs.remove(key) != null)
			--currentCacheSize;
	}

	protected void displayKeyValuePairs() {
		System.out.println(keyValuePairs.toString());
	}

	protected void setFrequencyNode(Integer key, ListNode node) {
		frequencyNodes.put(key, node);
	}

	protected ListNode getFrequencyNode(Integer key) {
		return frequencyNodes.get(key);
	}

	protected void removeFrequencyNode(Integer key) {
		frequencyNodes.remove(key);
	}

	protected ListNode getHeadNode() {
		return head;
	}

	protected void setHeadNode(ListNode node) {
		head = node;
	}

	protected boolean isFull() {
		return currentCacheSize >= maxCacheSize;
	}

	protected boolean isNotFull() {
		return currentCacheSize < maxCacheSize;
	}
}
