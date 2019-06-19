package HMnH;

import java.util.*;

public class Equal_012 {

	public static void equal_012(String line) {
		int zeros = 0;
		int ones = 0;
		int twos = 0;
		HashMap<String, Integer> map = new HashMap<>();
		map.put("0*0", 1);
		int count = 0;
		for (int i = 0; i < line.length(); ++i) {
			char ch = line.charAt(i);
			if (ch == '0') {
				zeros++;
			} else if (ch == '1') {
				ones++;
			} else {
				twos++;
			}

			String val = (ones - zeros) + "*" + (twos - ones);
			count += map.getOrDefault(val, 0);
			map.put(val, map.getOrDefault(val, 0) + 1);
		}

//		for (String s : map.keySet()) {
//			if (map.get(s) != 1) {
//				count += (map.get(s) - 1);
//			}
//		}
//		System.out.println(map);
		System.out.println(count);
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		equal_012(sc.next());

	}

}