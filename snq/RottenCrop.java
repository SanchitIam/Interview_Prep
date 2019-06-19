package snq;

import java.util.*;

public class RottenCrop {

	public static class Helper {
		int row;
		int col;
		int time;

		Helper(int row, int col, int time) {
			this.row = row;
			this.col = col;
			this.time = time;
		}
	}

	public static boolean isValid(int[][] arr, int r, int c) {
		if (r < 0 || r >= arr.length || c < 0 || c >= arr[0].length) {
			return false;
		}
		if (arr[r][c] == 0 || arr[r][c] == 2) {
			return false;
		}
		return true;
	}

	public static int rottenOranges(int[][] M) {
		// Write your code here
		LinkedList<Helper> queue = new LinkedList<>();
		int count = 0;
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[0].length; j++) {
				if (M[i][j] == 2) {
					Helper h = new Helper(i, j, 0);
					queue.add(h);
					count++;
				} else if (M[i][j] == 1) {
					count++;
				}
			}
		}

		int rv = 0;
		while (queue.size() > 0) {
			// remove
			Helper h = queue.remove();
			rv = h.time;
			// mark

			if (M[h.row][h.col] == 2 && h.time != 0) {
				continue;
			}
			count--;
			M[h.row][h.col] = 2;
			// work

			// add children

			M[h.row][h.col] = 2;
			// trdl
			if (isValid(M, h.row - 1, h.col)) {
				queue.add(new Helper(h.row - 1, h.col, h.time + 1));
			}
			if (isValid(M, h.row, h.col + 1)) {
				queue.add(new Helper(h.row, h.col + 1, h.time + 1));
			}
			if (isValid(M, h.row + 1, h.col)) {
				queue.add(new Helper(h.row + 1, h.col, h.time + 1));
			}
			if (isValid(M, h.row, h.col - 1)) {
				queue.add(new Helper(h.row, h.col - 1, h.time + 1));
			}
		}

		if (count != 0) {
			return -1;
		} else {
			return rv;
		}

	}	

	// Dont make changes here
	public static void main(String[] args) {
		// code
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int[][] M = new int[r][c];
		for (int i = 0; i < r; i++)
			for (int j = 0; j < M[0].length; j++)
				M[i][j] = sc.nextInt();
		System.out.println(rottenOranges(M));

	}
}
