// 프로젝트 : 취미 커뮤니티 만들기.
//
// v12-1 handler.RaffleHandler


package gyakusou.java.management.handler;

import java.sql.Date;
import gyakusou.java.management.domain.Raffle;
import gyakusou.java.management.util.LinkedList;
import gyakusou.java.management.util.Prompt;;

public class RaffleHandler {

  LinkedList<Raffle> raffleList;

  public Prompt prompt;

  public RaffleHandler(Prompt prompt) {
    this.prompt = prompt;
    this.raffleList = new LinkedList<>();
  }

  public RaffleHandler(Prompt prompt, int capacity) {
    this.prompt = prompt;
    raffleList = new LinkedList<>();//
  }

  public void listRaffle() {
    Raffle[] arr = new Raffle[this.raffleList.size()];

    this.raffleList.toArray(arr);

    for (Raffle r : arr) {
      System.out.printf("%s, %s, %s, %s, %d, %s\n", 
          r.getNo(), r.getBrand(), r.getShoeName(), 
          r.getReleaseDate(), r.getPrice(), r.getPlaceSale());
    }
  }

  public void addRaffle() {

    Raffle raffle = new Raffle();

    raffle.setNo(prompt.inputInt("번호? "));
    raffle.setBrand(prompt.inputString("브랜드명? "));
    raffle.setShoeName(prompt.inputString("신발명? "));
    raffle.setReleaseDate(Date.valueOf(prompt.inputString("출시일? ")));
    raffle.setPrice(prompt.inputInt("가격? "));
    raffle.setPlaceSale(prompt.inputString("발매장소? "));

    this.raffleList.add(raffle);

    System.out.println("저장하였습니다.");
  }

  public void detailRaffle() {
    int index = indexOfRaffle(prompt.inputInt("번호? "));

    if (index == -1) {
      System.out.println("게시물 번호가 유효하지 않습니다.");
      return;
    }

    Raffle raffle = this.raffleList.get(index);

    System.out.printf("번호: %d\n", raffle.getNo());
    System.out.printf("브랜드명: %s\n", raffle.getBrand());
    System.out.printf("신발명: %s\n", raffle.getShoeName());
    System.out.printf("출시일: %s\n", raffle.getReleaseDate());
    System.out.printf("가격: %s\n", raffle.getPrice());
    System.out.printf("발매장소: %s\n", raffle.getPlaceSale());
  }

  public void updateRaffle() {
    int index = indexOfRaffle(prompt.inputInt("번호? "));

    if (index == -1) {
      System.out.println("게시물이 유효하지 않습니다.");
      return;
    }

    Raffle oldRaffle = this.raffleList.get(index);
    Raffle newRaffle = new Raffle();

    newRaffle.setNo(oldRaffle.getNo());

    newRaffle.setBrand(prompt.inputString(
        String.format("브랜드명(%s)? ", oldRaffle.getBrand()), 
        oldRaffle.getBrand()));

    newRaffle.setShoeName(prompt.inputString(
        String.format("신발명(%s)? ", oldRaffle.getShoeName()), 
        oldRaffle.getShoeName()));

   newRaffle.setReleaseDate(prompt.inputDate(
        String.format("출시일(%s)? ", oldRaffle.getReleaseDate()), 
        oldRaffle.getReleaseDate()));

   newRaffle.setPrice(prompt.inputInt(
        String.format("가격(%s)? ", oldRaffle.getPrice()), 
        oldRaffle.getPrice()));

    newRaffle.setPlaceSale(prompt.inputString(
        String.format("발매장소(%s)? ", oldRaffle.getPlaceSale()), 
        oldRaffle.getPlaceSale()));

    if (oldRaffle.equals(newRaffle)) {
      System.out.println("변경 취소 하였습니다.");
      return;
    } 
    this.raffleList.set(index, newRaffle);
    System.out.println(" 변경 하였습니다.");
  }


  public void deleteRaffle() {
    int index = indexOfRaffle(prompt.inputInt("번호? "));

    if (index == -1) {
      System.out.println("게시물이 유효하지 않습니다.");
      return;
    }

    this.raffleList.remove(index);

    System.out.println("게시글을 삭제했습니다.");
  }

  private int indexOfRaffle(int no) {
    for (int i = 0; i < this.raffleList.size(); i++) {
      if (this.raffleList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }

}
