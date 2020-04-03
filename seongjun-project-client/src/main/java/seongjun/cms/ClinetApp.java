package seongjun.cms;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClinetApp {
  public static void main(String[] args) {
    System.out.println("클라이언트 커뮤니티 관리 시스템입니다.");

    String serverAddr = null;
    int port = 0;

    Scanner keyScan = new Scanner(System.in);

    try {
      System.out.print("서버? "); // localhost
      serverAddr = keyScan.nextLine();

      System.out.print("포트? "); // 9999
      port = Integer.parseInt(keyScan.nextLine());

    } catch (Exception e) {
      System.out.println("서버주소 또는 포트번호가 유효하지 않습니다.");
      keyScan.close();
      return;
    }

    try (Socket socket = new Socket(serverAddr, port); //
        PrintStream out = new PrintStream(socket.getOutputStream()); //
        Scanner in = new Scanner(socket.getInputStream())) {

      System.out.println("서버와 연결 되었음");

      System.out.println("서버에 보낼 메세지");
      String sendMsg = keyScan.nextLine();

      out.println(sendMsg);
      System.out.println("서버에 메세지를 전송하였음");

      String message = in.nextLine();
      System.out.println("서버로부터 메세지를 수신하였음");

      System.out.println("서버: " + message);

      System.out.println("서버와 연결을 끊었음");

    } catch (Exception e) {
      System.out.println("예외 발생: ");
      e.printStackTrace();
    }

    keyScan.close();

  }
}


