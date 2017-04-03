package Lecture30;

import java.util.*;

public class HashMapClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getHighestfreq("hhhhiiiii"));
		ArrayList<Integer> al = new ArrayList<>();
		al.add(2);
		al.add(2);
		al.add(3);
		al.add(4);
		al.add(5);
		al.add(2);
		System.out.println(al);
		System.out.println("******");
		ArrayList<Integer> bl = removeDupli(al);
		System.out.println(bl);
		int[] arr = { 2, 5, 12, 21, 17, 9, 15, 10, 13, 11 };
		Consecutive(arr);
		int[] arr1 = { 1, 1, 2, 2, 2, 3, 5 };
		int[] arr2 = { 1, 1, 1, 2, 2, 4, 5 };
		System.out.println(getCE(arr1, arr2));
		System.out.println(getI(arr1, arr2));
		int[] array = { 1, 1, 1, -1, -1, -1, -1, -1 };
		System.out.println(ZSpair(array));

	}

	public static Character getHighestfreq(String word) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < word.length(); i++) {
			Character cc = word.charAt(i);
			if (map.containsKey(cc)) {
				int temp = map.get(cc);
				map.put(cc, temp + 1);
			} else {
				map.put(cc, 1);
			}

		}
		Set<Character> keys = map.keySet();
		int maxfre = -1;
		Character save = null;

		for (Character cc : keys) {
			if (map.get(cc) > maxfre) {
				maxfre = map.get(cc);
				save = cc;
			}
		}

		return save;
	}

	public static ArrayList<Integer> removeDupli(ArrayList<Integer> list) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {

			map.put(list.get(i), 1);

		}
		Set<Integer> keys = map.keySet();
		ArrayList<Integer> rv = new ArrayList<>(keys);
		return rv;

	}

	// my try
	public static void ConsecutiveNums(int[] arr) {
		class pairs {
			boolean InOrOut;
			int lenght;
			ArrayList<Integer> al;
		}
		HashMap<Integer, pairs> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i] - 1)) {
				pairs p = new pairs();
				p.InOrOut = true;
				// finding previous length
				pairs prev = map.get(arr[i] - 1);
				int L = prev.lenght;
				p.lenght = L + 1;
				map.put(arr[i] - 1, p);
				map.put(arr[i], p);
				p.al.add(arr[i]);

			}

			else if (map.containsKey(arr[i] + 1)) {
				pairs p = new pairs();
				p.InOrOut = true;
				// finding previous length
				pairs prev = map.get(arr[i] + 1);
				int L = prev.lenght;
				p.lenght = L + 1;
				map.put(arr[i] + 1, p);
				map.put(arr[i], p);
				p.al.add(arr[i]);

			} else {
				pairs p = new pairs();
				p.InOrOut = false;
				p.lenght = 1;
				p.al.add(arr[i]);
				map.put(arr[i], p);

			}

		}
		Set<Integer> keys = map.keySet();
		int save = 0;
		for (Integer cc : keys) {

		}

	}

	public static void Consecutive(int[] arr) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i] - 1)) {
				map.put(arr[i], false);

			} else {
				map.put(arr[i], true);
			}
			if (map.containsKey(arr[i] + 1)) {
				map.put(arr[i] + 1, false);
			}

		}
		Set<Integer> keys = map.keySet();
		int maxfreq = 0;
		int maxfreqnum = 0;
		for (Integer key : keys) {
			int frq = 1;
			if (map.get(key) == true) {
				// need correction here
				while (map.containsKey(frq + key)) {
					frq++;
				}
				if (frq > maxfreq) {
					maxfreq = frq;
					maxfreqnum = key;
				}
			}
		}
		int j = maxfreqnum;
		for (int i = maxfreq; i > 0; i--) {
			System.out.println(j + ", ");
			j++;
		}

	}

	public static ArrayList<Integer> getCE(int[] arr1, int[] arr2) {
		HashMap<Integer, Boolean> map1 = new HashMap<>();
		for (int i = 0; i < arr1.length; i++) {

			map1.put(arr1[i], false);

		}
		HashMap<Integer, Boolean> map2 = new HashMap<>();
		for (int i = 0; i < arr2.length; i++) {
			if (map1.containsKey(arr2[i])) {
				map2.put(arr2[i], true);
			}

		}
		ArrayList<Integer> rv = new ArrayList<>();
		Set<Map.Entry<Integer, Boolean>> entries = map2.entrySet();
		for (Map.Entry<Integer, Boolean> entry : entries) {
			if (entry.getValue() == true) {
				rv.add(entry.getKey());
			}
		}

		return rv;
	}

	//my try
	public static ArrayList<Integer> getI(int[] arr1, int[] arr2) {
		HashMap<Integer, Integer> map1 = new HashMap<>();
		for (int i = 0; i < arr1.length; i++) {
			Integer cc = arr1[i];
			if (map1.containsKey(cc)) {
				int temp = map1.get(cc);
				map1.put(cc, temp + 1);
			} else {
				map1.put(cc, 1);
			}

		}
		HashMap<Integer, Integer> map2 = new HashMap<>();
		for (int i = 0; i < arr2.length; i++) {
			Integer cc = arr2[i];
			if (map2.containsKey(cc)) {
				int temp = map2.get(cc);
				map2.put(cc, temp + 1);
			} else {
				map2.put(cc, 1);
			}

		}
		HashMap<Integer, Integer> map3 = new HashMap<>();
		Set<Integer> keys1 = map1.keySet();
		Set<Integer> keys2 = map2.keySet();
		for (Integer keys : keys1) {
			if (map2.containsKey(keys)) {
				map3.put(keys, Math.min(map1.get(keys), map2.get(keys)));
			}
		}
		Set<Integer> keys3 = map3.keySet();
		ArrayList<Integer> rv = new ArrayList<>();
		for (Integer key : keys3) {
			for (int i = 1; i <= map3.get(key); i++) {
				rv.add(key);
			}
		}

		return rv;
	}

	//my try
	// check and handle case -- 1,1,1,-1,-1,-1,-1
	// not working properly
	public static ArrayList<String> ZSpair(int[] arr) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		ArrayList<String> rv = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(-arr[i]) && !map.get(-arr[i])) {
				map.put(arr[i], true);
				rv.add(arr[i] + ":" + -arr[i] + ";");

			} else {
				map.put(arr[i], false);
			}

		}

		return rv;
	}
}
