package com.algorithmica.assignment.four.lfucache;

public interface LFUCache<E, T> {

	public boolean put(E key, T value);

	public T get(E key);

	public void clear();

	public void display();
}
