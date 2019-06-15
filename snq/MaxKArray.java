package snq;

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void printMax(int[] arr, int k) {
		Deque<Integer> q = new LinkedList<>();

		for (int i = 0; i < k; ++i) {
			while (q.size() > 0 && arr[i] >= arr[q.peekLast()]) {
				q.removeLast();
			}

			q.addLast(i);
		}

		for (int i = k; i < arr.length; ++i) {

			System.out.print(arr[q.peek()] + " ");

			while (q.size() > 0 && q.peek() <= i - k) {
				q.removeFirst();
			}

			while (q.size() > 0 && arr[i] >= arr[q.peekLast()]) {
				q.removeLast();
			}

			q.addLast(i);

		}

		System.out.println(arr[q.peek()] + " ");
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