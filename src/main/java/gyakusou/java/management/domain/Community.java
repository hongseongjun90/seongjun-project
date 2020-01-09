// 프로젝트 : 취미 커뮤니티 만들기.
//
// v12-1 domain.Community

package gyakusou.java.management.domain;


public class Community {
  private int no;
  private String id;
  private String nickName;
  private String title;
  private String contents;
  private String brandtag;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((brandtag == null) ? 0 : brandtag.hashCode());
    result = prime * result + ((contents == null) ? 0 : contents.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
    result = prime * result + no;
    result = prime * result + ((title == null) ? 0 : title.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Community other = (Community) obj;
    if (brandtag == null) {
      if (other.brandtag != null)
        return false;
    } else if (!brandtag.equals(other.brandtag))
      return false;
    if (contents == null) {
      if (other.contents != null)
        return false;
    } else if (!contents.equals(other.contents))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (nickName == null) {
      if (other.nickName != null)
        return false;
    } else if (!nickName.equals(other.nickName))
      return false;
    if (no != other.no)
      return false;
    if (title == null) {
      if (other.title != null)
        return false;
    } else if (!title.equals(other.title))
      return false;
    return true;
  }

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

