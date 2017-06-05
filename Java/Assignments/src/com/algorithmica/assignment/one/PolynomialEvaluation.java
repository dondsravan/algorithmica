package com.algorithmica.assignment.one;

import java.math.BigInteger;
import java.util.Random;

public class PolynomialEvaluation {
	
	public static BigInteger evalPolynomial(int[] c, int x, int n) {
		BigInteger result = BigInteger.ZERO;
		for (int i = 0; i < n; ++i) {
			result = result.add(BigInteger.valueOf(c[i]).multiply(BigInteger.valueOf(x).pow(i)));
		}
		return result;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int x = Integer.parseInt(args[1]);
		int[] c = new int[n];
		Random rand = new Random();

		for (int i = 0; i < n; ++i) {
			c[i] = rand.nextInt(n);
			System.out.print(c[i] + " ");
		}

		System.out.println("\n");

		long start = System.currentTimeMillis();
		System.out.println(evalPolynomial(c, x, n));
		long end = System.currentTimeMillis();

		System.out.println((end - start) / 1000.0);
	}
}
