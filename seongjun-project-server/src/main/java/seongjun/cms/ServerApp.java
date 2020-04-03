package seongjun.cms;

import java.io.PrintStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import seongjun.cms.context.ApplicationContextListener;
import seongjun.cms.domain.Community;
import seongjun.cms.domain.Raffle;

public class ServerApp {

  Set<ApplicationContextListener> listeners = new HashSet<>();
  Map<String, Object> context = new HashMap<>();

  public void addApplicationContextListener(ApplicationContextListener listener) {
    listeners.add(listener);
  }

  public void removeApplicaitonContextListener(ApplicationContextListener listener) {
    listeners.remove(listener);
  }

  private void notifyApplicationInitialized() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextInitialized(context);
    }
  }

  private void notifyApplicationDestroyed() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextDestroyed(context);
    }
  }

  @SuppressWarnings("unchecked")
  public void service() {

    notifyApplicationInitialized();

    List<Community> communityList = (List<Community>) context.get("communityList");
    List<Raffle> raffleList = (List<Raffle>) context.get("raffleList");

    notifyApplicationDestroyed();
  }

  public static void main(String[] args) {
    System.out.println("서버 커뮤니티 관리 시스템입니다.");

    ServerApp app = new ServerApp();
    app.addApplicationContextListener(new DataLoaderListener());
    app.service();
  }

  // try (ServerSocket serverSocket = new ServerSocket(9999)) {
  //
  // System.out.println("클라이언트 연결 대기중..");
  //
  // while (true) {
  //
  // Socket socket = serverSocket.accept();
  // System.out.println("클라이언트와 연결되었음");
  //
  // processRequest(socket);
  //
  // System.out.println("--------------END--------------");
  // }
  // } catch (Exception e) {
  // System.out.println("서버 준비 중 오류 발생");
  // return;
  // }
  // }

  static void processRequest(Socket clientSocket) {

    try (Socket socket = clientSocket; //
        Scanner in = new Scanner(socket.getInputStream()); //
        PrintStream out = new PrintStream(socket.getOutputStream())) {

      System.out.println("통신을 위한 입출력 스트림을 준비하였음");

      String message = in.nextLine();
      System.out.println("클라이언트가 보낸 메세지를 수신하였음");

      System.out.println("클라이언트: " + message);

      out.println("Hi!");
      System.out.println("클라이언트로 메세지를 전송하였음");

    } catch (Exception e) {
      System.out.println("예외 발생: ");
      e.printStackTrace();
    }
  }
}
