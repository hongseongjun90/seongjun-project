package gyakusou.java.management.util;

public class StackIterator<E> implements Iterator<E> {

	Stack<E> stack;

	public StackIterator(Stack<E> stack) {
		this.stack = stack;
	}

	@Override
	public boolean hasNext() {
		return !stack.empty();
	}

	@Override
	public E next() {
		return stack.pop();
	}

}
