package snq;

import java.util.*;

class StackValidation {
	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> stk = new Stack<>();
		int i = 0;
		int j = 0;

		while (j < popped.length) {
			if (stk.size() > 0 && stk.peek() == popped[j]) {
				stk.pop();
				j++;
			} else {
				if (i >= pushed.length) {

					return false;
				}
				stk.push(pushed[i]);
				i++;
			}
		}
		return true;

	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] pushed = new int[N];
		int[] popped = new int[N];
		for (int i = 0; i < N; i++)
			pushed[i] = sc.nextInt();
		for (int i = 0; i < N; i++)
			popped[i] = sc.nextInt();
		System.out.print(validateStackSequences(pushed, popped));
	}
}