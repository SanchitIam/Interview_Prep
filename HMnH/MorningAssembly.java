package HMnH;

import java.util.*;

public class MorningAssembly {

	public static int minMoves(int[] N) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int max = 1;
		map.put(N[0], 1);
		for (int i = 1; i < N.length; ++i) {
			map.put(N[i], map.getOrDefault(N[i]-1, 0) + 1);
			max = Math.max(max, map.get(N[i]));
		}

		return N.length - max;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 8, 1, 7, 4, 9, 5, 6, 3, 10 };

		System.out.println(minMoves(arr));
	}

}
