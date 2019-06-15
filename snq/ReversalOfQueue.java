package snq;

import java.util.*;

class ReversalOfQueue {

	public static Queue<Integer> rev(Queue<Integer> q) {
		Stack<Integer> stk = new Stack<>();
		Queue<Integer> rq = new LinkedList<>();

		for (int i = 0; i < q.size(); ++i) {
			int data = q.remove();
			stk.push(data);
			q.add(data);
		}

		while (stk.size() > 0) {
			rq.add(stk.pop());
		}

		return rq;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			q.add(sc.nextInt());
		}
		Queue<Integer> res = rev(q);
		while (res.size() != 0) {
			System.out.println(res.remove() + " ");
		}
	}
}