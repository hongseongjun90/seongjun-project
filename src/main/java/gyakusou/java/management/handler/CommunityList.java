// 프로젝트 : 취미 커뮤니티 만들기.
//
// v08-1 handler.CommunityList

package gyakusou.java.management.handler;

import java.util.Arrays;
import gyakusou.java.management.domain.Community;

public class CommunityList {
  
  static final int DEFAULT_CAPACITY = 100;
  
  Community[] list;
  int size = 0;
  
  public CommunityList() {
    this.list = new Community[DEFAULT_CAPACITY];
  }
  
  public CommunityList(int capacity) {
    if (capacity < DEFAULT_CAPACITY || capacity > 10000)
      this.list = new Community[DEFAULT_CAPACITY];
    else
      this.list = new Community[capacity];
  }
  
  public Community[] toArray() {
    /*
    Community[] arr = new Community[this.size];
    for (int i = 0; i < this.size; i++) {
      arr[i] = this.list[i];
    }
    return arr;
    */
    return Arrays.copyOf(this.list, this.size);
  }
  
  public void add(Community community) {
    if (this.size == this.list.length) {                         
      int oldCapacity = this.list.length;                         
      int newCapacity = oldCapacity + (oldCapacity >> 1);        
       /*                                                     
      Community[] arr = new Community[newCapacity];                     
      for (int i = 0; i < this.list.length; i++) {              
        arr[i] = this.list[i];                                  
      }                                                         
      this.list = arr;                                          
      */
      this.list = Arrays.copyOf(this.list, newCapacity);
    }                                                           
    this.list[this.size++] = community;
  }

  public Community get(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.list[i].getNo() == no) {
        return this.list[i];
      }
    }
    return null;
  }
}
