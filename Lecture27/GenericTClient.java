package Lecture27;

public class GenericTClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 10 3 20 2 50 0 60 0 30 3 70 0 80 0 90 0 40 2 100 0 110 0
		GenericTree gt = new GenericTree();
		// GenericTree gt2 = new GenericTree();
		gt.display();
		System.out.println("**************");
		// gt2.display();

		// System.out.println(gt.size());
		// System.out.println(gt.size2());
		// System.out.println(gt.heigth());
		// System.out.println(gt.max());
		// System.out.println(gt.find(40));
		// System.out.println(gt.find(45));
		// gt.mirror();
		// gt.display();
		// gt.Linear();
		// gt.display();
		// gt.preorder();
		// System.out.println("**********");
		// gt.postorder();
		// gt.levelorder();
		// gt.preorderIterative();
		// System.out.println("**************");
		gt.LinearizeTraversal();
		// gt.Linearize2();
		gt.display();
		// System.out.println(gt.getRange2());
		// System.out.println(gt.maxSONC());
		// System.out.println(gt.maxSONC2());
		// System.out.println(gt.justMax(600));
		// System.out.println(gt.justMin(600));
		// System.out.println(gt.SecondLargest());
		// System.out.println(gt.LeafCount());
		// gt.ReplaceNodeWithDeapth();
		// gt.display();
		// System.out.println(gt.AreTheyIdentical(gt2));

	}

}
