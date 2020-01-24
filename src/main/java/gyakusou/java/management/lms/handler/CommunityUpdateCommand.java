package gyakusou.java.management.lms.handler;

import java.util.List;
import gyakusou.java.management.lms.domain.Community;
import gyakusou.java.management.util.Prompt;

public class CommunityUpdateCommand implements Command {

  List<Community> communityList;

  Prompt prompt;

  public CommunityUpdateCommand(Prompt prompt, List<Community> list) {
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

    Community oldCommunity = this.communityList.get(index);
    Community newCommunity = new Community();

    newCommunity.setNo(oldCommunity.getNo());

    newCommunity.setId(prompt.inputString(
        String.format("아이디(%s)? ", oldCommunity.getId()), oldCommunity.getId()));

    newCommunity.setNickName(prompt.inputString(
        String.format("닉네임(%s)? ", oldCommunity.getNickName()), oldCommunity.getNickName()));

    newCommunity.setTitle(prompt.inputString(
        String.format("제목(%s)? ", oldCommunity.getTitle()), oldCommunity.getTitle()));

    newCommunity.setContents(prompt.inputString(
        String.format("내용(%s)? ", oldCommunity.getContents()), oldCommunity.getContents()));

    newCommunity.setBrandtag(prompt.inputString(
        String.format("브랜드태그(%s)? ", oldCommunity.getBrandtag()), oldCommunity.getBrandtag()));

    if (oldCommunity.equals(newCommunity)) {
      System.out.println("변경 취소하였습니다..");
      return;
    } 
    this.communityList.set(index, newCommunity);
    System.out.println("변경하였습니다.");
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
