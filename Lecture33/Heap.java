package Lecture33;

import java.util.ArrayList;
import java.util.HashMap;

public class Heap<T extends Comparable<T>> {
	private ArrayList<T> data;
	private HashMap<T, Integer> posMap;
	private boolean isMin;

	public Heap() {
		this(false);
	}

	public Heap(boolean bo) {
		this.data = new ArrayList<>();
		this.posMap = new HashMap<>();
		this.isMin = bo;
	}

	public Heap(T[] arr, boolean isMin) {
		this(isMin);
		for (T t : arr) {
			this.data.add(t);
			this.posMap.put(t, this.data.size() - 1);
		}
		for (int i = this.data.size() / 2 - 1; i >= 0; i--) {
			this.downHeapify(i);
		}
	}

	public boolean isEmpty() {
		return this.data.isEmpty();
	}

	public T getHP() {
		T rv = this.data.get(0);
		return rv;

	}

	public int size() {
		return this.data.size();
	}

	public void add(T item) {
		this.data.add(item);
		this.posMap.put(item, this.data.size() - 1);
		this.upheapify(this.data.size() - 1);

	}

	private void upheapify(int ci) {
		if (ci == 0) {
			return;
		}
		int pi = (ci - 1) / 2;
		if (!isLarge(pi, ci)) {
			this.swap(ci, pi);
			this.upheapify(pi);
		}

	}

	// take care of i and j order ,must be in this way - i parent of j
	// this function tells if parent and child are in proper position;
	private boolean isLarge(int i, int j) {
		T parent = this.data.get(i);
		T child = this.data.get(j);
		// case of max heap
		if (!this.isMin) {
			// returns true if parent is > than child
			return parent.compareTo(child) > 0;
		} else {
			// returns true if parent < than child
			return parent.compareTo(child) < 0;
		}

	}

	private void swap(int i, int j) {
		T temp = this.data.get(j);
		this.data.set(j, this.data.get(i));
		this.data.set(i, temp);

		this.posMap.put(this.data.get(i), i);
		this.posMap.put(this.data.get(j), j);

	}

	public T remove() {
		T rv = this.data.get(0);
		this.swap(0, this.data.size() - 1);
		this.posMap.remove(this.data.get(this.data.size() - 1));
		this.data.remove(this.data.size() - 1);

		this.downHeapify(0);

		return rv;
	}

	private void downHeapify(int pi) {
		// mi= max index
		int mi = pi;
		int rci = 2 * pi + 2;
		int lci = 2 * pi + 1;
		// isLarge here tells if rci is greater than mi or not
		if (rci < this.data.size() && this.isLarge(rci, mi)) {
			mi = rci;
		}
		if (lci < this.data.size() && this.isLarge(lci, mi)) {
			mi = lci;
		}
		if (mi != pi) {
			this.swap(mi, pi);
			this.downHeapify(mi);
		}

	}

	public void display() {
		this.display(0);
	}

	private void display(int idx) {
		int lci = 2 * idx + 1;
		int rci = 2 * idx + 2;
		String str = "";

		if (lci < this.data.size()) {
			str += this.data.get(lci) + "=>";
		} else {
			str += "END =>";
		}

		str += this.data.get(idx);

		if (rci < this.data.size()) {
			str += "<=" + this.data.get(rci);
		} else {
			str += "<= END";
		}
		System.out.println(str);
		if (lci < this.data.size()) {
			this.display(lci);
		}
		if (rci < this.data.size()) {
			this.display(rci);
		}

	}

	public void updatePriority(T value) {
		int idx = this.posMap.get(value);
		int parent = (idx - 1) / 2;
		// T curr=this.data.get(idx);
		// T p=this.data.get(parent);
		if (parent >= 0) {
			if (this.isLarge(parent, idx)) {
				this.downHeapify(idx);
			} else {
				this.upheapify(idx);
			}
		}

	}

}
