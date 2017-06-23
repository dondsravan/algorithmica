package com.algorithmica.assignment.one;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class FindDuplicates {

	// This solution is only applicable if elements range is b/w 0 to N-1
	public static int findAnyDuplicate1(int[] arr) {
		int value;
		for (int i = 0; i < arr.length; ++i) {
			value = Math.abs(arr[i]);
			if (arr[value] < 0) {
				return value;
			} else {
				arr[value] = -arr[value];
			}
		}
		return Integer.MAX_VALUE;
	}

	// For any integer array
	public static int findAnyDuplicate2(int[] arr) {
		Set<Integer> ndup = new HashSet<>();
		for (int i = 0; i < arr.length; ++i) {
			if (ndup.contains(arr[i])) {
				return arr[i];
			} else {
				ndup.add(arr[i]);
			}
		}
		return Integer.MAX_VALUE;
	}

	public static void main(String[] args) {

		int n = Integer.parseInt(args[0]);
		Random rand = new Random();
		int[] in = new int[n];
		for (int i = 0; i < n; ++i) {
			in[i] = rand.nextInt(n - 1) + 1;
		}

		long start = System.currentTimeMillis();
		System.out.println(findAnyDuplicate2(in));
		long end = System.currentTimeMillis();
		System.out.println(findAnyDuplicate1(in));
		long end2 = System.currentTimeMillis();

		System.out.println((end - start) / 1000.0);
		System.out.println((end2 - end) / 1000.0);
	}
}
