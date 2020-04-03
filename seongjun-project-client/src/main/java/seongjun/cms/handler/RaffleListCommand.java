package seongjun.cms.handler;

import java.util.Iterator;
import java.util.List;
import seongjun.cms.damain.Raffle;

public class RaffleListCommand implements Command {

  List<Raffle> raffleList;

  public RaffleListCommand(final List<Raffle> list) {
    this.raffleList = list;
  }

  @Override
  public void execute() {
    Iterator<Raffle> iterator = raffleList.iterator();

    while (iterator.hasNext()) {
      Raffle r = iterator.next();

      System.out.printf("%s, %s, %s, %s, %d, %s\n", r.getNo(), r.getBrand(), r.getShoeName(),
          r.getReleaseDate(), r.getPrice(), r.getPlaceSale());
    }
  }
}
