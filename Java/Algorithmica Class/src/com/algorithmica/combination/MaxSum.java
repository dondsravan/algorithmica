package com.algorithmica.combination;

import java.util.Arrays;
import java.util.Random;

/**
 * Algorithm to find the maximum sum in array of n integers (Constraint: Should
 * exclude the contiguous numbers)
 * 
 * m(n) = max(m(n-1), m(n-2) + a[n])
 */
public class MaxSum {

	// Worst Case - We calculate repeated values
	public static int findMaxSum(int[] arr) {
		return auxMaxSum(arr.length, arr);
	}

	private static int auxMaxSum(int i, int[] arr) {
		if (i == 0)
			return Integer.MIN_VALUE;
		if (i == 1)
			return arr[i - 1];
		int exclusive_sum = auxMaxSum(i - 1, arr);
		int inclusive_sum = auxMaxSum(i - 2, arr);
		if (inclusive_sum > 0 && arr[i - 1] > 0)
			inclusive_sum = inclusive_sum + arr[i - 1];
		else
			inclusive_sum = Math.max(inclusive_sum, arr[i - 1]);
		return Math.max(exclusive_sum, inclusive_sum);
	}

	// RECURSION
	// Time: O(n)
	// Space: O(n)
	// Limitation: Stack overflow
	public static int findMaxSum2(int[] arr) {
		int[] c = new int[arr.length + 1];
		return auxMaxSum2(arr.length, arr, c);
	}

	private static int auxMaxSum2(int i, int[] arr, int[] c) {
		if (i == 0)
			return Integer.MIN_VALUE;
		if (i == 1)
			return arr[i - 1];
		int exclusive_sum = (c[i - 1] != 0) ? c[i - 1] : auxMaxSum2(i - 1, arr, c);
		int inclusive_sum = getMaxValue((c[i - 2] != 0) ? c[i - 2] : auxMaxSum2(i - 2, arr, c), arr[i - 1]);
		return c[i] = Math.max(exclusive_sum, inclusive_sum);
	}

	private static int getMaxValue(int a, int b) {
		if (a > 0 && b > 0)
			return a + b;
		else
			return Math.max(a, b);
	}

	// NO RECURSION
	// Time: O(n)
	// Space: O(n)
	public static int findMaxSum3(int[] arr) {
		int n = arr.length;
		int[] c = new int[n + 1];
		c[0] = 0;
		c[1] = arr[0];
		for (int i = 2; i <= n; ++i) {
			int exclusive_sum = c[i - 1];
			int inclusive_sum = getMaxValue(c[i - 2], arr[i - 1]);
			c[i] = Math.max(exclusive_sum, inclusive_sum);
		}
		return c[n];
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		Random r = new Random();
		int[] in = new int[n];
		for (int i = 0; i < n; ++i)
			in[i] = -(r.nextInt(n) + 1);
		for (int i = 0; i < n; i += 3)
			in[i] = -in[i];
		System.out.println(Arrays.toString(in));
		// System.out.println(findMaxSum(in));
		System.out.println(findMaxSum2(in));
		System.out.println(findMaxSum3(in));
	}
}
