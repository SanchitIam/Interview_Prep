package snq;

import java.util.*;

class SortedStack {
	// This function return the sorted stack
	public static Stack<Integer> sortstack(Stack<Integer> input) {
		Stack<Integer> stk = new Stack<>();

		while (input.size() > 0) {
			if (stk.size() == 0) {
				stk.push(input.pop());
			} else {

				int pop = input.pop();
				while (stk.size() > 0 && pop < stk.peek()) {
					input.push(stk.pop());
				}

				stk.push(pop);
			}
		}

		return stk;
	}

	// Dont make changes here
	public static void main(String args[]) {
		Stack<Integer> input = new Stack<Integer>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++)
			input.push(sc.nextInt());

		Stack<Integer> res = sortstack(input);

		while (!res.empty()) {
			System.out.print(res.pop() + " ");
		}
	}
}