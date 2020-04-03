package seongjun.cms.handler;

import java.util.List;
import seongjun.cms.damain.Community;
import seongjun.cms.util.Prompt;

public class CommunityDeleteCommand implements Command {

  List<Community> communityList;

  Prompt prompt;

  public CommunityDeleteCommand(Prompt prompt, List<Community> list) {
    this.prompt = prompt;
    this.communityList = list;
  }

  @Override
  public void execute() {
    int index = indexOfCommunity(prompt.inputInt("번호? "));

    if (index == -1) {
      System.out.println("게시물이 유효하지 않습니다.");
      return;
    }

    this.communityList.remove(index);

    System.out.println("게시글을 삭제했습니다.");
  }

  private int indexOfCommunity(int no) {
    for (int i = 0; i < this.communityList.size(); i++) {
      if (this.communityList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }

}
