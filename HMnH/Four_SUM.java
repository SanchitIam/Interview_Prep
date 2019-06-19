package HMnH;

import java.util.*;

public class Four_SUM {

	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input the head of the linked list.
	// It should return the head of the modified list.

	public static ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {

		Arrays.sort(nums);

		ArrayList<ArrayList<Integer>> rv = new ArrayList<>();
		int i = 0, j = 1;
		while (i < nums.length - 3) {
			j = i + 1;
			while (j < nums.length - 2) {

				int nt = target - nums[i] - nums[j];
				int left = j + 1;
				int right = nums.length - 1;

				while (left < right) {
					if (nums[left] + nums[right] > nt) {
						while (right >= 0 && nums[right] == nums[right - 1]) {
							right--;
						}
						right--;
					} else if (nums[left] + nums[right] < nt) {
						while (left < nums.length - 1 && nums[left] == nums[left + 1]) {
							left++;
						}
						left++;
					} else {

						ArrayList<Integer> quad = new ArrayList<>();
						quad.add(nums[i]);
						quad.add(nums[j]);
						quad.add(nums[left]);
						quad.add(nums[right]);
						rv.add(quad);

						while (right >= 0 && nums[right] == nums[right - 1]) {
							right--;
						}
						right--;
						while (left < nums.length - 1 && nums[left] == nums[left + 1]) {
							left++;
						}
						left++;
					}
				}

				while (j < nums.length - 2 && nums[j] == nums[j + 1]) {
					j++;
				}
				j++;
			}
			while (i < nums.length - 3 && nums[i] == nums[i + 1]) {
				i++;
			}
			i++;
		}

		return rv;
	}

	// -----------------------------------------------------

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int target = sc.nextInt();
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		ArrayList<ArrayList<Integer>> ans = fourSum(arr, target);

		for (ArrayList<Integer> a : ans) {
			for (int element : a) {
				System.out.print(element + ",");
			}
			System.out.println();
		}

	}

}