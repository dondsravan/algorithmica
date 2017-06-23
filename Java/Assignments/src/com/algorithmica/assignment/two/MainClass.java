package com.algorithmica.assignment.two;

public class MainClass {

	public static void testIsCyclic(String[] args) {
		CyclicPermutationCheck check = new CyclicPermutationCheck(args[0], args[1]);
		System.out.println(check.isCyclic());
	}

	public static void testMysteryLength(String[] args) {
		MysteryLength mLength = new MysteryLength();
		System.out.println(mLength.getMysteryLength2(args[0].toCharArray()));
	}

	public static void testReverseWords(String[] args) {
		char[] in = { 'M', 'y', ' ', ' ', 'n', 'a', 'm', 'e', ' ', 'i', 's', ' ', 'S', 'r', 'a', 'v', 'a', 'n' };
		ReverseWords reverse = new ReverseWords();
		char[] out = reverse.reverseWords(in);

		for (int i = 0; i < out.length; ++i) {
			System.out.print(out[i]);
		}
	}

	public static void testIsAnagram(String[] args) {
		Anagram a = new Anagram();
		System.out.println(a.isAnagram(args[0], args[1]));
	}

	public static void main(String[] args) {

		// testIsCyclic(args);
		// testMysteryLength(args);
		// testReverseWords(args);
		testIsAnagram(args);
	}

}
