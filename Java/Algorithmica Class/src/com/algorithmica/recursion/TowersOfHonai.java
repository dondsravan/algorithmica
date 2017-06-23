package com.algorithmica.recursion;

public class TowersOfHonai {

	// Space complexity (stack depth) - O(n)
	// Time complexity - O(2^n)
	public static void honai(int n, char src, char aux, char target) {
		if (n == 1) {
			System.out.println(src + "->" + target);
			return;
		}
		honai(n - 1, src, target, aux);
		System.out.println(src + "->" + target);
		honai(n - 1, aux, src, target);
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		honai(n, 'A', 'B', 'C');
	}
}
