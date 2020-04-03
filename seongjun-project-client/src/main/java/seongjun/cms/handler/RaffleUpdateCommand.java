package seongjun.cms.handler;

import java.util.List;
import seongjun.cms.damain.Raffle;
import seongjun.cms.util.Prompt;

public class RaffleUpdateCommand implements Command {

  List<Raffle> raffleList;

  public Prompt prompt;

  public RaffleUpdateCommand(final Prompt prompt, final List<Raffle> list) {
    this.prompt = prompt;
    this.raffleList = list;
  }

  @Override
  public void execute() {
    int index = indexOfRaffle(prompt.inputInt("번호? "));

    if (index == -1) {
      System.out.println("게시물이 유효하지 않습니다.");
      return;
    }

    Raffle oldRaffle = this.raffleList.get(index);
    Raffle newRaffle = new Raffle();

    newRaffle.setNo(oldRaffle.getNo());

    newRaffle.setBrand(prompt.inputString(String.format("브랜드명(%s)? ", oldRaffle.getBrand()),
        oldRaffle.getBrand()));

    newRaffle.setShoeName(prompt.inputString(String.format("신발명(%s)? ", oldRaffle.getShoeName()),
        oldRaffle.getShoeName()));

    newRaffle.setReleaseDate(prompt.inputDate(
        String.format("출시일(%s)? ", oldRaffle.getReleaseDate()), oldRaffle.getReleaseDate()));

    newRaffle.setPrice(
        prompt.inputInt(String.format("가격(%s)? ", oldRaffle.getPrice()), oldRaffle.getPrice()));

    newRaffle.setPlaceSale(prompt.inputString(String.format("발매장소(%s)? ", oldRaffle.getPlaceSale()),
        oldRaffle.getPlaceSale()));

    if (oldRaffle.equals(newRaffle)) {
      System.out.println("변경 취소 하였습니다.");
      return;
    }
    this.raffleList.set(index, newRaffle);
    System.out.println(" 변경 하였습니다.");
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
