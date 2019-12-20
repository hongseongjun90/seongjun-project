// 프로젝트: 취미 커뮤니티 만들기.
//
// v02-1. 배열로 정리하기.

package gyakusou.java.management;

import java.util.Scanner;

public class App2 {

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    //2. Raffle 게시판
    
    class Raffle {
      String brand;
      int releaseMonth;
      int price;
    }
    
    final int SIZE = 100;
    Raffle[] raf = new Raffle[SIZE];
    int count = 0;
    
    for (int i = 0; i < SIZE; i++) {
      
      count++;
      
      Raffle rafLow = new Raffle();
      
      System.out.print("브랜드명? ");
      rafLow.brand = keyboard.nextLine();
      
      System.out.print("출시월? ");
      rafLow.releaseMonth = keyboard.nextInt();
      keyboard.nextLine();
      
      System.out.print("가격? ");
      rafLow.price = keyboard.nextInt();
      keyboard.nextLine();
      
      raf[i] = rafLow;
      
      System.out.print("계속 입력하시겠습니까? (Y/n) ");
      String response = keyboard.nextLine();
      if (!response.equalsIgnoreCase("y"))
        break;
    
      System.out.println();
    
    }
      
    keyboard.close();
    
    for (int i = 0; i < count; i++) {
      
      Raffle rafLow = raf[i];
      
      System.out.printf("%s, %d, %s\n", rafLow.brand, rafLow.releaseMonth, rafLow.price);

    }
  }
}