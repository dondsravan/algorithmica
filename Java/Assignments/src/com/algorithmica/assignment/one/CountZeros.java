package com.algorithmica.assignment.one;

import java.util.Arrays;
import java.util.Random;

public class CountZeros {
	public static int countZeros(int[] a, int n) {
		int count = 0;
		for (int i = 0; i < n; ++i) {
			if (a[i] == 0)
				++count;
			else
				break;
		}
		return count;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] a = new int[n];
		Random rand = new Random();
		
		for (int i = 0; i < n; ++i) {
			a[i] = rand.nextInt(1);
		}
		
		Arrays.sort(a);

		long start = System.currentTimeMillis();
		System.out.println(countZeros(a, n));
		long end = System.currentTimeMillis();

		System.out.println((end - start) / 1000.0);
	}
}
