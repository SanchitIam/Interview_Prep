package snq;

import java.util.*;
import java.lang.*;
import java.io.*;

class IsBalanced {
	public static void isbal(String s) {
		Stack<Character> stk = new Stack<>();

		for (int i = 0; i < s.length(); ++i) {
			char ch = s.charAt(i);

			if (ch == '[' || ch == '(' || ch == '{') {
				stk.push(ch);
			} else if (ch == '}' && stk.peek() == '{') {
				stk.pop();
			} else if (ch == ']' && stk.peek() == '[') {
				stk.pop();
			} else if (ch == ')' && stk.peek() == '(') {
				stk.pop();
			} else {
				System.out.println("not balanced");
				return;
			}

		}
		System.out.println("balanced");

	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		isbal(s);

	}
}