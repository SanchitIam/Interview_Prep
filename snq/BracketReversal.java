package snq;

import java.util.*;

public class BracketReversal {

	public static int countReversal(String s) {
		Stack<Character> stk = new Stack<>();

		for (int i = 0; i < s.length(); ++i) {
			char ch = s.charAt(i);

			if (ch == '{') {
				stk.push('{');
			} else {
				if (stk.size() > 0 && stk.peek() == '{') {
					stk.pop();
				} else {
					stk.push('}');
				}
			}

		}

		int op = 0;
		int cl = 0;

		while (stk.size() > 0) {
			char c = stk.pop();
			if (c == '{') {
				op++;
			} else {
				cl++;
			}
		}
		
		
		int rv = (op/2)+(cl/2);
		if(op%2!=0) {
			rv+=2;
		}
		return rv;
	}

	public static void main(String[] args) {
		String s ="}{{}}{{{";
		System.out.println(countReversal(s));
	}
}
