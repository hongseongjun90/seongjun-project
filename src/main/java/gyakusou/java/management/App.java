// 프로젝트 : 취미 커뮤니티 만들기.
//
// v11 Main

package gyakusou.java.management;

import java.util.Scanner;
import gyakusou.java.management.handler.CommunityHandler;
import gyakusou.java.management.handler.RaffleHandler;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {

    CommunityHandler communityHandler = new CommunityHandler(keyboard);
    RaffleHandler raffleHandler = new RaffleHandler(keyboard);

    String command;

    do {
      System.out.print("\n명령> ");
      command = keyboard.nextLine();

      switch (command) {

        case "/community/add":
          communityHandler.addCommunity();
          break;
        case "/community/list":
          communityHandler.listCommunity();
          break;
        case "/community/detail":
          communityHandler.detailCommunity();
          break;
        case "/community/update":
          communityHandler.updateCommunity();
          break;
        case "/community/delete":
          communityHandler.deleteCommunity();
          break;

        case "/raffle/add":
          raffleHandler.addRaffle();
          break;
        case "/raffle/list":
          raffleHandler.listRaffle();
          break;
        case "/raffle/detail":
          raffleHandler.detailRaffle();
          break; 
        case "/raffle/update":
          raffleHandler.updateRaffle();
          break;
        case "/raffle/delete":
          raffleHandler.deleteRaffle();
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