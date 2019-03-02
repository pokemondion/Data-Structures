package stacks;

public class ArrayBasedStack <E> {
	
	E [] stack;
	int size;
	
	public ArrayBasedStack () {
		stack = (E[]) new Object[2];
		size = 0;
	}
	
	public void push(E e) {
		if (size == stack.length) {
			E [] newStack = (E[]) new Object[size*2];
			for (int i=0; i < size; i++) {
				newStack[i] = stack[i];
			}
			stack = newStack;
		}
		stack[size] = e;
		size++;
	}
	
	public E pop() {
		if (size == 0) {
			return null;
		}
		size --;
		E temp = stack[size];
		stack[size] = null;
		return temp;
	}
	
	public E peek() {
		if (size == 0) {
			return null;
		}
		return stack[size-1];
		
	}
}
