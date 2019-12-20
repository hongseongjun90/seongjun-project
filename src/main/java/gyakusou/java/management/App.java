// 프로젝트: 취미 커뮤니티 만들기.
// 
// v02-1. 배열로 정리하기.

package gyakusou.java.management;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    // 1. 커뮤니티 게시판

    class Comunity {
      String id;
      String nickName;
      String title;
      String titleContents;
      String contents;
      String brandtag;
    }

    final int SIZE = 100;
    Comunity[] comu = new Comunity[SIZE];
    int count = 0;

    for (int i = 0; i < SIZE; i++) {
      count++;

      Comunity comuLow = new Comunity();

      System.out.print("아이디? ");
      comuLow.id = keyboard.nextLine();

      System.out.print("닉네임? ");
      comuLow.nickName = keyboard.nextLine();

      System.out.print("제목? ");
      comuLow.title = keyboard.nextLine();

      System.out.print("제목+내용? ");
      comuLow.titleContents = keyboard.nextLine();

      System.out.print("내용? ");
      comuLow.contents = keyboard.nextLine();

      System.out.print("브랜드태그? ");
      comuLow.brandtag = keyboard.nextLine();

      comu[i] = comuLow;

      System.out.print("계속 입력하시겠습니까? (Y/n) ");
      String response = keyboard.nextLine();
      if (!response.equalsIgnoreCase("y"))
        break;

      System.out.println();
    }

    keyboard.close();


    for (int i = 0; i < count; i++) {
      Comunity comuLow = comu[i];

      System.out.printf("%s, %s, %s, %s, %s, %s\n", 
          comuLow.id, comuLow.nickName, comuLow.title , 
          comuLow.titleContents, comuLow.contents, comuLow.brandtag);

    }
  }
}
