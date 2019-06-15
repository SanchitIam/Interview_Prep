package snq;

import java.util.*;

public class MaxRectArea {

	public static int maxArea(int[] arr) {
		int rv = Integer.MIN_VALUE;

		Stack<Integer> stk = new Stack<>();
		int[] lb = new int[arr.length];
		int[] rb = new int[arr.length];

		stk.push(0);
		lb[0] = -1;
		for (int i = 1; i < lb.length; ++i) {
			while (stk.size() > 0 && arr[stk.peek()] >= arr[i]) {
				stk.pop();
			}

			lb[i] = stk.size() > 0 ? stk.peek() : -1;

			stk.push(i);
		}

		stk = new Stack<>();
		stk.push(arr.length - 1);
		lb[0] = -1;
		for (int i = arr.length - 2; i >= 0; --i) {
			while (stk.size() > 0 && arr[stk.peek()] >= arr[i]) {
				stk.pop();
			}

			rb[i] = stk.size() > 0 ? stk.peek() : -1;

			stk.push(i);
		}

		for (int i = 0; i < arr.length; ++i) {
			rv = Math.max(rv, (rb[i] - lb[i] - 1) * arr[i]);
		}
		return rv;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 5, 6, 2, 3 };
		System.out.println(maxArea(arr));

	}

}
