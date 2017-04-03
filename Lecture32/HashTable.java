package Lecture32;

public class HashTable<K, V> {
	private class HTPair {
		K key;
		V value;

		HTPair(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public boolean equals(Object o) {
			HTPair opair = (HTPair) o;
			return this.key.equals(opair.key);
		}

		@Override
		public String toString() {
			return "{" + this.key + ":" + this.value + "}";

		}

	}

	private LinkedList<HTPair>[] bucketArray;
	private int size;// total no. of elements
	public static final int DEFAULT_CAPACITY = 10;

	public HashTable() {
		this.bucketArray = (LinkedList<HTPair>[]) new LinkedList[DEFAULT_CAPACITY];
		this.size = 0;
	}

	public HashTable(int capacity) {
		this.bucketArray = (LinkedList<HTPair>[]) new LinkedList[capacity];
		this.size = 0;
	}

	public V get(K key) throws Exception {
		int bi = this.HashFunction(key);
		LinkedList<HTPair> bucket = this.bucketArray[bi];
		if (bucket == null) {
			return null;
		} else {
			HTPair ListPair = new HTPair(key, null);
			int FoundAt = bucket.find(ListPair);
			if (FoundAt == -1) {
				return null;

			} else {
				HTPair rv = bucket.getAt(FoundAt);
				return rv.value;
			}
		}

	}

	public V remove(K key) throws Exception {
		int bi = this.HashFunction(key);
		LinkedList<HTPair> bucket = this.bucketArray[bi];
		if (bucket == null) {
			return null;
		} else {
			HTPair ListPair = new HTPair(key, null);
			int FoundAt = bucket.find(ListPair);
			if (FoundAt == -1) {
				return null;

			} else {
				HTPair rv = bucket.getAt(FoundAt);
				bucket.removeAt(FoundAt);

				this.size--;
				return rv.value;

			}
		}

	}

	public void put(K key, V value) throws Exception {
		int bi = this.HashFunction(key);
		LinkedList<HTPair> bucket = this.bucketArray[bi];
		HTPair pta = new HTPair(key, value);
		if (bucket == null) {
			bucket = new LinkedList<>();
			bucket.addLast(pta);
			this.bucketArray[bi] = bucket;
			this.size++;
		} else {
			int FountAt = bucket.find(pta);
			if (FountAt == -1) {
				bucket.addLast(pta);
				this.size++;
			} else {
				HTPair listPair = bucket.getAt(FountAt);
				listPair.value = pta.value;
			}
		}
		double lambda = (this.size * 1.0) / this.bucketArray.length;
		if (lambda > 2) {
			this.rehash();
		}

	}

	private void rehash() throws Exception {
		// TODO Auto-generated method stub
		LinkedList<HTPair>[] oba = this.bucketArray;
		this.bucketArray = (LinkedList<HTPair>[]) new LinkedList[2 * oba.length];
		this.size = 0;
		for (LinkedList<HTPair> temp : oba) {

			while (temp != null && !temp.isEmpty()) {
				HTPair t = temp.removeFirst();
				this.put(t.key, t.value);
			}
		}

	}

	private int HashFunction(K key) {
		int i = key.hashCode();
		i = Math.abs(i);
		int bi = i % this.bucketArray.length;
		return bi;
	}

	public void display() {

		for (LinkedList<HTPair> temp : this.bucketArray) {
			if (temp == null) {
				System.out.println("NULL");
			} else {
				temp.display();
			}
		}
		System.out.println("*****************");
	}
}
