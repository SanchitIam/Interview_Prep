package snq;

import java.util.*;

public class UnbalancedLen {
	public static int printLength(String s) {
		Stack<Character> stk = new Stack<>();

		for (int i = 0; i < s.length(); ++i) {
			char ch = s.charAt(i);

			if (ch == '(') {
				stk.push(ch);
			} else {
				if (stk.size() > 0 && stk.peek() == '(') {
					stk.pop();
				} else {
					stk.push(ch);
				}
			}
		}

		return stk.size();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// String s = sc.next();

		System.out.println(printLength(")))))))))))))))))))))))(("));
	}

}
