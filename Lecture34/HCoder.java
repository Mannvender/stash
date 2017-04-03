package Lecture34;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import Lecture33.Heap;

public class HCoder {
	Hashtable<Character, String> encoder;
	Hashtable<String, Character> decoder;

	public class Node implements Comparable<Node> {
		Integer cost;
		Character data;
		Node left;
		Node right;

		public Node(Integer cost, Character data) {
			this.cost = cost;
			this.data = data;
			this.left = null;
			this.right = null;
		}

		public Node(Node left, Node right) {
			this.data = '\0';
			this.cost = left.cost + right.cost;
			this.left = left;
			this.right = right;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

	}

	public HCoder(String feed) {
		Hashtable<Character, Integer> fmap = new Hashtable<>();
		for (int i = 0; i < feed.length(); i++) {
			if (fmap.containsKey(feed.charAt(i))) {
				Integer ov = fmap.get(feed.charAt(i));
				fmap.put(feed.charAt(i), ov + 1);
			} else {
				fmap.put(feed.charAt(i), 1);
			}
		}
		Heap<Node> minHeap = new Heap<>();
		Set<Map.Entry<Character, Integer>> fmapEntry = fmap.entrySet();
		for (Map.Entry<Character, Integer> entry : fmapEntry) {
			Node toput = new Node(entry.getValue(), entry.getKey());
			minHeap.add(toput);
		}

		// remove add step
		while (minHeap.size() != 1) {
			Node one = minHeap.remove();
			Node two = minHeap.remove();
			Node toPut = new Node(one, two);
			minHeap.add(toPut);

		}
		Node ft = minHeap.remove();
		this.encoder = new Hashtable<>();
		this.decoder = new Hashtable<>();
		this.initEncoderDecoder(ft, "");

	}

	private void initEncoderDecoder(Node node, String osf) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			this.encoder.put(node.data, osf);
			this.decoder.put(osf, node.data);
		}
		this.initEncoderDecoder(node.left, osf + "0");
		this.initEncoderDecoder(node.right, osf + "1");

	}

	public String encode(String input) {
		String rv = "";
		for (int i = 0; i < input.length(); i++) {
			rv += encoder.get(input.charAt(i));
		}

		return rv;

	}

	public String decode(String coded) {
		String rv = "";
		String adder = "";
		for (int i = 0; i < coded.length(); i++) {
			adder += coded.charAt(i);

			if (decoder.containsKey(adder)) {
				rv += decoder.get(adder);
				adder = "";
			}
		}

		return rv;

	}

}
