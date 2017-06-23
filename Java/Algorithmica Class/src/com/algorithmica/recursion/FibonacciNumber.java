package com.algorithmica.recursion;

import java.math.BigInteger;

// Different solutions for finding nth fibonacci value
// Sequence - 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 .... (n-3 + n-2), (n-2 + n-1)
public class FibonacciNumber {

	// This algorithm will compute the fibonacci values multiple times, redo
	// same work again and again - Repeated Calculations/Sub problems
	// Space - O(n)
	// Time complexity - O(2^n)
	public static long getNthFibonacci1(int n) {
		if (n <= 2)
			return 1;
		return (getNthFibonacci1(n - 1) + getNthFibonacci1(n - 2));
	}

	// Dynamic programming
	// Memorizing the values and using them when required, saves a lot of time
	// Space - O(n)
	// Time Complexity - O(n)
	// Limitation - When 'n' is larger there'll be 'stack overflow'
	public static long getNthFibonacci2(int n) {
		long[] mem = new long[n + 1];
		auxNthFibonacci2(n, mem);
		return mem[n];
	}

	private static long auxNthFibonacci2(int n, long[] mem) {
		if (n <= 2)
			return 1;
		if (mem[n] != 0)
			return mem[n];
		mem[n] = auxNthFibonacci2(n - 1, mem) + auxNthFibonacci2(n - 2, mem);
		return mem[n];
	}

	// No Recursion
	// Time complexity - O(n)
	// Space - O(1)
	// Limitation - Datatype, problem if result exceeds long max value
	public static long getNthFibonacci3(int n) {
		long nthFib = 0;
		long previous = 0;
		long current = 1;
		while (n-- >= 2) {
			nthFib = current + previous;
			previous = current;
			current = nthFib;
		}
		return nthFib;
	}

	public static BigInteger getNthFibonacci4(int n) {
		BigInteger nthFib = BigInteger.ZERO;
		BigInteger previous = BigInteger.ZERO;
		BigInteger current = BigInteger.ONE;
		while (n-- >= 2) {
			nthFib = current.add(previous);
			previous = current;
			current = nthFib;
		}
		return nthFib;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);

		long start = System.currentTimeMillis();
		System.out.println(getNthFibonacci2(n));
		long end1 = System.currentTimeMillis();
		System.out.println(getNthFibonacci3(n));
		long end2 = System.currentTimeMillis();

		System.out.println((end1 - start) / 1000.0);
		System.out.println((end2 - end1) / 1000.0);
	}
}
