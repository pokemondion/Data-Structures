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
		public E getElement() {
			return element;
		}
		public Node<E> getNext() { 
			return next;
		}
		public Node<E> getPrev() { 
			return prev;
		}
		public void setPrev(Node<E> p) {
			prev = p;
		}
		public void setNext(Node<E> n) {
			next = n;
		}
	}
	
	Node<E> head = null;
	Node<E> tail = null;
	int size;
	
	public DoublyLinkedList() {
		
	}
	
	public int size() {
		return size;
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
	
	public E first() {
		if (isEmpty()) return null;
		return head.getElement();
	}
	
	public E last() {
		if (isEmpty()) return null;
		return tail.getElement();
	}
	
	public E removeFirst() {
		if (isEmpty()) return null;
		Node<E> removed = head;
		head = head.getNext();
		head.setPrev(null);
		size --;
		if (isEmpty()) {
			tail = null;
		}
		return removed.getElement();
	}
	
	public E removeLast() {
		if (isEmpty()) return null;
		Node<E> removed = tail;
		tail = tail.getPrev();
		tail.setNext(null);
		size --;
		if (isEmpty()) {
			head = null;
		}
		return removed.getElement();
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
}
