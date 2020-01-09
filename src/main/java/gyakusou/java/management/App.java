// 프로젝트 : 취미 커뮤니티 만들기.
//
// v12-1 Main

package gyakusou.java.management;

import java.util.Scanner;
import gyakusou.java.management.handler.CommunityHandler;
import gyakusou.java.management.handler.RaffleHandler;
import gyakusou.java.management.util.Prompt;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {
    
    Prompt prompt = new Prompt(keyboard);

    CommunityHandler communityHandler = new CommunityHandler(prompt);
    RaffleHandler raffleHandler = new RaffleHandler(prompt);

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