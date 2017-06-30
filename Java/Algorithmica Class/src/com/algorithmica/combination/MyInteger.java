package com.algorithmica.combination;

public class MyInteger {

	private int value;

	public MyInteger() {
		value = Integer.MIN_VALUE;
	}

	public int get() {
		return value;
	}

	public void set(int val) {
		value = val;
	}

	public void increment() {
		++value;
	}
}
