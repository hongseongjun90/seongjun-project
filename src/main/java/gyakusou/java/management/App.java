// 프로젝트 : 취미 커뮤니티 만들기.
//
// v06 App

package gyakusou.java.management;

import java.util.Scanner;
import gyakusou.java.management.handler.CommunityHandler;
import gyakusou.java.management.handler.RaffleHandler;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {

    CommunityHandler.keyboard = keyboard;
    RaffleHandler.keyboard = keyboard;

    CommunityHandler communityHandler = new CommunityHandler();

    RaffleHandler raffleHandler = new RaffleHandler();

    String command;


    do {System.out.print("\n명령> ");
    command = keyboard.nextLine();

    switch (command) {

      case "/community/add":
        CommunityHandler.addCommunity(communityHandler);
        break;

      case "/community/list":
        CommunityHandler.listCommunity(communityHandler);
        break;

      case "/community/detail":
        CommunityHandler.detailCommunity(communityHandler);
        break;

      case "/raffle/add":
        RaffleHandler.addRaffle(raffleHandler);
        break;

      case "/raffle/list":
        RaffleHandler.listRaffle(raffleHandler);
        break;

      case "/raffle/detail":
        RaffleHandler.detailRaffle(raffleHandler);
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