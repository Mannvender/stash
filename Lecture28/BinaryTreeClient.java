package Lecture28;

public class BinaryTreeClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 50 true 25 true 12 false false true 37 false false true 75 true 62
		// false false true 87 false false
		// BinaryTree bt = new BinaryTree();
		// bt.display();
		// System.out.println(bt.size2());
		// System.out.println(bt.min());
		// System.out.println(bt.max());
		// System.out.println(bt.height());
		// //System.out.println(bt.find(5));
		// //System.out.println(bt.find(87));
		// //bt.mirror();
		// //bt.display();
		//// bt.preorder();
		//// bt.postorder();
		//// bt.inorder();
		//// bt.levelorder();
		//// bt.preorderI();
		// System.out.println(bt.postOrderPred(25));
		// System.out.println(bt.postOrderSucc(25));
		int[] pre = { 10, 20, 40, 50, 30, 60, 70 };
		int[] in = { 40, 20, 50, 10, 60, 30, 70 };
		int[] post = { 40, 50, 20, 60, 70, 30, 10 };
		BinaryTree bt = new BinaryTree(pre, in);
		bt.display();
		System.out.println(bt.diameterBtr());
		// BinaryTree bt=new BinaryTree(0, post, in);
		// bt.display();
		int[] pree = { 50, 25, 12, 49, 75, 51, 87 };
		int[] inn = { 12, 25, 49, 50, 51, 75, 87 };
		BinaryTree btt = new BinaryTree(pree, inn);
		btt.display();
		System.out.println(btt.isBSTbtr());
		System.out.println(btt.isBST3());

	}

}
