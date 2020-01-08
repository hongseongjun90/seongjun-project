// 프로젝트 : 취미 커뮤니티 만들기.
//
// v11 handler.CommunityHandler

package gyakusou.java.management.handler;

import java.util.Scanner;
import gyakusou.java.management.domain.Community;
import gyakusou.java.management.util.ArrayList;

public class CommunityHandler {

  ArrayList<Community> communityList;
  Scanner input;

  public CommunityHandler(Scanner input) {
    this.input = input;
    communityList = new ArrayList<>();
  }

  public CommunityHandler(Scanner input, int capacity) {
    this.input = input;
    communityList = new ArrayList<>(capacity);
  }

  public void listCommunity() {
    Community[] arr = new Community[this.communityList.size()];

    this.communityList.toArray(arr);

    for (Community c : arr) {
      System.out.printf("%d, %s, %s, %s, %s, %s\n", 
          c.getNo(), c.getId(), c.getNickName(), c.getTitle() , 
          c.getContents(), c.getBrandtag());
    }
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

    System.out.print("내용? ");
    community.setContents(input.nextLine());

    System.out.print("브랜드태그? ");
    community.setBrandtag(input.nextLine());

    communityList.add(community);
    System.out.println("저장하였습니다.");
  }

  public void detailCommunity() {
    System.out.print("게시물 번호? ");
    int no = input.nextInt();
    input.nextLine();

    int index = indexOfCommunity(no);

    if (index == -1) {
      System.out.println("게시물 번호가 유효하지 않습니다.");
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

  public void updateCommunity() {
    System.out.print("번호? ");
    int no = input.nextInt();
    input.nextLine(); 

    int index = indexOfCommunity(no);

    if (index == -1) {
      System.out.println("게시물이 유효하지 않습니다.");
      return;
    }

    Community oldCommunity = this.communityList.get(index);

    boolean changed = false;
    String inputStr = null;
    Community newCommunity = new Community();

    newCommunity.setNo(oldCommunity.getNo());

    System.out.printf("아이디(%s)? ", oldCommunity.getId());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newCommunity.setId(oldCommunity.getId());
    } else {
      newCommunity.setId(inputStr);
      changed = true;
    }

    System.out.printf("닉네임(%s)? ", oldCommunity.getNickName());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newCommunity.setNickName(oldCommunity.getNickName());
    } else {
      newCommunity.setNickName(inputStr);
      changed = true;
    }

    System.out.printf("제목(%s)? ", oldCommunity.getTitle());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newCommunity.setTitle(oldCommunity.getTitle());
    } else {
      newCommunity.setTitle(inputStr);
      changed = true;
    } 


    System.out.printf("내용(%s)? ", oldCommunity.getContents());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newCommunity.setContents(oldCommunity.getContents());
    } else {
      newCommunity.setContents(inputStr);
      changed = true;
    }

    System.out.printf("브랜드태그(%s)? ", oldCommunity.getBrandtag());
    inputStr = input.nextLine();
    if (inputStr.length() == 0) {
      newCommunity.setBrandtag(oldCommunity.getBrandtag());
    } else {
      newCommunity.setBrandtag(inputStr);
      changed = true;
    }

    if (changed) {
      this.communityList.set(index, newCommunity);
      System.out.println("값을 변경했습니다.");
    } else {
      System.out.println("값 변경을 취소하였습니다.");
    }
  }

  public void deleteCommunity() {
    System.out.print("번호? ");
    int no = input.nextInt();
    input.nextLine(); 

    int index = indexOfCommunity(no);

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



















