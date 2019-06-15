package snq;

import java.util.*;

class StackSpan {
	static class StockSpanner {
		// Complete the functions
		Stack<Integer> stk = new Stack<>();
		ArrayList<Integer> arr = new ArrayList<>();

		public StockSpanner() {
		}

		public int next(int price) {
			arr.add(price);

			if (stk.size() == 0) {
				stk.push(0);
				return 1;
			}
			while (stk.size() > 0 && arr.get(stk.peek()) <= price) {
				stk.pop();
			}
			int rv = 0;
			if (stk.size() > 0) {
				rv = arr.size() - stk.peek() - 1;
				stk.push(arr.size() - 1);
			} else {
				rv = arr.size() - 1;
				stk.push(arr.size() - 1);
			}

			return rv;
		}

	}

	// Dont make chamnges here
	public static void main(String[] args) {
		StockSpanner ss = new StockSpanner();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println(ss.next(sc.nextInt()));
		}
	}

}
