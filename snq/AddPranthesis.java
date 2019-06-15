package snq;

import java.util.*;

public class AddPranthesis {

	public static int minAddToMakeValid(String S) {
		Stack<Character> stk = new Stack<>();

		for (int i = 0; i < S.length(); ++i) {
			char ch = S.charAt(i);

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

	// Dont make changes here
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(minAddToMakeValid(s));
	}

}