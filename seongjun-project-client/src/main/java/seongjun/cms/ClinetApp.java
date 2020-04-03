package seongjun.cms;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import seongjun.cms.handler.Command;
import seongjun.cms.util.Prompt;

public class ClinetApp {

  Scanner keyboard = new Scanner(System.in);
  Prompt prompt = new Prompt(keyboard);

  public void service() {

    Deque<String> commandStack = new ArrayDeque<>();
    Queue<String> commandQueue = new LinkedList<>();

    HashMap<String, Command> commandMap = new HashMap<>();

    String command;

    while (true) {
      command = prompt.inputString("\n명령> ");

      if (command.length() == 0)
        continue;

      if (command.equals("quit")) {
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

    // String serverAddr = null;
    // int port = 0;
    //
    // Scanner keyScan = new Scanner(System.in);
    //
    // try {
    // System.out.print("서버? "); // localhost
    // serverAddr = keyScan.nextLine();
    //
    // System.out.print("포트? "); // 9999
    // port = Integer.parseInt(keyScan.nextLine());
    //
    // } catch (Exception e) {
    // System.out.println("서버주소 또는 포트번호가 유효하지 않습니다.");
    // keyScan.close();
    // return;
    // }
    //
    // try (Socket socket = new Socket(serverAddr, port); //
    // PrintStream out = new PrintStream(socket.getOutputStream()); //
    // Scanner in = new Scanner(socket.getInputStream())) {
    //
    // System.out.println("서버와 연결 되었음");
    //
    // System.out.println("서버에 보낼 메세지");
    // String sendMsg = keyScan.nextLine();
    //
    // out.println(sendMsg);
    // System.out.println("서버에 메세지를 전송하였음");
    //
    // String message = in.nextLine();
    // System.out.println("서버로부터 메세지를 수신하였음");
    //
    // System.out.println("서버: " + message);
    //
    // System.out.println("서버와 연결을 끊었음");
    //
    // } catch (Exception e) {
    // System.out.println("예외 발생: ");
    // e.printStackTrace();
    // }
    //
    // keyScan.close();

  }
}


