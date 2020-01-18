package gyakusou.java.management.util;

public class ListIterator<E> implements Iterator {

	List<E> list;
	int cursor;

	public ListIterator(List<E> list) {
		this.list = list;
	}

	@Override
	public boolean hasNext() {
		return cursor < list.size();
	}

	@Override
	public E next() {
		return list.get(cursor++);
	}
}
