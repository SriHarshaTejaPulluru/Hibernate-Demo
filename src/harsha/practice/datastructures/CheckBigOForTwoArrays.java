package harsha.practice.datastructures;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CheckBigOForTwoArrays {
	private static boolean flag = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list1 = IntStream.iterate(0, i -> i + 3).limit(100000).boxed()
				.collect(Collectors.toList());
		Integer[] arr1 = new Integer[list1.size()];

		List<Integer> list2 = IntStream.iterate(0, i -> i + 5).limit(100000).boxed()
				.collect(Collectors.toList());
		Integer[] arr2 = new Integer[list2.size()];

		long t1 = System.currentTimeMillis();
		// System.out.println(nestedForLoop(arr1, arr2));
		System.out.println(twoForLoops(arr1, arr2));
		System.out.println(System.currentTimeMillis() - t1);
	}

	private static boolean twoForLoops(Integer[] arr1, Integer[] arr2) { // O(n+m) -> Avg - 13ms
		flag = false;
		HashMap<Integer, Boolean> map = new HashMap<>();
		for (int i = 0; i < arr1.length; i++) {
			map.put(arr1[i], true);
		}

		for (int j = 0; j < arr2.length; j++) {
			if (map.get(arr2[j])) {
				flag = true;// We can directly return the value but to demonstrate complexity,
							// we are just assigning value
			}
		}
		return flag;
	}

	private static boolean nestedForLoop(Integer[] arr1, Integer[] arr2) {// O(n*m) -> Avg - 2400ms

		flag = false;
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j]) {
					flag = true; // We can directly return the value but to demonstrate complexity,
									// we are just assigning value
				}
			}
		}
		return flag;
	}

}
