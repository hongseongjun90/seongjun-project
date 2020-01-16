// 프로젝트 : 취미 커뮤니티 만들기.
//
// v14 util.Queue

package gyakusou.java.management.util;

public class Queue<E> extends LinkedList<E> implements Cloneable {

  public void offer(E value) {
    this.add(value);
  }

  public E poll() {
    return this.remove(0);
  }

  @Override
  public Queue<E> clone() {

    Queue<E> temp = new Queue<E>();

    for (int i = 0; i < this.size; i++) {
      temp.offer(this.get(i));

    }
    return temp;
  }

}
