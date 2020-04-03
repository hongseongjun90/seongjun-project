package seongjun.cms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import seongjun.cms.handler.Command;
import seongjun.cms.handler.CommunityAddCommand;
import seongjun.cms.handler.CommunityDeleteCommand;
import seongjun.cms.handler.CommunityDetailCommand;
import seongjun.cms.handler.CommunityListCommand;
import seongjun.cms.handler.CommunityUpdateCommand;
import seongjun.cms.handler.RaffleAddCommand;
import seongjun.cms.handler.RaffleDeleteCommand;
import seongjun.cms.handler.RaffleDetailCommand;
import seongjun.cms.handler.RaffleListCommand;
import seongjun.cms.handler.RaffleUpdateCommand;
import seongjun.cms.util.Prompt;

public class ClinetApp {

  Scanner keyboard = new Scanner(System.in);
  Prompt prompt = new Prompt(keyboard);

  public void service() {

    String serverAddr = null;
    int port = 0;

    try {
      serverAddr = prompt.inputString("서버? "); // localhost
      port = prompt.inputInt("포트? "); // 9999

    } catch (Exception e) {
      System.out.println("서버주소 또는 포트번호가 유효하지 않습니다.");
      keyboard.close();
      return;
    }

    try (Socket socket = new Socket(serverAddr, port); //
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream()); //
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

      System.out.println("서버와 연결 되었음");

      processCommand(out, in);

      System.out.println("서버와 연결을 끊었음");

    } catch (Exception e) {
      System.out.println("예외 발생: ");
      e.printStackTrace();
    }

    keyboard.close();

  }

  private void processCommand(ObjectOutputStream out, ObjectInputStream in) {

    Deque<String> commandStack = new ArrayDeque<>();
    Queue<String> commandQueue = new LinkedList<>();

    HashMap<String, Command> commandMap = new HashMap<>();

    commandMap.put("/community/list", new CommunityListCommand(out, in));
    commandMap.put("/community/add", new CommunityAddCommand(out, in, prompt));
    commandMap.put("/community/delete", new CommunityDeleteCommand(out, in, prompt));
    commandMap.put("/community/detail", new CommunityDetailCommand(out, in, prompt));
    commandMap.put("/community/update", new CommunityUpdateCommand(out, in, prompt));

    commandMap.put("/raffle/list", new RaffleListCommand(out, in));
    commandMap.put("/raffle/add", new RaffleAddCommand(out, in, prompt));
    commandMap.put("/raffle/delete", new RaffleDeleteCommand(out, in, prompt));
    commandMap.put("/raffle/detail", new RaffleDetailCommand(out, in, prompt));
    commandMap.put("/raffle/update", new RaffleUpdateCommand(out, in, prompt));

    try {
      while (true) {

        String command;
        command = prompt.inputString("\n명령> ");

        if (command.length() == 0)
          continue;

        if (command.equals("quit") || command.equals("/server/stop")) {
          out.writeUTF(command);
          out.flush();
          System.out.println("서버: " + in.readUTF());
          System.out.println("안녕!");
          break;
        } else if (command.equals("history")) {
          printCommandHistory(commandStack.iterator());
          continue;
        } else if (command.contentEquals("history2")) {
          printCommandHistory(commandQueue.iterator());
          continue;
        }

        commandStack.push(command);

        commandQueue.offer(command);

        Command commandHandler = commandMap.get(command);

        if (commandHandler != null) {
          try {
            commandHandler.execute();
          } catch (Exception e) {
            e.printStackTrace();
            System.out.printf("명령어 실행 중 오류 발생: %s\n", e.getMessage());
          }
        } else {
          System.out.println("실행할 수 없는 명령입니다.");
        }
      }
    } catch (Exception e) {
      System.out.println("프로그램 실행 중 오류 발생!");
    }

    keyboard.close();
  }

  private void printCommandHistory(Iterator<String> iterator) {
    int count = 0;
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
      count++;

      if ((count % 5) == 0) {
        String str = prompt.inputString(":");
        if (str.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
  }

  public static void main(String[] args) {
    System.out.println("클라이언트 커뮤니티 관리 시스템입니다.");

    ClinetApp app = new ClinetApp();
    app.service();
  }
}


