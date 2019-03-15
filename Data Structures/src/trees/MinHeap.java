package trees;

import java.util.ArrayList;

public class MinHeap {
	
	ArrayList<Integer> minHeap = new ArrayList<>(); 
	
	public int size() {
		return minHeap.size();
	}

	public int insert(int value) {
		minHeap.add(value);
		upheap(minHeap.size()-1);
		return value;
	}
	
	public int removeMin() {
		if (minHeap.isEmpty()) {
			return -1;
		}
		int answer = minHeap.get(0);
		swap(0, minHeap.size()-1);
		minHeap.remove(minHeap.size()-1);
		downheap(0);
		return answer;
	}
	
	public int min() {
		if (minHeap.isEmpty()) {
			return -1;
		}
		return minHeap.get(0);
	}

	private void upheap(int i) {
		while (i > 0) {
			int parent = parent(i);
			if (minHeap.get(parent) <= minHeap.get(i)) {
				break;
			}
			swap(parent,i);
			i = parent;
		}
	}
	
	private void downheap(int i) {
		while (hasLeft(i)) {
			int leftChildIndex = leftChild(i);
			int smallChildIndex = leftChildIndex;
			if (hasRight(i)) {
				int rightChildIndex = rightChild(i);
				if (minHeap.get(rightChildIndex) < minHeap.get(leftChildIndex)) {
					smallChildIndex = rightChildIndex;
				}
			}
			if (minHeap.get(smallChildIndex) >= minHeap.get(i)) {
				break;
			}
			swap(smallChildIndex, i);
			i = smallChildIndex;
		}
	}

	private void swap(int val1, int val2) {
		int temp = minHeap.get(val1);
		minHeap.set(val1, minHeap.get(val2));
		minHeap.set(val2, temp);
	}

	private int parent(int i) {
		return (i-1)/2;
	}
	
	private int rightChild(int i) {
		return (2*i+2);
	}
	
	private int leftChild(int i) {
		return (2*i+1);
	}
	
	private boolean hasRight(int i) {
		if (rightChild(i) > minHeap.size()-1) {
			return false;
		}
		return true;
	}
	
	private boolean hasLeft(int i) {
		if (leftChild(i) > minHeap.size()-1) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinHeap heap = new MinHeap();
		heap.insert(5);
		heap.insert(4);
		heap.insert(10);
		heap.insert(6);
		heap.insert(7);
		heap.insert(8);
		System.out.println(heap.min());
		System.out.println(heap.removeMin());
		System.out.println(heap.removeMin());
		System.out.println(heap.removeMin());
		System.out.println(heap.removeMin());
	}

}
