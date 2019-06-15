package snq;

import java.util.*;

public class KReverseInQueue {

	// Function to reverse the first K elements
	// of the Queue
	static void reverseQueueFirstKElements(Queue<Integer> queue, int k) {

		Stack<Integer> stk = new Stack<>();

		for (int i = 0; i < k; ++i) {
			stk.push(queue.peek());
			queue.remove();
		}

		while (stk.size() > 0) {
			queue.add(stk.pop());
		}

		for (int i = 0; i < queue.size() - k; ++i) {
			queue.add(queue.remove());
		}

		while (queue.size() > 0) {
			System.out.print(queue.remove() + " ");
		}
	}

	// Driver code
	public static void main(String args[]) {
		Queue<Integer> q = new LinkedList<Integer>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		for (int i = 0; i < n; i++)
			q.add(sc.nextInt());
		reverseQueueFirstKElements(q, k);
	}
}