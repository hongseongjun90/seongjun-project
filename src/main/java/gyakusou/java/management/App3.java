// 프로젝트: 취미 커뮤니티 만들기.
// 
// v03

package gyakusou.java.management;

import java.sql.Date;
import java.util.Scanner;

public class App3 {

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in); 

    // 3. 발매 정보 데이터 정보 입력

    class Raffle {  
      String brand;
      String shoeName; 
      Date releaseDate; 
      int price;
      String placeSale; 
    }

    final int RAFFLE_SIZE = 100;

    Raffle[] raf = new Raffle[RAFFLE_SIZE];

    int raffleCount = 0;

    String command;

    do {
      System.out.print("\n명령> ");
      command = keyboard.nextLine();

      switch (command) {
        case "/raffle/add":
          Raffle rafLow = new Raffle();

          System.out.print("브랜드명? ");
          rafLow.brand = keyboard.nextLine();

          System.out.print("신발명? ");
          rafLow.shoeName = keyboard.nextLine();

          System.out.print("출시일? ");
          rafLow.releaseDate = Date.valueOf(keyboard.next());
          keyboard.nextLine();

          System.out.print("가격? ");
          rafLow.price = keyboard.nextInt();
          keyboard.nextLine();

          System.out.print("발매장소? ");
          rafLow.placeSale = keyboard.nextLine();

          raf[raffleCount++] = rafLow;
          System.out.println("저장하였습니다.");

          break;

        case "/raffle/list":

          for (int i = 0; i < raffleCount; i++) {

            Raffle R = raf[i];

            System.out.printf("%s, %s, %s, %d, %s\n", 
                R.brand, R.shoeName, R.releaseDate, R.price, R.placeSale);
          }

          break;

        default:
          if (!command.equalsIgnoreCase("quit")) {
            System.out.println("실행할 수 없는 명령입니다.");
          }
      }
    } 


    while (!command.equalsIgnoreCase("quit"));

    System.out.println("Bye!");

    keyboard.close();

  }
}