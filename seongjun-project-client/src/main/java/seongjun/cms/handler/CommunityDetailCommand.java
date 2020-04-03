package seongjun.cms.handler;

import java.util.List;
import seongjun.cms.damain.Community;
import seongjun.cms.util.Prompt;

public class CommunityDetailCommand implements Command {

  List<Community> communityList;

  Prompt prompt;

  public CommunityDetailCommand(Prompt prompt, List<Community> list) {
    this.prompt = prompt;
    this.communityList = list;
  }

  @Override
  public void execute() {
    int index = indexOfCommunity(prompt.inputInt("게시물 번호? "));

    if (index == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    Community community = this.communityList.get(index);

    System.out.printf("번호: %d\n", community.getNo());
    System.out.printf("아이디: %s\n", community.getId());
    System.out.printf("닉네임: %s\n", community.getNickName());
    System.out.printf("제목: %s\n", community.getTitle());
    System.out.printf("내용: %s\n", community.getContents());
    System.out.printf("브랜드태그: %s\n", community.getBrandtag());
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
