package snq;

import java.util.*;
import java.util.*;

public class QueUsingStack {

	static class queUsingStack {

		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();

		queUsingStack() {

		}

		public void push(int x) {

			while (s1.size() > 0) {
				s2.push(s1.pop());
			}

			s1.push(x);

			while (s2.size() > 0) {
				s1.push(s2.pop());
			}

		}

		public int pop() {
			if (s1.size() > 0) {
				return s1.pop();
			} else {
				return -1;
			}
		}

		public int peek() {
			if (s1.size() > 0) {
				return s1.peek();
			} else {
				return -1;
			}
		}

		public boolean empty() {
			return s1.isEmpty();
		}

	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		queUsingStack qs = new queUsingStack();
		int Q = sc.nextInt();
		for (int i = 0; i < Q; i++) {
			int q = sc.nextInt();
			if (q == 1) {
				qs.push(sc.nextInt());
			} else if (q == 2) {
				System.out.print(qs.pop() + " ");
			} else if (q == 3) {
				System.out.print(qs.peek() + " ");
			} else if (q == 4) {
				System.out.print(qs.empty() + " ");
			}
		}
	}

}