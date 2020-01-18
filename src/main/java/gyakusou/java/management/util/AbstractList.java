// 프로젝트 : 취미 커뮤니티 만들기.
//
// v15-2 util.AbstractList

package gyakusou.java.management.util;

public abstract class AbstractList<E> {
  protected int size;
  
  public int size() {
    return size;
  }
  
  public abstract void add(E e);
  
  public abstract void add(int index, E value);
  
  public abstract E get(int index);
  
  public abstract E remove(int index);
  
  public abstract Object[] toArray();
  
  public abstract E[] toArray(E[] arr);
  
}
