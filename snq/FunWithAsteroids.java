package snq;

import java.util.*;

public class FunWithAsteroids {
	public static int[] asteroidCollision(int[] asteroids) {
		// Write your code
		Stack<Integer> stk = new Stack<>();
		stk.push(asteroids[0]);
		for (int i = 1; i < asteroids.length; ++i) {
			if (stk.peek() < 0) {
				stk.push(asteroids[i]);
			} else {
				if (asteroids[i] < 0) {
					int data = stk.pop();
					if (Math.abs(data) > Math.abs(asteroids[i])) {
						stk.push(data);
					} else {
						stk.push(asteroids[i]);
					}
				} else {
					stk.push(asteroids[i]);
				}
			}
		}

		int[] rv = new int[stk.size()];
		for (int i = rv.length - 1; i >= 0; --i) {
			rv[i] = stk.pop();
		}

		return rv;
	}

	// Dont make changes
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ast[] = new int[n];
		for (int i = 0; i < n; i++)
			ast[i] = sc.nextInt();
		int res[] = asteroidCollision(ast);
		for (int v : res) {
			System.out.println(v);
		}
	}
}
