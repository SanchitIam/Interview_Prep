package snq;

import java.util.*;
import java.lang.*;
import java.io.*;

public class UniqueCharacter {

	public static void uniqueChar(char[] str) {
		Queue<Character> q = new LinkedList<>();
		HashMap<Character, Integer> fmap = new HashMap<>();

		for (int i = 0; i < str.length; ++i) {
			// update fmap
			if (fmap.containsKey(str[i])) {
				fmap.put(str[i], fmap.get(str[i]) + 1);
			} else {
				fmap.put(str[i], 1);
			}
			// deque
			while (q.size() > 0 && fmap.get(q.peek()) > 1) {
				q.remove();
			}

			// enque
			if (fmap.get(str[i]) == 1) {
				q.add(str[i]);
			}

			if (q.size() > 0) {
				System.out.print(q.peek() + " ");
			} else {
				System.out.print(-1 + " ");
			}

		}

	}

	// Dont make changes here
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		char ch[] = new char[n];

		for (int i = 0; i < n; i++) {
			ch[i] = sc.next().charAt(0);

		}
		uniqueChar(ch);

	}

}