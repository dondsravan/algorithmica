package com.algorithmica.assignment.one;

import java.util.Arrays;
import java.util.Random;

public class FindDuplicates {

	public static int findAnyDuplicate(int[] arr) {
		int index;
		int length = arr.length;
		for (int i = 0; i < length - 1; ++i) {
			index = Arrays.binarySearch(arr, i + 1, length, arr[i]);
			System.out.println(arr[i]);
			System.out.println(index);
			System.out.println(arr[index]);
			if (index > 0) {
				return arr[index];
			}
		}
		return Integer.MAX_VALUE;
	}

	public static void main(String[] args) {

		int n = Integer.parseInt(args[0]);
		Random rand = new Random(n);
		int[] in = new int[n];
		for (int i = 0; i < n; ++i) {
			in[i] = rand.nextInt(n - 1) + 1;
			System.out.print(in[i] + " ");
		}
		System.out.println("\n");

		long start = System.currentTimeMillis();
		System.out.println(findAnyDuplicate(in));
		long end = System.currentTimeMillis();

		System.out.println((end - start) / 1000.0);
	}
}
