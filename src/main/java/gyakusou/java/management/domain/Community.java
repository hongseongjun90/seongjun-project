// 프로젝트 : 취미 커뮤니티 만들기.
//
// v11 domain.Community

package gyakusou.java.management.domain;


public class Community {
  private int no;
  private String id;
  private String nickName;
  private String title;
  private String contents;
  private String brandtag;
  
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getNickName() {
    return nickName;
  }
  public void setNickName(String nickName) {
    this.nickName = nickName;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  
  public String getContents() {
    return contents;
  }
  public void setContents(String contents) {
    this.contents = contents;
  }
  public String getBrandtag() {
    return brandtag;
  }
  public void setBrandtag(String brandtag) {
    this.brandtag = brandtag;
  }
  
  
}

