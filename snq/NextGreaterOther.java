package snq;

import java.util.*;

public class NextGreaterOther {
	public static int[] nextGreaterOther(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums1.length; ++i) {
			map.put(nums1[i], i);
		}

		int[] rv = new int[nums1.length];

		Stack<Integer> stk = new Stack<>();

		stk.push(0);

		for (int i = 1; i < nums2.length; ++i) {
			while (stk.size() > 0 && nums2[stk.peek()] < nums2[i]) {
				int pop = stk.pop();
				if (map.containsKey(nums2[pop]))
					rv[map.get(nums2[pop])] = nums2[i];
			}
			stk.push(i);
		}

		while (stk.size() > 0) {
			int pop = stk.pop();
			if (map.containsKey(nums2[pop]))
				rv[map.get(nums2[pop])] = -1;
		}

		return rv;
	}

	// Dont make changes here
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt(), n2 = sc.nextInt();
		int[] nums1 = new int[n1];
		int[] nums2 = new int[n2];
		for (int i = 0; i < n1; i++)
			nums1[i] = sc.nextInt();
		for (int i = 0; i < n2; i++)
			nums2[i] = sc.nextInt();
		int[] res = nextGreaterOther(nums1, nums2);
		for (int i = 0; i < n1; i++)
			System.out.print(res[i] + " ");
	}

}