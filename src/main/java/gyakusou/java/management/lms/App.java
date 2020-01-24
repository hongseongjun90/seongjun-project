package gyakusou.java.management.lms;

//
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
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
    HashMap<String, Command> commandMap = new HashMap<>();

    LinkedList<Community> communityList = new LinkedList<>();
    commandMap.put("/community/add", new CommunityAddCommand(prompt, communityList));
    commandMap.put("/community/list", new CommunityListCommand(communityList));
    commandMap.put("/community/detail", new CommunityDetailCommand(prompt, communityList));
    commandMap.put("/community/update", new CommunityUpdateCommand(prompt, communityList));
    commandMap.put("/community/delete", new CommunityDeleteCommand(prompt, communityList));

    ArrayList<Raffle> raffleList = new ArrayList<>();
    commandMap.put("/raffle/add", new RaffleAddCommand(prompt, raffleList));
    commandMap.put("/raffle/list", new RaffleListCommand(raffleList));
    commandMap.put("/raffle/detail", new RaffleDetailCommand(prompt, raffleList));
    commandMap.put("/raffle/update", new RaffleUpdateCommand(prompt, raffleList));
    commandMap.put("/raffle/delete", new RaffleDeleteCommand(prompt, raffleList));

    String command;

    while (true) {
      System.out.print("\n명령> ");
      command = keyboard.nextLine();

      if (command.length() == 0)
        continue;

      if(!command.equals("quit")) {
        System.out.println("안녕!");
        break;
      } else if (command.equals("history")) {
        printCommandHistory(commandStack.iterator());
        break; 
      } else if (command.equals("history2")) {
        printCommandHistory(commandQueue.iterator());
        break; 
      }

      commandStack.push(command);

      commandQueue.offer(command);

      Command commandHandler = commandMap.get(command);

      if (commandHandler != null) {
        commandHandler.execute();
      } else {
        System.out.println("안녕!");
      }
    }

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







