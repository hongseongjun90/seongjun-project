// 프로젝트 : 취미 커뮤니티 만들기.
//
// v11 handler.RaffleHandler

package gyakusou.java.management.handler;

import java.sql.Date;
import java.util.Scanner;
import gyakusou.java.management.domain.Raffle;
import gyakusou.java.management.util.ArrayList;;

public class RaffleHandler {

  ArrayList<Raffle> raffleList;
  Scanner input;
  
  public RaffleHandler(Scanner input) {
    this.input = input;
    raffleList = new ArrayList<>();
  }
  
  public RaffleHandler(Scanner input, int capacity) {
    this.input = input;
    raffleList = new ArrayList<>(capacity);
  }
  
  public void listRaffle() {
    Raffle[] arr = new Raffle[this.raffleList.size()];
    
    this.raffleList.toArray(arr);
    
    for (Raffle r : arr) {
      System.out.printf("%s, %s, %s, %s, %d, %s\n", 
          r.getNo(), r.getBrand(), r.getShoeName(), 
          r.getReleaseDate(), r.getPrice(), r.getPlaceSale());
    }
  }
  
  public void addRaffle() {

    Raffle raffle = new Raffle();

    System.out.print("번호? ");
    raffle.setNo(input.nextInt());

    input.nextLine(); 

    System.out.print("브랜드명? ");
    raffle.setBrand(input.nextLine());

    System.out.print("신발명? ");
    raffle.setShoeName(input.nextLine());

    System.out.print("출시일? ");
    raffle.setReleaseDate(Date.valueOf(input.next()));
    input.nextLine();

    System.out.print("가격? ");
    raffle.setPrice(input.nextInt());
    input.nextLine();

    System.out.print("발매장소? ");
    raffle.setPlaceSale(input.nextLine());

    raffleList.add(raffle);
    System.out.println("저장하였습니다.");
  }

  
  public void detailRaffle() {
    System.out.print("게시물 번호? ");
    int no = input.nextInt();
    input.nextLine();

    int index = indexOfRaffle(no);
    
    if (index == -1) {
      System.out.println("게시물 번호가 유효하지 않습니다.");
      return;
    }
    
    Raffle raffle = this.raffleList.get(index);

    System.out.printf("번호: %d\n", raffle.getNo());
    System.out.printf("브랜드명: %s\n", raffle.getBrand());
    System.out.printf("신발명: %s\n", raffle.getShoeName());
    System.out.printf("출시일: %s\n", raffle.getReleaseDate());
    System.out.printf("가격: %d\n", raffle.getPrice());
    System.out.printf("발매장소: %s\n", raffle.getPlaceSale());
  }
  
  public void updateRaffle() {
    System.out.print("번호? ");
    int no = input.nextInt();
    input.nextLine(); 
    
    int index = indexOfRaffle(no);
    
    if (index == -1) {
      System.out.println("게시물이 유효하지 않습니다.");
      return;
    }
    
    Raffle oldRaffle = this.raffleList.get(index);
    
    boolean changed = false;
    String inputStr = null;
    Raffle newRaffle = new Raffle();
    
    newRaffle.setNo(oldRaffle.getNo());
    
    System.out.printf("브랜드명(%s)? ", oldRaffle.getBrand());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newRaffle.setBrand(oldRaffle.getBrand());
    } else {
      newRaffle.setBrand(inputStr);
      changed = true;
    }
    
    System.out.printf("신발명(%s)? ", oldRaffle.getShoeName());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newRaffle.setShoeName(oldRaffle.getShoeName());
    } else {
      newRaffle.setShoeName(inputStr);
      changed = true;
    }
    
    System.out.printf("출시일(%s)? ", oldRaffle.getReleaseDate());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newRaffle.setReleaseDate(oldRaffle.getReleaseDate());
    } else {
      newRaffle.setReleaseDate(Date.valueOf(inputStr));
      changed = true;
    }
    
    System.out.printf("가격(%s)? ", oldRaffle.getPrice());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newRaffle.setPrice(oldRaffle.getPrice());
    } else {
      newRaffle.setPrice(Integer.parseInt(inputStr));
      changed = true;
    }
    
    System.out.printf("발매장소(%s)? ", oldRaffle.getPlaceSale());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newRaffle.setPlaceSale(oldRaffle.getPlaceSale());
    } else {
      newRaffle.setPlaceSale(inputStr);
      changed = true;
    }
    
    if (changed) {
      this.raffleList.set(index, newRaffle);
      System.out.println("값을 변경했습니다.");
    } else {
      System.out.println("값 변경을 취소하였습니다.");
    }
  }
    
  public void deleteRaffle() {
    System.out.print("번호? ");
    int no = input.nextInt();
    input.nextLine(); 
    
    int index = indexOfRaffle(no);
    
    if (index == -1) {
      System.out.println("게시물이 유효하지 않습니다.");
      return;
    }
    
    this.raffleList.remove(index);
    
    System.out.println("게시글을 삭제했습니다.");
  }
  
  private int indexOfRaffle(int no) {
    for (int i = 0; i < this.raffleList.size(); i++) {
      if (this.raffleList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }

}
