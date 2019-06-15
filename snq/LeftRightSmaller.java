package snq;

import java.util.*;

class LeftRightSmaller {
	static int findMaxDiff(int A[], int N) {
		int[] left = new int[A.length];
		int[] right = new int[A.length];

		Stack<Integer> stk = new Stack<>();
		stk.push(0);
		for (int i = 1; i < A.length; ++i) {

			while (stk.size()>0&&A[stk.peek()] > A[i]) {
				int val = stk.pop();
				right[val] = A[i];
			}
			if (stk.size() > 0) {
				left[i] = A[stk.peek()];
			}
			stk.push(i);
		}
		if (stk.size() > 0) {
			right[stk.pop()] = 0;
		}

		System.out.print("Right: ");
		for (int i = 0; i < A.length; ++i) {
			System.out.print(right[i] + " ");
		}
		System.out.println("Left");
		for (int i = 0; i < A.length; ++i) {
			System.out.print(left[i] + " ");
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; ++i) {
			System.out.println(Math.abs(left[i] - right[i]));
			max = Math.max(max, Math.abs(left[i] - right[i]));
		}

		return max;
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = sc.nextInt();
		System.out.println(findMaxDiff(A, N));
	}
}