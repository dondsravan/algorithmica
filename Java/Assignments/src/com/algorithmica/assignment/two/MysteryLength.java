package com.algorithmica.assignment.two;

import org.apache.commons.lang3.StringUtils;

public class MysteryLength {

	// Naive
	public int getMysteryLength1(char[] s) {
		String str = String.valueOf(s);
		int strLength = str.length();
		int strLengthCount = String.valueOf(strLength).length();
		String mysteryLengthStr = str.substring(strLength - strLengthCount);
		int mysteryLength = StringUtils.isAlpha((CharSequence) mysteryLengthStr.substring(0, 1)) ? 0
				: Integer.parseInt(mysteryLengthStr);
		if (str.substring(0, strLength - strLengthCount).length() == mysteryLength)
			return mysteryLength;
		return Integer.parseInt(mysteryLengthStr.substring(1));
	}

	public int getMysteryLength2(char[] s) {
		int mysteryLength = 0;
		int length = s.length - 1;
		int counter = 0;
		while (length > 0) {
			mysteryLength += (s[length--] - 48) * (int) Math.pow(10, counter++);
			if (mysteryLength == length + 1)
				break;
		}
		return mysteryLength;
	}
}
