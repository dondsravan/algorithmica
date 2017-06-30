package com.algorithmica.combination;

/**
 * Find an efficient algorithm to count number of distinct paths in a given grid
 * between top left most cell and bottom right most cell. (Constraint: Move only
 * one cell to right or down)
 */
public class DistinctPathsInGrid {

	public static int distintPaths1(int n) {
		MyInteger totalPaths = new MyInteger();
		totalPaths.set(0);
		auxPaths1(1, 1, n, totalPaths);
		return totalPaths.get();
	}

	private static void auxPaths1(int i, int j, int n, MyInteger totalPaths) {
		if (i >= n || j >= n)
			return;
		if (i == n - 1 && j == n - 1) {
			totalPaths.increment();
			return;
		}
		auxPaths1(i + 1, j, n, totalPaths);
		auxPaths1(i, j + 1, n, totalPaths);
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		System.out.println(distintPaths1(n));
	}
}
