package gyakusou.java.management.lms.handler;

import java.util.List;
import gyakusou.java.management.lms.domain.Community;
import gyakusou.java.management.util.Prompt;

public class CommunityAddCommand implements Command {

  List<Community> communityList;

  Prompt prompt;

  public CommunityAddCommand(Prompt prompt, List<Community> list) {
    this.prompt = prompt;
    this.communityList = list;
  }
  
    @Override
    public void execute() {

      Community community = new Community();

      community.setNo(prompt.inputInt("번호? "));
      community.setId(prompt.inputString("아이디? "));
      community.setNickName(prompt.inputString("닉네임? "));
      community.setTitle(prompt.inputString("제목? "));
      community.setContents(prompt.inputString("내용? "));
      community.setBrandtag(prompt.inputString("브랜드태그? "));

      this.communityList.add(community);

      System.out.println("저장하였습니다.");
      
    }
}
