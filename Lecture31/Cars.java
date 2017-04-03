package Lecture31;

public class Cars implements Comparable<Cars> {
	int speed;
	int price;

	Cars(int speed, int price) {
		this.speed = speed;
		this.price = price;
	}

	@Override
	public int compareTo(Cars o) {
		// TODO Auto-generated method stub
		return this.speed - o.speed;
	}

	@Override
	public String toString() {
		return "speed = " + this.speed + ", price = " + this.price;
	}

}
