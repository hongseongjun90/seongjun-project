// 프로젝트 : 취미 커뮤니티 만들기.
//
// v04

package gyakusou.java.management;

import java.sql.Date;
import java.util.Scanner;

public class App4 {
  static Scanner keyboard = new Scanner(System.in);

  // 커뮤니티 게시판, 발매 및 응모 정보 게시판 통합
  
  static class Community {
    String id;
    String nickName;
    String title;
    String titleContents;
    String contents;
    String brandtag;
  }

  static final int COMMUNITY_SIZE = 100;
  static Community[] comu = new Community[COMMUNITY_SIZE];
  static int communityCount = 0;

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


  public static void main(String[] args) {

    String command;

    do {System.out.print("\n명령> ");
    command = keyboard.nextLine();

    switch (command) {

      case "/community/add":

        addCommunity();

        break;

      case "/community/list":

        listCommunity();

        break;

      case "/raffle/add":

        addRaffle();

        break;

      case "/raffle/list":

        listRaffle();

        break;

      default:
        if(!command.equalsIgnoreCase("quit")) {
          System.out.println("실행할 수 없는 명령 입니다.");
        }
    }

    } while (!command.equalsIgnoreCase("quit"));

    System.out.println("안녕!");

    keyboard.close();

  }

  static void addCommunity() {

    Community comuLow = new Community();

    System.out.print("아이디? ");
    comuLow.id = keyboard.nextLine();

    System.out.print("닉네임? ");
    comuLow.nickName = keyboard.nextLine();

    System.out.print("제목? ");
    comuLow.title = keyboard.nextLine();

    System.out.print("제목+내용? ");
    comuLow.titleContents = keyboard.nextLine();

    System.out.print("내용? ");
    comuLow.contents = keyboard.nextLine();

    System.out.print("브랜드태그? ");
    comuLow.brandtag = keyboard.nextLine();

    comu[communityCount++] = comuLow;

    System.out.println("저장하였습니다.");
  }

  static void listCommunity() {

    for (int i = 0; i < communityCount; i++) {

      Community C = comu[i];

      System.out.printf("%s, %s, %s, %s, %s, %s\n", 
          C.id, C.nickName, C.title , 
          C.titleContents, C.contents, C.brandtag);

    }
    
  }


  static void addRaffle() {

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

  static void listRaffle() {

    for (int i = 0; i < raffleCount; i++) {

      Raffle R = raf[i];

      System.out.printf("%s, %s, %s, %d, %s\n", 
          R.brand, R.shoeName, R.releaseDate, R.price, R.placeSale);
    }

  }

}