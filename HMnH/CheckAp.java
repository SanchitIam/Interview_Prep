package HMnH;

import java.util.*;

public class CheckAp {

	public static boolean checkAP(int[] arr) {

		HashSet<Integer> set = new HashSet<>();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; ++i) {
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
			set.add(arr[i]);
		}

		int d = (max - min) / (arr.length - 1);

		for (int i = 1; i <= arr.length - 1; ++i) {
			if (!set.contains(min + (i * d)))
				return false;
		}

		return true;
	}

	// Don't make any changes here
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = scn.nextInt();
		}
		boolean x = checkAP(num);
		System.out.println(x);
	}
}