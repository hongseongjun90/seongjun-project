package gyakusou.java.management.lms;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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

  static List<Community> communityList = new ArrayList<>();
  static List<Raffle> raffleList = new ArrayList<>();

  public static void main(String[] args) {

    loadCommunityData();
    loadRaffleData();

    Prompt prompt = new Prompt(keyboard);
    HashMap<String, Command> commandMap = new HashMap<>();

    commandMap.put("/community/add", new CommunityAddCommand(prompt, communityList));
    commandMap.put("/community/list", new CommunityListCommand(communityList));
    commandMap.put("/community/detail", new CommunityDetailCommand(prompt, communityList));
    commandMap.put("/community/update", new CommunityUpdateCommand(prompt, communityList));
    commandMap.put("/community/delete", new CommunityDeleteCommand(prompt, communityList));

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

      if(command.equals("quit")) {
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
        try {
          commandHandler.execute();
        } catch (Exception e) {
          System.out.printf("명령어 실행 중 오류 발생: %s\n", e.getMessage());
        }
      } else {
        System.out.println("실행 할 수 없는 명령입니다.");
      }
    }

    keyboard.close();

    saveCommunityData();
    saveRaffleData();

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

  private static void loadCommunityData() {
    File file = new File("./community.ser");

    try (ObjectInputStream in = new ObjectInputStream(
        new BufferedInputStream(new FileInputStream(file)))) {
      
      int size = in.readInt();
      
      for (int i = 0; i < size; i++) {
        
        communityList.add((Community) in.readObject());
      }

      System.out.printf("총 %d 개의 커뮤니티 데이터를 로딩했습니다.\n", communityList.size());

    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
    }
  }

  private static void saveCommunityData() {
    File file = new File("./community.ser");

    try (ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(new FileOutputStream(file)))) {
      
      out.writeInt(communityList.size());
      
      for (Community community : communityList) {
        
        out.writeObject(community);
      }

      System.out.printf("총 %d 개의 커뮤니티 데이터를 저장했습니다.\n", communityList.size());

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());
    }
  }

  private static void loadRaffleData() {
    File file = new File("./raffle.ser");


    try (ObjectInputStream in = new ObjectInputStream(
        new BufferedInputStream(new FileInputStream(file)))) {
      
      int size = in.readInt();
      for (int i = 0; i < size; i++) {
        
        raffleList.add((Raffle) in.readObject());
      }
      
      System.out.printf("총 %d 개의 커뮤니티 데이터를 로딩했습니다.\n", raffleList.size());


    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
    }
  }

  private static void saveRaffleData() {
    File file = new File("./raffle.ser");

    try (ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(new FileOutputStream(file)))) {
      
      out.writeInt(raffleList.size());
      
      for (Raffle raffle : raffleList) {

        out.writeObject(raffle);
      }
      
      System.out.printf("총 %d 개의 응모 데이터를 저장했습니다.\n", raffleList.size());

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());
    }
  }
}

























