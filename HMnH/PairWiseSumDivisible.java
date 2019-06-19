package HMnH;

import java.util.*;

public class PairWiseSumDivisible {

	public static boolean pwSdiv(int[] arr, int k) {

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; ++i) {

			if (arr[i] >= 0) {
				int key = arr[i] % k;
				map.put(key, map.getOrDefault(key, 0) + 1);
			} else {
				int key = arr[i] % k;
				key += 7;
				map.put(key, map.getOrDefault(key, 0) + 1);
			}
		}

		if (k % 2 == 0 && map.get(k / 2) % 2 != 0) {
			return false;
		}
		if (map.getOrDefault(0, 0) % 2 != 0) {
			return false;
		}
		for (int j = 1; j < k / 2; ++j) {
			if (map.get(j) != map.get(k - j)) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		// int[] arr = { 11, 3, 8, 9, 12, 7, 4, 14, 20, 27, 16, 21, 25, 0, 28, 29, 35,
		// 10, 17, 19, -53, -3 };
		int[] arr = { 9, 15, 21, 32, 34 };

		System.out.println(pwSdiv(arr, 6));
	}

}
