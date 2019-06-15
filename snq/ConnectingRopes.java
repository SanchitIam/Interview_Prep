package snq;

import java.util.*;
import java.lang.*;
import java.io.*;

class ConnectingRopes {
	public static long minCostRopes(long[] arr) {
		PriorityQueue<Long> q = new PriorityQueue<>();

		for (int i = 0; i < arr.length; ++i) {
			q.add(arr[i]);
		}

		Long res = new Long(0);

		while (q.size() > 1) {
			Long one = q.poll();
			Long two = q.poll();

			res += one + two;
			q.add( one + two);
		}

		return res;
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		long arr[] = new long[n];
		for (int i = 0; i < n; i++)
			arr[i] = scn.nextLong();
		System.out.println(minCostRopes(arr));

	}
}