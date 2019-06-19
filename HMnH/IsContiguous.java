package HMnH;

import java.util.*;
import java.io.*;

public class IsContiguous {

	public static boolean isContiguous(int[] arr) {
		 HashSet<Integer> set = new HashSet<>();
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < arr.length; ++i) {
				max = Math.max(max, arr[i]);
				min = Math.min(min,arr[i]);
				set.add(arr[i]);
			}

		for (int i = min; i < max; ++i) {
			if (!set.contains(i))
				return false;
		}

		return true;
	}

	// Don't make changes here
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(s[i]);
		}
		boolean bl = isContiguous(num);
		System.out.println(bl);
	}
}