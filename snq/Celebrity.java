package snq;

import java.util.*;

class Celebrity {

	static int getId(int M[][], int n) {
		Stack<Integer> stk = new Stack<>();

		for (int i = 0; i < n; ++i) {
			stk.push(i);
		}

		while (stk.size() != 1) {
			int a = stk.pop();
			int b = stk.pop();

			if (M[a][b] == 1) {
				stk.push(b);
			} else {
				stk.push(a);
			}
		}

		int c = stk.pop();

		for (int i = 0; i < n; ++i) {
			if (i != c && (M[c][i] == 1 || M[i][c] != 1)) {
				return -1;
			}
		}

		return c;

	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		int[][] M = new int[n][n];
		for (int i = 0; i < r; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			M[x][y] = 1;
		}
		System.out.println(getId(M, n));
	}
}