package seongjun.cms.handler;

import java.util.List;
import seongjun.cms.damain.Raffle;
import seongjun.cms.util.Prompt;

public class RaffleDetailCommand implements Command {

  List<Raffle> raffleList;

  public Prompt prompt;

  public RaffleDetailCommand(final Prompt prompt, final List<Raffle> list) {
    this.prompt = prompt;
    this.raffleList = list;
  }

  @Override
  public void execute() {
    final int index = indexOfRaffle(prompt.inputInt("번호? "));

    if (index == -1) {
      System.out.println("게시물 번호가 유효하지 않습니다.");
      return;
    }

    final Raffle raffle = raffleList.get(index);

    System.out.printf("번호: %d\n", raffle.getNo());
    System.out.printf("브랜드명: %s\n", raffle.getBrand());
    System.out.printf("신발명: %s\n", raffle.getShoeName());
    System.out.printf("출시일: %s\n", raffle.getReleaseDate());
    System.out.printf("가격: %s\n", raffle.getPrice());
    System.out.printf("발매장소: %s\n", raffle.getPlaceSale());
  }

  private int indexOfRaffle(final int no) {
    for (int i = 0; i < raffleList.size(); i++) {
      if (raffleList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}
