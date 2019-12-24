// 프로젝트 : 취미 커뮤니티 만들기.
//
// v05

package gyakusou.java.management.handler;

import java.util.Scanner;

public class CommunityHandler {

  static class Community {
    String id;
    String nickName;
    String title;
    String titleContents;
    String contents;
    String brandtag;
  }
  
  static final int COMMUNITY_SIZE = 100;
  static Community[] comu = new Community[COMMUNITY_SIZE];
  static int communityCount = 0;
  
  public static Scanner keyboard;
  
  
  public static void addCommunity() {

    Community comuLow = new Community();

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

    comu[communityCount++] = comuLow;

    System.out.println("저장하였습니다.");
  }
  
  public static void listCommunity() {

    for (int i = 0; i < communityCount; i++) {

      Community C = comu[i];

      System.out.printf("%s, %s, %s, %s, %s, %s\n", 
          C.id, C.nickName, C.title , 
          C.titleContents, C.contents, C.brandtag);

    }
    
  }
  
}
