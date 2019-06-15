package snq;

import java.util.*;
import java.io.*;

public class DecodeStringAtIndex {

	public static String decodeIndex(String S, int K) {
		// calculate size;
		int size = 0;
		int j = 0;
		for (int i = 0; i < S.length(); ++i, j++) {
			char ch = S.charAt(i);
			if (ch >= 'a' && ch <= 'z') {
				size++;
			} else {
				String s = "";
				char c = S.charAt(j);
				while (c >= '0' && c <= '9') {
					s = s + c + "";
					j++;
					c = S.charAt(j);
				}
				j--;
				i = j;
				int val = Integer.parseInt(s);
				size = size * val;
			}
		}
		
		
		String rv = "";
		j = S.length() - 1;
		System.out.println(size);
		for (int i = S.length() - 1; i >= 0; --i, --j) {
			char ch = S.charAt(i);
			System.out.println("char: " + ch + " size: " + size + " K: " + K);
			if ((K+1) % size == 0) {
				rv += ch;
				break;
			}

			if (Character.isAlphabetic(ch)) {
				size--;
				K = K % size;
			} else {
				String s = "";
				char c = S.charAt(j);
				while (c >= '0' && c <= '9') {
					s = c + s + "";
					j--;
					c = S.charAt(j);
				}
				j++;
				i = j;
				int val = Integer.parseInt(s);
				size = size / val;
				K = K % size;
			}
		}

		return rv;

	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int k = sc.nextInt();
		System.out.println(decodeIndex(s, k));
	}

}
