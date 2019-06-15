package snq;

import java.util.*;
import java.lang.*;
import java.io.*;

class KsubArrayMaxSum {
	public static void printMax(int[] arr, int k) {
		int res = 0;
		for (int i = 0; i < k; ++i) {
			res += arr[i];
		}

		int curr_res = res;
		for (int i = 0, j = k; j < arr.length; ++i, ++j) {
			curr_res += arr[j] - arr[i];
			res = Math.max(res, curr_res);
		}

		System.out.print(res);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();

			printMax(arr, k);
		}
	}
}