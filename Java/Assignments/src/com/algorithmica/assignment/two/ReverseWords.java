package com.algorithmica.assignment.two;

public class ReverseWords {

	public char[] reverseWords(char[] in) {

		int start, end, length = in.length, outLen = 0;
		start = end = length - 1;
		char[] out = new char[length];
		char space = ' ';

		while (true) {
			while (start + 1 > 0 && in[start] != space) {
				--start;
			}
			for (int i = start + 1; i <= end; ++i) {
				out[outLen++] = in[i];
			}
			if (outLen < length) {
				out[outLen++] = space;
				--start;
				end = start;
			} else
				break;
		}

		return out;
	}
}
