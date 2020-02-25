package gyakusou.java.management.lms.handler;

import java.util.List;
import gyakusou.java.management.lms.domain.Raffle;
import gyakusou.java.management.util.Prompt;

public class RaffleDeleteCommand implements Command {

  List<Raffle> raffleList;

  public Prompt prompt;

  public RaffleDeleteCommand (final Prompt prompt, final List<Raffle> list) {
    this.prompt = prompt;
    this.raffleList = list;
  }
  
  @Override
  public void execute() {
    final int index = indexOfRaffle(prompt.inputInt("번호? "));

    if (index == -1) {
      System.out.println("게시물이 유효하지 않습니다.");
      return;
    }

    raffleList.remove(index);

    System.out.println("게시글을 삭제했습니다.");
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
