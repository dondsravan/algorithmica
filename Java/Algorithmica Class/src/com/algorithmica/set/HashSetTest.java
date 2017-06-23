package com.algorithmica.set;

import java.util.Random;

public class HashSetTest {

	public static void testSet(Set set, int n) {

		Random r = new Random();

		for (int i = 0; i < n; ++i)
			set.add(r.nextInt(n) + 1);
		set.display();
		System.out.println(set.size());

		for (int i = 0; i < n * 10; ++i)
			set.add(r.nextInt(n * 10) + 1);
		set.display();
		System.out.println(set.size());
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		testSet(new HashSet(), n);
	}
}
