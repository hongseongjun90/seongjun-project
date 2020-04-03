package seongjun.cms.handler;

import java.util.Iterator;
import java.util.List;
import seongjun.cms.damain.Community;

public class CommunityListCommand implements Command {

  List<Community> communityList;

  public CommunityListCommand(List<Community> list) {
    this.communityList = list;
  }

  @Override
  public void execute() {

    Iterator<Community> iterator = communityList.iterator();

    while (iterator.hasNext()) {

      Community c = iterator.next();

      System.out.printf("%d, %s, %s, %s, %s, %s\n", c.getNo(), c.getId(), c.getNickName(),
          c.getTitle(), c.getContents(), c.getBrandtag());
    }
  }
}
