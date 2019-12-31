// 프로젝트 : 취미 커뮤니티 만들기.
//
// v08-1 domain.Raffle

package gyakusou.java.management.domain;

import java.sql.Date;

public class Raffle {  
  private int no;
  private String brand;
  private String shoeName; 
  private Date releaseDate; 
  private int price;
  private String placeSale;
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getBrand() {
    return brand;
  }
  public void setBrand(String brand) {
    this.brand = brand;
  }
  public String getShoeName() {
    return shoeName;
  }
  public void setShoeName(String shoeName) {
    this.shoeName = shoeName;
  }
  public Date getReleaseDate() {
    return releaseDate;
  }
  public void setReleaseDate(Date releaseDate) {
    this.releaseDate = releaseDate;
  }
  public int getPrice() {
    return price;
  }
  public void setPrice(int price) {
    this.price = price;
  }
  public String getPlaceSale() {
    return placeSale;
  }
  public void setPlaceSale(String placeSale) {
    this.placeSale = placeSale;
  } 
  
  
}

