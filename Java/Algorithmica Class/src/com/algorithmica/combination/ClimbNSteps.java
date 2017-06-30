package com.algorithmica.combination;

/**
 * Find an efficient algorithm that allows us to count the number of distinct
 * ways for climbing n steps. Constraint: 1/2 steps at a time
 * 
 * c(n) = c(n-1) + c(n-2)
 * 
 * The summation is same, but the base cases will be different i.e. c(1) -> 1
 * and c(2) -> 2
 */
public class ClimbNSteps {

	// Dynamic programming
	// Memorizing the values and using them when required, saves a lot of time
	// Space - O(n)
	// Time Complexity - O(n)
	// Limitation - When 'n' is larger there'll be 'stack overflow'
	public static long getCountWaysR(int n) {
		long[] mem = new long[n + 1];
		auxCountWaysR(n, mem);
		return mem[n];
	}

	private static long auxCountWaysR(int n, long[] mem) {
		if (n <= 2)
			return n;
		if (mem[n] != 0)
			return mem[n];
		mem[n] = auxCountWaysR(n - 1, mem) + auxCountWaysR(n - 2, mem);
		return mem[n];
	}

	// No Recursion
	// Time complexity - O(n)
	// Space - O(1)
	// Limitation - Datatype, problem if result exceeds long max value
	public static long getCountWaysNR(int n) {
		long nthFib = 0;
		long previous = 1;
		long current = 2;
		while (n-- > 2) {
			nthFib = current + previous;
			previous = current;
			current = nthFib;
		}
		return nthFib;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);

		System.out.println(getCountWaysR(n));
		System.out.println(getCountWaysNR(n));
	}
}
