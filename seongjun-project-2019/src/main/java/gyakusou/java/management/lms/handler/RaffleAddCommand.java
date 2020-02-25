package gyakusou.java.management.lms.handler;

import java.sql.Date;
import java.util.List;
import gyakusou.java.management.lms.domain.Raffle;
import gyakusou.java.management.util.Prompt;

public class RaffleAddCommand implements Command {

  List<Raffle> raffleList;

  public Prompt prompt;

  public RaffleAddCommand(final Prompt prompt, final List<Raffle> list) {
    this.prompt = prompt;
    this.raffleList = list;
  }
  
  @Override
  public void execute() {

    final Raffle raffle = new Raffle();

    raffle.setNo(prompt.inputInt("번호? "));
    raffle.setBrand(prompt.inputString("브랜드명? "));
    raffle.setShoeName(prompt.inputString("신발명? "));
    raffle.setReleaseDate(Date.valueOf(prompt.inputString("출시일? ")));
    raffle.setPrice(prompt.inputInt("가격? "));
    raffle.setPlaceSale(prompt.inputString("발매장소? "));

    raffleList.add(raffle);

    System.out.println("저장하였습니다.");
  }
  
  
  
}
