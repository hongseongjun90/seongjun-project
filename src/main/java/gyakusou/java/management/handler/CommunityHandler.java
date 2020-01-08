// 프로젝트 : 취미 커뮤니티 만들기.
//
// v09 handler.CommunityHandler

package gyakusou.java.management.handler;

import java.util.Scanner;
import gyakusou.java.management.domain.Community;

public class CommunityHandler {

  ArrayList communityList;
  Scanner input;
  
  public CommunityHandler(Scanner input) {
    this.input = input;
    communityList = new ArrayList();
  }
  
  public CommunityHandler(Scanner input, int capacity) {
    this.input = input;
    communityList = new ArrayList(capacity);
  }


  public void addCommunity() {

    Community community = new Community();

    System.out.print("번호? ");
    community.setNo(input.nextInt());
    input.nextLine();

    System.out.print("아이디? ");
    community.setId(input.nextLine());

    System.out.print("닉네임? ");
    community.setNickName(input.nextLine());

    System.out.print("제목? ");
    community.setTitle(input.nextLine());

    System.out.print("제목+내용? ");
    community.setTitleContents(input.nextLine());

    System.out.print("내용? ");
    community.setContents(input.nextLine());

    System.out.print("브랜드태그? ");
    community.setBrandtag(input.nextLine());

    communityList.add(community);
    System.out.println("저장하였습니다.");
  }

  public void listCommunity() {
    Object[] arr = this.communityList.toArray();
    
    for (Object obj : arr) {
      Community c = (Community) obj;
      System.out.printf("%d, %s, %s, %s, %s, %s, %s\n", 
          c.getNo(), c.getId(), c.getNickName(), c.getTitle() , 
          c.getTitleContents(), c.getContents(), c.getBrandtag());

    }

  }
  public void detailCommunity() {
    System.out.print("게시물 번호? ");
    int index = input.nextInt();
    input.nextLine(); 
    
    Community community = (Community) communityList.get(index);

    if (community == null) {
      System.out.println("게시물 번호가 유효하지 않습니다.");
      return;
    }

    System.out.printf("번호: %d\n", community.getNo());
    System.out.printf("아이디: %s\n", community.getId());
    System.out.printf("닉네임: %s\n", community.getNickName());
    System.out.printf("제목: %s\n", community.getTitle());
    System.out.printf("제목+내용: %s\n", community.getTitleContents());
    System.out.printf("내용: %s\n", community.getContents());
    System.out.printf("블로그태그: %s\n", community.getBrandtag());
  }

}