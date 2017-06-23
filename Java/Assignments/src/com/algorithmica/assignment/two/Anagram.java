package com.algorithmica.assignment.two;

import org.apache.commons.lang3.StringUtils;

public class Anagram {

	public boolean isAnagram(String s1, String s2) {
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		int[] alphaCount = new int[26];

		if (s1.length() != s2.length())
			return false;
		if (!StringUtils.isAlpha(s1) || !StringUtils.isAlpha(s2))
			return false;

		for (int i = 0; i < s1.length(); ++i) {
			++alphaCount[s1.charAt(i) - 97];
			--alphaCount[s2.charAt(i) - 97];
		}
		for (int i = 0; i < alphaCount.length; i++)
			if (alphaCount[i] != 0)
				return false;

		return true;
	}
}
