package gyakusou.java.management.lms.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import gyakusou.java.management.lms.domain.Community;
import gyakusou.java.management.util.Prompt;

public class CommunityAddCommand implements Command {

  ObjectOutputStream out;
  ObjectInputStream in;

  Prompt prompt;

  public CommunityAddCommand(ObjectOutputStream out, ObjectInputStream in, Prompt prompt) {
    this.out = out;
    this.in = in;
    this.prompt = prompt;
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

    try {
      out.writeUTF("/community/add");
      out.writeObject(community);
      out.flush();

      String response = in.readUTF();
      if (response.equals("FAIL")) {
        System.out.println(in.readUTF());
        return;
      }

      System.out.println("저장하였습니다.");

    } catch (Exception e) {
      System.out.println("통신 오류 발생!");
    }
  }
}
