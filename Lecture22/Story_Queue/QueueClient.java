package Lecture22.Story_Queue;

public class QueueClient {
	public static void main(String[] args) throws Exception {
		try {
			Queue qu = new Queue(5);
			for (int i = 0; i < 5; i++) {
				qu.enqueue(5 - i);
				displayQueueInfo(qu);
			}
			// System.out.println("point 1");
			// qu.enqueue(89);
			// System.out.println("point 2");
			// while (!qu.isEmpty()) {
			// System.out.println(qu.front());
			// System.out.println(qu.dequeue());
			// displayQueueInfo(qu);
			// }
			// System.out.println("point 3");
			qu.dequeue();
			displayQueueInfo(qu);
			qu.dequeue();
			displayQueueInfo(qu);
			qu.enqueue(50);
			displayQueueInfo(qu);
			qu.enqueue(40);
			displayQueueInfo(qu);
			// System.out.println("point 4");

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public static void displayQueueInfo(Queue qu) {
		System.out.println("size = " + qu.size());
		System.out.println("is it Empty ? " + qu.isEmpty());
		qu.display();
	}
}
