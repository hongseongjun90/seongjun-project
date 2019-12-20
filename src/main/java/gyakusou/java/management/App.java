// 프로젝트: 취미 커뮤니티 만들기.
// 
// v01. 기본 데이터 만들기.

package gyakusou.java.management;

import java.util.Scanner;

public class App {
 public static void main(String[] args) {
   Scanner keyboard = new Scanner(System.in);
   
   // 1. 커뮤니티 게시판
   
   System.out.print("아이디? ");
   String id = keyboard.nextLine();
   
   System.out.print("닉네임? ");
   String nickName = keyboard.nextLine();
   
   System.out.print("제목? ");
   String title = keyboard.nextLine();
   
   System.out.print("제목+내용? ");
   String titleContents = keyboard.nextLine();
   
   System.out.print("내용? ");
   String contents = keyboard.nextLine();
   
   System.out.print("브랜드태그? ");
   String brandtag = keyboard.nextLine();
   
   System.out.println();
   
   System.out.printf("아이디: %s\n", id);
   System.out.printf("닉네임: %s\n", nickName);
   System.out.printf("제목: %s\n", title);
   System.out.printf("제목+내용: %s\n", titleContents);
   System.out.printf("내용: %s\n", contents);
   System.out.printf("브랜드태그: %s\n", brandtag);
   
   keyboard.close();
  
 }
}
