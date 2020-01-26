package gyakusou.java.management.lms.domain;

import java.sql.Date;

public class Raffle {  
  private int no;
  private String brand;
  private String shoeName; 
  private Date releaseDate; 
  private int price;
  private String placeSale;
  
  public static Raffle valueOf(String csv) {
    String[] data = csv.split(",");

    Raffle raffle = new Raffle();
    raffle.setNo(Integer.parseInt(data[0]));
    raffle.setBrand(data[1]);
    raffle.setShoeName(data[2]);
    raffle.setReleaseDate(Date.valueOf(data[3]));
    raffle.setPrice(Integer.parseInt(data[4]));
    raffle.setPlaceSale(data[5]);
    return raffle;
  }
  
  public String toCsvString() {
    return String.format("%d,%s,%s,%s,%s,%s\n", this.getNo(), this.getBrand(),
        this.getShoeName(), this.getReleaseDate(), this.getPrice(), 
        this.getPlaceSale());
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((brand == null) ? 0 : brand.hashCode());
    result = prime * result + no;
    result = prime * result + ((placeSale == null) ? 0 : placeSale.hashCode());
    result = prime * result + price;
    result = prime * result + ((releaseDate == null) ? 0 : releaseDate.hashCode());
    result = prime * result + ((shoeName == null) ? 0 : shoeName.hashCode());
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
    Raffle other = (Raffle) obj;
    if (brand == null) {
      if (other.brand != null)
        return false;
    } else if (!brand.equals(other.brand))
      return false;
    if (no != other.no)
      return false;
    if (placeSale == null) {
      if (other.placeSale != null)
        return false;
    } else if (!placeSale.equals(other.placeSale))
      return false;
    if (price != other.price)
      return false;
    if (releaseDate == null) {
      if (other.releaseDate != null)
        return false;
    } else if (!releaseDate.equals(other.releaseDate))
      return false;
    if (shoeName == null) {
      if (other.shoeName != null)
        return false;
    } else if (!shoeName.equals(other.shoeName))
      return false;
    return true;
  }

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

