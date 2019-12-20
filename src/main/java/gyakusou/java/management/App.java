// 프로젝트: 취미 커뮤니티 만들기.
// 
// v02. 배열로 정리하기.

package gyakusou.java.management;

import java.util.Scanner;

public class App {
 public static void main(String[] args) {
   Scanner keyboard = new Scanner(System.in);
   
   // 1. 커뮤니티 게시판
   
   final int SIZE = 100;
   
   String[] id = new String[SIZE];
   String[] nickName = new String[SIZE];
   String[] title = new String[SIZE];
   String[] titleContents = new String[SIZE];
   String[] contents = new String[SIZE];
   String[] brandtag = new String[SIZE];
   
   int count = 0;
   
   for (int i = 0; i < SIZE; i++) {
     
     count++;
     
     System.out.print("아이디? ");
     id[i] = keyboard.nextLine();
     
     System.out.print("닉네임? ");
     nickName[i] = keyboard.nextLine();
     
     System.out.print("제목? ");
     title[i] = keyboard.nextLine();
     
     System.out.print("제목+내용? ");
     titleContents[i] = keyboard.nextLine();
     
     System.out.print("내용? ");
     contents[i] = keyboard.nextLine();
     
     System.out.print("브랜드태그? ");
     brandtag[i] = keyboard.nextLine();
     
     System.out.print("계속 입력하시겠습니까? (Y/n) ");
     String response = keyboard.nextLine();
     if (!response.equalsIgnoreCase("y"))
       break;
     
     System.out.println();
   }
   
   keyboard.close();
   
   
   for (int i = 0; i < count; i++) {
   
   System.out.printf("%s, %s, %s, %s, %s, %s\n", 
       id[i], nickName[i], title[i], titleContents[i], contents[i], brandtag[i]);
   
   }
  
 }
}
