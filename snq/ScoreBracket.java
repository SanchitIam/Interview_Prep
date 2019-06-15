package snq;

import java.util.*;

public class ScoreBracket {

	public static int scoreOfParentheses(String s) {
		Stack<Integer> stk = new Stack<>();
		for (int i = 0; i < s.length(); ++i) {
			char ch = s.charAt(i);

			if (ch == '(') {
				stk.push(-1);
			} else {
				if (stk.peek() == -1) {
					stk.pop();
					stk.push(1);
				} else {
					int sum = 0;
					while (stk.peek() != -1) {
						sum += stk.pop();
					}

					stk.pop();
					stk.push(2 * sum);
				}
			}
		}
		int rv = 0;
		while (stk.size() > 0) {
			rv += stk.pop();
		}
		return rv;
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(scoreOfParentheses(s));
	}

}