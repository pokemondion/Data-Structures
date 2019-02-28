package linkedlists;

public class DoublyLinkedList <E> {
	
	private class Node <E> {
		private E element;
		private Node<E> next;
		private Node <E> prev;
		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p;
			next = n;
		}
	}
	
	Node<E> head = null;
	Node<E> tail = null;
	int size;
	
	public DoublyLinkedList() {
		
	}
	
	public void addFirst(E e) {
		if (isEmpty()) {
			head = new Node<E>(e, null, null);
			tail = head;
			size ++;
		}
		else {
			head = new Node<E>(e, null, head);
			size ++;
		}
	}
	
	public void addLast(E e) {
		if (isEmpty()) {
			head = new Node<E>(e, null, null);
			tail = head;
			size ++;
		}
		else {
			tail = new Node<E>(e, tail, null);
			size ++;
		}
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
}
