package gyakusou.java.management.util;

public class QueueIterator<E> implements Iterator<E> {

	Queue<E> queue;

	public QueueIterator(Queue<E> queue) {
		this.queue = queue;
	}

	@Override
	public boolean hasNext() {
		return queue.size() > 0;
	}

	@Override
	public E next() {
		return queue.poll();
	}



}
