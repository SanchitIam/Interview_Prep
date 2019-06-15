package snq;

import java.util.*;

public class NGECircular {

	public static int[] nextGreaterCircularInManner(int[] nums) {
		Stack<Integer> stk = new Stack<>();

		stk.push(0);
		int[] rv = new int[nums.length];
		Arrays.fill(rv, -2);
		for (int i = 1; i < 2 * nums.length - 1; ++i) {
			int j = i % nums.length;
			while (stk.size() > 0 && nums[stk.peek()] < nums[j]) {
				int pop = stk.pop();
				if (rv[pop] == -2)
					rv[pop] = nums[j];
			}
			stk.push(j);
		}

		while (stk.size() > 0) {
			int pop = stk.pop();
			if (rv[pop] == -2)
				rv[pop] = -1;
		}

		return rv;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		int[] res = nextGreaterCircularInManner(nums);
		for (int i = 0; i < res.length; i++)
			System.out.print(res[i] + " ");
	}
}