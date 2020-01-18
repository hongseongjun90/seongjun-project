// 프로젝트 : 취미 커뮤니티 만들기.
//
// v15-3 util.List 

package gyakusou.java.management.util;

public interface List<E> {

	void add(E e); 

	void add(int index, E value);

	E get(int index);
	
	E set(int index, E e);

	E remove(int index);

	Object[] toArray();

	E[] toArray(E[] arr);
	
	int size();

}
