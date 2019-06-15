package snq;

import java.util.*;

class KillingProcess {

	public static ArrayList<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

		for (int i = 0; i < pid.size(); ++i) {
			if (!map.containsKey(pid.get(i)))
				map.put(pid.get(i), new ArrayList<>());
		}

		for (int i = 0; i < pid.size(); ++i) {
			if (ppid.get(i) != 0) {
				ArrayList<Integer> val = map.get(ppid.get(i));
				val.add(pid.get(i));
				map.put(ppid.get(i), val);
			}
		}

		Queue<Integer> q = new LinkedList<>();
		q.add(kill);
		ArrayList<Integer> rv = new ArrayList<>();

		while (q.size() > 0) {
			int val = q.remove();
			rv.add(val);
			ArrayList<Integer> children = map.get(val);
			for (int i = 0; i < children.size(); ++i) {
				q.add(children.get(i));
			}
		}

		return rv;
	}

	// Dont make changes here
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		List<Integer> pid = new ArrayList<>(n);
		List<Integer> ppid = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			pid.add(sc.nextInt());
		}
		for (int i = 0; i < n; i++) {
			ppid.add(sc.nextInt());
		}
		ArrayList<Integer> res = killProcess(pid, ppid, k);
		Collections.sort(res);
		System.out.println(res);
	}
}