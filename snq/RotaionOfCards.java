package snq;

import java.util.*;
import java.lang.*;
import java.io.*;

public class RotaionOfCards {

	public static void cardRotation(int N) {
		int r = 1;
		Queue<Integer> q = new LinkedList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 1; i <= N; ++i) {
			q.add(i);
		}
		while (q.size() > 0) {
			// rotate
			for (int i = 0; i < r; ++i) {
				q.add(q.remove());
			}

			// pick
			int pick = q.remove();

			// put in hashmap
			map.put(pick, r);

			// increse r
			r++;
		}

		for (int i = 1; i <= N; ++i) {
			System.out.print(map.get(i) + " ");
		}

	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		cardRotation(N);
	}

}