package Lecture34;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Trie {

	private class Node {
		private char data;
		boolean isTerminal;
		HashMap<Character, Node> children;

		public Node(char data, boolean bo) {
			this.data = data;
			this.isTerminal = bo;
			this.children = new HashMap<>();
		}

	}

	Node root;
	int numWords;

	public Trie() {
		this.root = new Node('\0', false);
	}

	public int NumWords() {
		return this.numWords;
	}

	public boolean isEmpty() {
		return this.numWords == 0;
	}

	public void addWord(String word) {
		this.addWord(this.root, word);
	}

	private void addWord(Node parent, String word) {
		if (word.length() == 0) {
			if (parent.isTerminal) {

			} else {
				parent.isTerminal = true;
				this.numWords++;
			}
			return;

		}

		char ch = word.charAt(0);
		String ros = word.substring(1);
		Node child = parent.children.get(ch);
		if (child == null) {
			child = new Node(ch, false);
			parent.children.put(ch, child);
		}

		this.addWord(child, ros);

	}

	public void displayWords() {
		this.displayWords(this.root, "");
	}

	private void displayWords(Node parent, String osf) {
		if (parent.isTerminal) {
			System.out.println(osf);
		}
		Set<Entry<Character, Node>> children = parent.children.entrySet();
		for (Entry<Character, Node> child : children) {
			this.displayWords(child.getValue(), osf + child.getKey());
		}

	}

	public boolean search(String word) {
		return this.search(this.root, word);
	}

	private boolean search(Node parent, String word) {
		if (word.length() == 0) {
			if (parent.isTerminal) {
				return true;
			} else {
				return false;
			}
		}

		Character ch = word.charAt(0);
		String ros = word.substring(1);
		Node children = parent.children.get(ch);
		if (children == null) {
			return false;
		} else {
			return this.search(children, ros);
		}

	}

	public void removeWord(String word) {
		this.removeWord(this.root, word);
	}

	private void removeWord(Node parent, String word) {
		if (word.length() == 0) {
			if (parent.isTerminal) {
				parent.isTerminal = false;
				this.numWords--;
			} else {

			}
			return;

		}

		Character ch = word.charAt(0);
		String ros = word.substring(1);
		Node children = parent.children.get(ch);
		if (children == null) {
			return;
		}
		this.removeWord(children, ros);

		// to save space
		if (!children.isTerminal && children.children.size() == 0) {
			parent.children.remove(ch);
		}

	}

	public void displayAsTree() {
		this.displayAsTree(this.root);
	}

	private void displayAsTree(Node parent) {
		String s = new String();
		s = s + parent.data;
		s += "=>";
		Set<Entry<Character, Node>> children = parent.children.entrySet();
		for (Entry<Character, Node> child : children) {
			s += child.getKey() + ",";
		}
		s += "END";
		System.out.println(s);

		for (Entry<Character, Node> child : children) {
			this.displayAsTree(child.getValue());
		}
	}
}
