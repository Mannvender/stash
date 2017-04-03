package Lecture25;

import Lecture25.LinkedList.Node;

public class LLClient {

	public static void main(String[] args) throws Exception {
		// LinkedList list = new LinkedList();
		// // System.out.println(list.getAt(3));
		// list.addFirst(10);
		// list.addFirst(26);
		// list.addFirst(-45);
		// list.addFirst(6);
		// System.out.println(list.size);
		// System.out.println(list.isEmpty());
		// list.display();
		// System.out.println(list.getAt(3));
		// list.addLast(66);
		// list.display();
		// System.out.println(list.getLast());
		//// list.removeAt(2);
		//// list.display();
		//// list.addAt(4, 3);
		//// list.display();
		// //list.reverseDI();
		// list.addLast(666);
		// list.display();
		// System.out.println("************");
		// //list.reversePI();
		// //list.reverseDR( list.head, list.tail, 0);
		// list.display();

		LinkedList list3 = new LinkedList();
		list3.addLast(10);
		list3.addLast(20);
		list3.addLast(30);
		list3.addLast(40);
		list3.addLast(50);
		list3.addLast(60);
		list3.addLast(70);
		System.out.println("***************");
		list3.display();
		// Node prev=null;
		// Node curr=list3.head;
		// Node succ=curr.next;
		// list3.reverseDR();
		// list3.Fold();

		list3.display();
		// list3.KthNodeLast(4);
		// list3.LastNth(4);
		// list3.mid();

		System.out.println("***************");
		LinkedList list2 = new LinkedList();
		list2.addLast(25);
		list2.addLast(45);
		list2.addLast(55);
		list2.addLast(65);
		list2.addLast(75);
		list2.addLast(95);
		list2.display();
		LinkedList listprime = list2.merge(list3);
		listprime.display();
		listprime.Fold();
		listprime.display();
		listprime.MergeSortLL();
		listprime.display();
		System.out.println(listprime.find(30));

	}

}
