package snq;

import java.util.*;

class NearmostLeft {

	static void printNearmostLeftSmaller(int arr[], int n) {
		Stack<Integer> stk = new Stack<>();
		stk.push(arr[0]);
		System.out.print(-1 + " ");
		for (int i = 1; i < arr.length; ++i) {
			while (stk.size() > 0 && stk.peek() >= arr[i]) {
				stk.pop();
			}
			if (stk.size() > 0) {
				System.out.print(stk.peek() + " ");
			} else {
				System.out.print(-1 + " ");
			}

			stk.push(arr[i]);
		}
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		printNearmostLeftSmaller(arr, n);
	}
}