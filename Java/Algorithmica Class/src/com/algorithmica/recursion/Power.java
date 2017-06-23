package com.algorithmica.recursion;

public class Power {

	public static long getPower(int x, int n) {

		if (n == 0)
			return 1;
		else if (n == 1)
			return x;
		else {
			long value = getPower(x, n / 2);
			if (n % 2 == 0)
				return value * value;
			else
				return value * value * x;
		}
	}

	public static void main(String[] args) {

	}

}
