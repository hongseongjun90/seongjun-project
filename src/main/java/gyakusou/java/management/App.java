// 프로젝트 : 취미 커뮤니티 만들기.
//
// v05

package gyakusou.java.management;

import java.util.Scanner;
import gyakusou.java.management.handler.CommunityHandler;
import gyakusou.java.management.handler.RaffleHandler;

public class App {
  static Scanner keyboard = new Scanner(System.in);

  // 커뮤니티 게시판, 발매 및 응모 정보 게시판 통합
  public static void main(String[] args) {
  
    CommunityHandler.keyboard = keyboard;
    RaffleHandler.keyboard = keyboard;
  
    String command;

    do {System.out.print("\n명령> ");
    command = keyboard.nextLine();

    switch (command) {

      case "/community/add":
        CommunityHandler.addCommunity();
        break;

      case "/community/list":
        CommunityHandler.listCommunity();
        break;

      case "/raffle/add":
        RaffleHandler.addRaffle();
        break;

      case "/raffle/list":
        RaffleHandler.listRaffle();
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

}