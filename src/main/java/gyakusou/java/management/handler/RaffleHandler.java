// 프로젝트 : 취미 커뮤니티 만들기.
//
// v05

package gyakusou.java.management.handler;

import java.sql.Date;
import java.util.Scanner;

public class RaffleHandler {

  static class Raffle {  
    String brand;
    String shoeName; 
    Date releaseDate; 
    int price;
    String placeSale; 
  }

  static final int RAFFLE_SIZE = 100;
  static Raffle[] raf = new Raffle[RAFFLE_SIZE];
  static int raffleCount = 0;
  
  public static Scanner keyboard;
  
  public static void addRaffle() {

    Raffle rafLow = new Raffle();

    System.out.print("브랜드명? ");
    rafLow.brand = keyboard.nextLine();

    System.out.print("신발명? ");
    rafLow.shoeName = keyboard.nextLine();

    System.out.print("출시일? ");
    rafLow.releaseDate = Date.valueOf(keyboard.next());
    keyboard.nextLine();

    System.out.print("가격? ");
    rafLow.price = keyboard.nextInt();
    keyboard.nextLine();

    System.out.print("발매장소? ");
    rafLow.placeSale = keyboard.nextLine();

    raf[raffleCount++] = rafLow;

    System.out.println("저장하였습니다.");
  }
  
  public static void listRaffle() {

    for (int i = 0; i < raffleCount; i++) {

      Raffle R = raf[i];

      System.out.printf("%s, %s, %s, %d, %s\n", 
          R.brand, R.shoeName, R.releaseDate, R.price, R.placeSale);
    }

  }
  
}
