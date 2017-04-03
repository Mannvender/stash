package Lecture29;

public class BSTclient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// BST bst = new BST();
		// bst.add(50);
		// bst.add(25);
		// bst.add(75);
		// bst.add(12);
		// bst.add(37);
		// bst.add(67);
		// bst.add(89);
		// bst.display();
		// System.out.println(bst.max());
		// System.out.println(bst.min());
		// System.out.println(bst.find(67));
		// System.out.println(bst.find(32));
		BST bst = new BST(12, 25, 37, 50, 67, 75, 89);
		bst.display();
		// bst.linearize();
		// bst.display();
		// System.out.println(bst.isBalanced());
		// bst.printBw(-1, 13);
		// bst.remove(75);
		// bst.display();

	}

}
