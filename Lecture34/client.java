package Lecture34;

public class client {

	public static void main(String[] args) {
		// String source = "sfhsj";
		// String toFind = "k";
		// System.out.println(findString(source, toFind));
		// Trie trie = new Trie();
		// trie.addWord("art");
		// trie.addWord("arts");
		// trie.addWord("as");
		// trie.addWord("stock");
		// trie.addWord("stop");
		// trie.addWord("see");
		// trie.addWord("sea");
		// trie.addWord("buy");
		// trie.addWord("bull");
		// trie.displayWords();
		//// System.out.println(trie.search("arts"));
		//// trie.removeWord("arts");
		//// System.out.println(trie.search("arts"));
		//// System.out.println(trie.search("art"));
		//// trie.removeWord("art");
		//// System.out.println(trie.search("art"));
		// trie.displayAsTree();
		HCoder hcoder = new HCoder(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbccccccccdd");
		System.out.println(hcoder.encode("acbabacaabcad"));
		System.out.println(hcoder.decode("0000100100000100001000000001010001"));

	}

	public static int findString(String source, String toFind) {

		for (int i = 0; i <= source.length() - toFind.length(); i++) {
			int j = 0;
			while (j < toFind.length()) {
				if (source.charAt(i + j) != toFind.charAt(j)) {
					break;
				}
				j++;
			}
			if (j == toFind.length()) {
				return i;
			}

		}

		return -1;

	}

}
