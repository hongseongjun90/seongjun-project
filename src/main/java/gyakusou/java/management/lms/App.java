package gyakusou.java.management.lms;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import gyakusou.java.management.lms.domain.Community;
import gyakusou.java.management.lms.domain.Raffle;
import gyakusou.java.management.lms.handler.Command;
import gyakusou.java.management.lms.handler.CommunityAddCommand;
import gyakusou.java.management.lms.handler.CommunityDeleteCommand;
import gyakusou.java.management.lms.handler.CommunityDetailCommand;
import gyakusou.java.management.lms.handler.CommunityListCommand;
import gyakusou.java.management.lms.handler.CommunityUpdateCommand;
import gyakusou.java.management.lms.handler.RaffleAddCommand;
import gyakusou.java.management.lms.handler.RaffleDeleteCommand;
import gyakusou.java.management.lms.handler.RaffleDetailCommand;
import gyakusou.java.management.lms.handler.RaffleListCommand;
import gyakusou.java.management.lms.handler.RaffleUpdateCommand;
import gyakusou.java.management.util.Prompt;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  static Deque<String> commandStack = new ArrayDeque<>();
  static Queue<String> commandQueue = new LinkedList<>();

  public static void main(String[] args) {

    Prompt prompt = new Prompt(keyboard);

    LinkedList<Community> communityList = new LinkedList<>();
    Command communityAddCommand = new CommunityAddCommand(prompt, communityList);
    Command communityListCommand = new CommunityListCommand(communityList);
    Command communityDetailCommand = new CommunityDetailCommand(prompt, communityList);
    Command communityUpdateCommand = new CommunityUpdateCommand(prompt, communityList);
    Command communityDeleteCommand = new CommunityDeleteCommand(prompt, communityList);

    ArrayList<Raffle> raffleList = new ArrayList<>();
    Command raffleAddCommand = new RaffleAddCommand(prompt, raffleList);
    Command raffleListCommand = new RaffleListCommand(raffleList);
    Command raffleDetailCommand = new RaffleDetailCommand(prompt, raffleList);
    Command raffleUpdateCommand = new RaffleUpdateCommand(prompt, raffleList);
    Command raffleDeleteCommand = new RaffleDeleteCommand(prompt, raffleList);
    

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
          communityAddCommand.execute();
          break;
        case "/community/list":
          communityListCommand.execute();
          break;
        case "/community/detail":
          communityDetailCommand.execute();
          break;
        case "/community/update":
          communityUpdateCommand.execute();
          break;
        case "/community/delete":
          communityDeleteCommand.execute();
          break;

        case "/raffle/add":
          raffleAddCommand.execute();
          break;
        case "/raffle/list":
          raffleListCommand.execute();
          break;
        case "/raffle/detail":
          raffleDetailCommand.execute();
          break; 
        case "/raffle/update":
          raffleUpdateCommand.execute();
          break;
        case "/raffle/delete":
          raffleDeleteCommand.execute();
          break; 

        case "history":
          printCommandHistory(commandStack.iterator());
          break; 
        case "history2":
          printCommandHistory(commandQueue.iterator());
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

  private static void printCommandHistory(Iterator<String> iterator) {
    int count = 0;
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
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







