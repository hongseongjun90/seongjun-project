// 프로젝트 : 취미 커뮤니티 만들기.
//
// v15-1 Main

package gyakusou.java.management.lms;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import gyakusou.java.management.lms.domain.Community;
import gyakusou.java.management.lms.domain.Raffle;
import gyakusou.java.management.lms.handler.CommunityHandler;
import gyakusou.java.management.lms.handler.RaffleHandler;
import gyakusou.java.management.util.Prompt;
import gyakusou.java.management.util.Queue;
import gyakusou.java.management.util.Stack;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  static Stack<String> commandStack = new Stack<>();
  static Queue<String> commandQueue = new Queue<>();

  public static void main(String[] args) {

    Prompt prompt = new Prompt(keyboard);

    LinkedList<Community> communityList = new LinkedList<>();
    CommunityHandler communityHandler = new CommunityHandler(prompt, communityList);

    ArrayList<Raffle> raffleList = new ArrayList<>();
    RaffleHandler raffleHandler = new RaffleHandler(prompt, raffleList);
    
    String command;

    do {
      System.out.print("\n명령> ");
      command = keyboard.nextLine();
      
      if (command.length() == 0)
        continue;
      
      commandStack.push(command);
      
      commandQueue.offer(command);

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
          
        case "history":
          printCommandHistory();
          break; 
        case "history2":
          printCommandHistory2();
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

  private static void printCommandHistory2() {
    Queue<String> historyQueue = commandQueue.clone();
    int count = 0;
    
    while (historyQueue.size() > 0) {
      System.out.println(historyQueue.poll());
      
      if ((++count % 5) == 0) {
        System.out.print(":");
        String str = keyboard.nextLine();
        if (str.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
    
  }

  private static void printCommandHistory() {
    Stack<String> historyStack = (Stack<String>) commandStack.clone();
    int count = 0;
    while (!historyStack.empty()) {
      System.out.println(historyStack.pop());
      count++;
      
      if ((count % 5) == 0) {
        System.out.print(":");
        String str = keyboard.nextLine();
        if (str.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
  }
}







