package heap;

import java.util.ArrayList;

public class P_Queue {
	private ArrayList<Integer> heap;

	public P_Queue() {
		heap = new ArrayList<Integer>();
	}

	boolean isEmpty() {
		return heap.size() == 0;
	}

	int size() {
		return heap.size();
	}

	int getMin() throws PriorityQException {
		if (isEmpty()) {
			throw new PriorityQException();
		}
		return heap.get(0);
	}

	// here we do upward heapify
	void insert(int data) {
		heap.add(data);
		int cindex = heap.size() - 1;
		int pindex = (cindex - 1) / 2;
		while (cindex > 0) {
			if (heap.get(cindex) < heap.get(pindex)) {
				int temp = heap.get(cindex);
				heap.set(cindex, heap.get(pindex));
				heap.set(pindex, temp);
				cindex = pindex;
				pindex = (cindex - 1) / 2;
			} else {
				return;
			}
		}
	}
// her we do down heapify 
	int remove() throws PriorityQException {
		if (heap.isEmpty()) {
			throw new PriorityQException();
		}
		int temp = heap.get(0);
		heap.set(0, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);
		int index = 0;
		int minIndex = index;
		int lindex = 1;
		int rindex = 2;
		while (lindex < heap.size()) {
			if (heap.get(lindex) < heap.get(minIndex)) {
				minIndex = lindex;
			}
			if (rindex < heap.size() && heap.get(rindex) < heap.get(minIndex)) {
				minIndex = rindex;
			}
			if (minIndex == index) {
				break;
			} else {
				int temp1 = heap.get(index);
				heap.set(index, heap.get(minIndex));
				heap.set(minIndex, temp1);
				index = minIndex;
				lindex = 2 * index + 1;
				rindex = 2 * index + 2;
			}
		}
		return temp;
	}
}
