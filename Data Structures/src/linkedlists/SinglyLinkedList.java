package linkedlists;

public class SinglyLinkedList <E> {
	
		private static class Node<E> {
			private E element;
			private Node<E> next;
			private Node(E e, Node<E> n) {
				element = e;
				next = n;
			}
			public E getElement() { 
				return element;
			}
			public Node<E> getNext() {
				return next;
			}
			public void setNode(Node<E> n) {
				next = n;
			}
		}
		
		private Node<E> head = null;
		private Node<E> tail = null;
		private int size = 0;
		public SinglyLinkedList() {
			
		}
		
		public int size() {
			return size;
		}
		public boolean isEmpty() {
			return size == 0;
		}
		public E first() {
			if (isEmpty()) return null;
			return head.getElement();
		}
		public E last() {
			if (isEmpty()) return null;
			return tail.getElement();
		}
		public void addFirst(E e) {
			head = new Node<E>(e, head);
			if (size == 0) {
				tail = head;
			}
			size++;
		}
		public void addLast(E e) {
			Node <E> newNode = new Node<>(e, null);
			if (isEmpty()) {
				head = newNode;
			}
			else {
				tail.setNode(newNode);
			}
			tail = newNode;
			size++;
		}
		public E removeFirst() {
			if(isEmpty()) return null;
			E removedElement = head.getElement();
			head = head.getNext();
			size--;
			if (size == 0) {
				tail = null;
			}
			return removedElement;
		}
		// removing at the tail is not efficient bc we have to scan through the entire list and see if the node points to null
		public E removeLast() {
			if (isEmpty()) return null;
			Node <E> current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			return current.getElement();
		}
}
