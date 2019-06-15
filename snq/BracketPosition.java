package snq;

import java.util.*;

public class BracketPosition {
	public static void printBracketsPos(String s) {

		Stack<Integer> stk = new Stack<>();
		int no = 1;
		for (int i = 0; i < s.length(); ++i) {
			char ch = s.charAt(i);
			if (ch == '(') {
				System.out.print(no + " ");
				stk.push(no);
				no++;
			} else if (ch == ')') {
				System.out.print(stk.pop() + " ");
			} else {
				continue;
			}
		}

	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		printBracketsPos(s);

	}
}
