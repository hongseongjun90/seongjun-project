package gyakusou.java.management.handler;

import gyakusou.java.management.domain.Raffle;

public class RaffleList {

  static final int DEFAULT_CAPACITY = 100;
 
  Raffle[] list;
  int size = 0;
  
  public RaffleList() {
    this.list = new Raffle[DEFAULT_CAPACITY];
  }
  
  public RaffleList(int capacity) {
    if (capacity < DEFAULT_CAPACITY || capacity > 10000)
      this.list = new Raffle[DEFAULT_CAPACITY];
    else
      this.list = new Raffle[capacity];
  }
  
  public Raffle[] toArray() {
   
    Raffle[] arr = new Raffle[this.size];
    for (int i = 0; i < this.size; i++) {
      arr[i] = this.list[i];
    }
    return arr;
  }

  public void add(Raffle raffle) {
    if (this.size == this.list.length) {                         
      int oldCapacity = this.list.length;                         
      int newCapacity = oldCapacity + (oldCapacity >> 1);                    
      Raffle[] arr = new Raffle[newCapacity];                     
      for (int i = 0; i < this.list.length; i++) {              
        arr[i] = this.list[i];                                  
      }                                                         
      this.list = arr;                                          
    }
    this.list[this.size++] = raffle;
  }
  
    public Raffle get(int no) {
      for (int i = 0; i < this.size; i++) {
        if (this.list[i].getNo() == no) {
          return this.list[i];
        }
      }
      return null;
    }
  }
