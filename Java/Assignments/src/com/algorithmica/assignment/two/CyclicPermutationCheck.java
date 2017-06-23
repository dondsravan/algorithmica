package com.algorithmica.assignment.two;

public class CyclicPermutationCheck {

	private String str1, str2;

	public CyclicPermutationCheck(String s1, String s2) {
		str1 = s1;
		str2 = s2;
	}

	public boolean isCyclic() {
		if (str1.length() == str2.length()) {
			return str1.concat(str1).contains(str2);
		}
		return false;
	}
}
