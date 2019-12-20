// 프로젝트: 취미 커뮤니티 만들기.
//
// v01. 기본데이터 만들기

package gyakusou.java.management;

import java.util.Scanner;

public class App2 {

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    //2. Raffle 게시판
    
    System.out.print("브랜드명? ");
    String brand = keyboard.nextLine();
    
    System.out.print("출시월? ");
    int releaseMonth = keyboard.nextInt();
    keyboard.nextLine();
    
    System.out.print("가격? ");
    int price = keyboard.nextInt();
    keyboard.nextLine();
    
    System.out.print("응모시작일? ");
    int startDate = keyboard.nextInt();
    
    System.out.print("응모마감일? ");
    int endDate = keyboard.nextInt();
    
    System.out.print("당첨자발표일? ");
    int announce = keyboard.nextInt();
    
    System.out.println();
    
    System.out.printf("브랜드명: %s\n", brand);
    System.out.printf("출시월: %d\n", releaseMonth);
    System.out.printf("가격: %d\n", price);
    System.out.printf("응모시작일: %d\n", startDate);
    System.out.printf("응모마감일: %d\n", endDate);
    System.out.printf("당첨자발표일: %d\n", announce);
    
    keyboard.close();

  }
}
