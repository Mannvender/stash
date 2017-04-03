package Lecture28;

import java.util.LinkedList;
import java.util.Scanner;

import javax.security.auth.callback.TextInputCallback;

import org.w3c.dom.Node;

public class BinaryTree {
	private class Node {
		int data;
		Node left;
		Node right;

		public Node(int data, Node right, Node left) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	Node root;
	int size;

	public BinaryTree() {
		Scanner scn = new Scanner(System.in);
		this.root = this.takeInput(scn, null, false);

	}

	private Node takeInput(Scanner scn, Node parent, Boolean leftorright) {
		if (parent == null) {
			System.out.println("Enter data for root node");
		} else {
			if (leftorright) {
				System.out.println("Enter data for left child");
			} else {
				System.out.println("Enter data for right child");
			}
		}
		int cdata = scn.nextInt();
		Node child = new Node(cdata, null, null);
		this.size++;

		System.out.println("Is there a Left child for " + child.data);
		boolean choice = scn.nextBoolean();
		if (choice) {
			child.left = takeInput(scn, child, true);
		}
		System.out.println("Is there a Right child for " + child.data);
		choice = scn.nextBoolean();
		if (choice) {
			child.right = takeInput(scn, child, false);
		}

		return child;
	}

	public void display() {
		this.display(this.root);
	}

	private void display(Node node) {
		if (node.left != null) {
			System.out.print(node.left.data + " => ");
		} else {
			System.out.print("END" + "=>");
		}
		System.out.print(node.data);
		if (node.right != null) {
			System.out.print(" <= " + node.right.data);
		} else {
			System.out.print("<=" + "END");
		}
		System.out.println();
		if (node.left != null) {
			this.display(node.left);
		}
		if (node.right != null) {
			this.display(node.right);
		}
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public int size2() {
		return this.size2(this.root);
	}

	private int size2(Node node) {
		if (node == null) {
			return 0;
		}
		int lsize = this.size2(node.left);
		int rsize = this.size2(node.right);
		return lsize + rsize + 1;

	}

	public int min() {
		return this.min(this.root);
	}

	private int min(Node node) {
		if (node == null) {
			return Integer.MAX_VALUE;
		}
		int lmin = this.min(node.left);
		int rmin = this.min(node.right);
		return Math.min(node.data, Math.min(lmin, rmin));

	}

	public int max() {
		return this.max(this.root);
	}

	private int max(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}
		int lmax = this.max(node.left);
		int rmax = this.max(node.right);
		return Math.max(node.data, Math.max(lmax, rmax));

	}

	public int height() {
		return this.heigth(this.root);
	}

	private int heigth(Node node) {
		int rv = -1;
		if (node == null) {
			return -1;
		}
		int lheigth = this.heigth(node.left);
		int rheight = this.heigth(node.right);

		rv = Math.max(lheigth, rheight) + 1;
		return rv;
	}

	public boolean find(int data) {
		return this.find(data, this.root);
	}

	private boolean find(int data, Node node) {
		if (node == null) {
			return false;
		}
		if (data == node.data) {
			return true;
		}
		boolean isRigth = this.find(data, node.right);
		if (isRigth) {
			return true;
		}
		boolean isLeft = this.find(data, node.left);
		if (isLeft) {
			return true;
		}
		return false;
	}

	public void mirror() {
		this.mirror(this.root);
	}

	private void mirror(Node node) {
		if (node == null) {
			return;
		}
		mirror(node.left);
		mirror(node.right);
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;

	}

	public void preorder() {
		this.preorder(this.root);
		System.out.println("END");
	}

	private void preorder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + ",");
		this.preorder(node.left);
		this.preorder(node.right);
	}

	public void postorder() {
		this.postorder(this.root);
		System.out.println("END");
	}

	private void postorder(Node node) {
		if (node == null) {
			return;
		}

		this.postorder(node.left);
		this.postorder(node.right);
		System.out.print(node.data + ",");
	}

	public void inorder() {
		this.inorder(this.root);
		System.out.println("END");
	}

	private void inorder(Node node) {
		if (node == null) {
			return;
		}

		this.inorder(node.left);
		System.out.print(node.data + ",");
		this.inorder(node.right);

	}

	public void levelorder() {
		this.levelorder(this.root);
		System.out.println("END");
	}

	private void levelorder(Node node) {
		if (node == null) {
			return;
		}
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node temp = queue.removeFirst();
			System.out.print(temp.data + ",");
			if (temp.left != null) {
				queue.addLast(temp.left);
			}
			if (temp.right != null) {
				queue.addLast(temp.right);
			}

		}

	}

	public void preorderI() {
		this.preorderI(this.root);
		System.out.println("END");
	}

	private void preorderI(Node node) {
		if (node == null) {
			return;
		}
		LinkedList<Node> stack = new LinkedList<>();
		stack.addFirst(node);
		while (!stack.isEmpty()) {
			Node temp = stack.removeFirst();
			System.out.print(temp.data + ",");
			if (temp.right != null) {
				stack.addFirst(temp.right);
			}
			if (temp.left != null) {
				stack.addFirst(temp.left);
			}
		}
	}

	public Integer postOrderPred(int data) {
		HMoverPred mover = new HMoverPred();
		this.postOrderPred(data, this.root, mover);
		return mover.pred.data;
	}

	public Integer postOrderSucc(int data) {
		HMoverPred mover = new HMoverPred();
		this.postOrderPred(data, this.root, mover);
		return mover.succ.data;
	}

	private void postOrderPred(int data, Node node, HMoverPred mover) {
		if (node == null) {
			return;
		}
		postOrderPred(data, node.left, mover);
		postOrderPred(data, node.right, mover);
		if (mover.item == null) {
			if (node.data == data) {
				mover.item = node;
			} else {
				mover.pred = node;
			}

		} else {
			if (mover.succ == null) {
				mover.succ = node;
			}
		}

	}

	private class HMoverPred {
		Node pred;
		Node succ;
		Node item;
	}

	public BinaryTree(int[] pre, int[] in) {
		this.root = this.construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	private Node construct(int[] pre, int psi, int pei, int[] in, int isi, int iei) {
		if (isi > iei || psi > pei) {
			return null;
		}

		Node rv = new Node(pre[psi], null, null);
		this.size++;
		int si = -1;
		for (int i = isi; i <= iei; i++) {
			if (in[i] == pre[psi]) {
				si = i;
				break;
			}
		}
		int numsize = si - isi;
		rv.left = this.construct(pre, psi + 1, psi + numsize, in, isi, si - 1);
		rv.right = this.construct(pre, psi + numsize + 1, pei, in, si + 1, iei);

		return rv;

	}

	public BinaryTree(int i, int[] post, int[] in) {
		this.root = this.constructz(post, 0, post.length - 1, in, 0, in.length - 1);
	}

	private Node constructz(int[] post, int psi, int pei, int[] in, int isi, int iei) {
		if (isi > iei || psi > pei) {
			return null;
		}

		Node rv = new Node(post[pei], null, null);
		this.size++;
		int si = -1;
		for (int i = isi; i <= iei; i++) {
			if (in[i] == post[pei]) {
				si = i;
				break;
			}
		}

		int numsize = iei - si;
		rv.left = this.constructz(post, psi, psi + numsize - 1, in, isi, si - 1);
		rv.right = this.constructz(post, psi + numsize, pei - 1, in, si + 1, iei);

		return rv;

	}

	public int diameterBtr() {
		diaPair d = dia(this.root);
		return d.dia;
	}

	private class diaPair {
		int ht;
		int dia;
	}

	private diaPair dia(Node node) {
		if (node == null) {
			diaPair base = new diaPair();
			base.dia = 0;
			base.ht = -1;
			return base;
		}
		diaPair lpair = this.dia(node.left);
		diaPair rpair = this.dia(node.right);
		diaPair rv = new diaPair();
		rv.ht = Math.max(lpair.ht, rpair.ht) + 1;
		int f1 = lpair.dia;
		int f2 = rpair.dia;
		int f3 = lpair.ht + rpair.ht + 2;
		rv.dia = Math.max(f1, Math.max(f2, f3));

		return rv;
	}

	public boolean isBSTbtr() {
		tripLet rv = this.isBST(this.root);
		return rv.isBST;
	}

	private class tripLet {
		int max;
		int min;
		boolean isBST;
	}

	private tripLet isBST(Node node) {
		if (node == null) {
			tripLet base = new tripLet();
			base.max = Integer.MIN_VALUE;
			base.min = Integer.MAX_VALUE;
			base.isBST = true;
			return base;
		}

		tripLet ltrip = this.isBST(node.left);
		tripLet rtrip = this.isBST(node.right);
		tripLet rv = new tripLet();

		if (!ltrip.isBST || !rtrip.isBST || ltrip.max > node.data || rtrip.min < node.data) {
			rv.isBST = false;
		} else {
			rv.isBST = true;
		}
		rv.max = Math.max(ltrip.max, Math.max(rtrip.max, node.data));
		rv.min = Math.min(ltrip.min, Math.min(rtrip.min, node.data));

		return rv;
	}

	public boolean isBST3() {
		return this.isBST3(this.root, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}

	private boolean isBST3(Node node, int max, int min) {
		if (node == null) {
			return true;
		}
		if (node.data > max || node.data < min) {
			return false;
		}
		boolean leftGood = this.isBST3(node.left, node.data, min);
		boolean rightGood = this.isBST3(node.right, max, node.data);
		boolean rv = leftGood && rightGood;
		return rv;
	}

	public int LargestBSTsize() {
		return this.LargestBSTsize(this.root);
	}

	private int LargestBSTsize(Node node) {
		
		return size;

	}

}
