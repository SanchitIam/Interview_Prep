package HMnH;

import java.util.*;

public class Rabbit {

	public static int count(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; ++i) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		int count = 0;
		for (int key : map.keySet()) {
			if (key + 1 >= map.get(key)) {
				count += key + 1;
			} else {
				count += (key + 1) * Math.ceil(map.get(key) * 1.0 / (key + 1));
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 2, 2, 2, 4, 4, 4, 6, 6, 6, 3, 3, 3, 3, 3, 3, 7, 7 };
		System.out.println(count(arr));
	}

}
