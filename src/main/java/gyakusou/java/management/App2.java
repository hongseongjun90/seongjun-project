// 프로젝트: 취미 커뮤니티 만들기.
//
// v02. 배열로 정리하기.

package gyakusou.java.management;

import java.util.Scanner;

public class App2 {

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    //2. Raffle 게시판
    
    final int SIZE = 100;
    
    String[] brand = new String[SIZE];
    int[] releaseMonth = new int[SIZE];
    int[] price = new int[SIZE];
    
    int count = 0;
    
    for (int i = 0; i < SIZE; i++) {
      
      count++;
      
      System.out.print("브랜드명? ");
      brand[i] = keyboard.nextLine();
      
      System.out.print("출시월? ");
      releaseMonth[i] = keyboard.nextInt();
      keyboard.nextLine();
      
      System.out.print("가격? ");
      price[i] = keyboard.nextInt();
      keyboard.nextLine();
      
      System.out.print("계속 입력하시겠습니까? (Y/n) ");
      String response = keyboard.nextLine();
      if (!response.equalsIgnoreCase("y"))
        break;
    
      System.out.println();
    
    }
      
    keyboard.close();
    
    for (int i = 0; i < count; i++) {
      
      System.out.printf("%s, %d, %s", brand[i], releaseMonth[i], price[i]);

    }
  }
}