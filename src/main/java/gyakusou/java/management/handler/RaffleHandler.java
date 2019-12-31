// 프로젝트 : 취미 커뮤니티 만들기.
//
// v06 handler.RaffleHandler

package gyakusou.java.management.handler;

import java.sql.Date;
import java.util.Scanner;
import gyakusou.java.management.domain.Raffle;;

public class RaffleHandler {

  Raffle[] raffles = new Raffle[RAFFLE_SIZE];
  int raffleCount = 0;


  static final int RAFFLE_SIZE = 100;
  public static Scanner keyboard;


  public static void addRaffle(RaffleHandler raffleHandler) {

    Raffle raffle = new Raffle();

    System.out.print("번호? ");
    raffle.setNo(keyboard.nextInt());

    keyboard.nextLine(); 

    System.out.print("브랜드명? ");
    raffle.setBrand(keyboard.nextLine());

    System.out.print("신발명? ");
    raffle.setShoeName(keyboard.nextLine());

    System.out.print("출시일? ");
    raffle.setReleaseDate(Date.valueOf(keyboard.next()));
    keyboard.nextLine();

    System.out.print("가격? ");
    raffle.setPrice(keyboard.nextInt());
    keyboard.nextLine();

    System.out.print("발매장소? ");
    raffle.setPlaceSale(keyboard.nextLine());

    raffleHandler.raffles[raffleHandler.raffleCount++] = raffle;

    System.out.println("저장하였습니다.");
  }

  public static void listRaffle(RaffleHandler raffleHandler) {

    for (int i = 0; i < raffleHandler.raffleCount; i++) {

      Raffle R = raffleHandler.raffles[i];

      System.out.printf("%s, %s, %s, %s, %d, %s\n", 
          R.getNo(), R.getBrand(), R.getShoeName(), 
          R.getReleaseDate(), R.getPrice(), R.getPlaceSale());
    }

  }
  public static void detailRaffle(RaffleHandler raffleHandler) {
    System.out.print("게시물 번호? ");
    int no = keyboard.nextInt();
    keyboard.nextLine(); // 숫자 뒤의 남은 공백 제거

    Raffle raffle = null;
    for (int i = 0; i < raffleHandler.raffleCount; i++) {
      if (raffleHandler.raffles[i].getNo() == no) {
        raffle = raffleHandler.raffles[i];
        break;
      }
    }

    if (raffle == null) {
      System.out.println("게시물 번호가 유효하지 않습니다.");
      return;
    }

    System.out.printf("번호: %d\n", raffle.getNo());
    System.out.printf("브랜드명: %s\n", raffle.getBrand());
    System.out.printf("신발명: %s\n", raffle.getShoeName());
    System.out.printf("출시일: %s\n", raffle.getReleaseDate());
    System.out.printf("가격: %d\n", raffle.getPrice());
    System.out.printf("발매장소: %s\n", raffle.getPlaceSale());
  }

}