package snq;

import java.util.*;
import java.lang.*;
import java.io.*;

class ManupulatingString {

	public static int stringManipulation(String[] S) {
		Stack<String> stk = new Stack<>();

		for (int i = 0; i < S.length; ++i) {

			String str = S[i];

			if (stk.size() > 0 && stk.peek().equals(str)) {
				stk.pop();
			} else {
				stk.push(str);
			}

		}

		return stk.size();

	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		String[] S = new String[l];
		for (int i = 0; i < S.length; i++)
			S[i] = sc.next();
		System.out.println(stringManipulation(S));
	}
}