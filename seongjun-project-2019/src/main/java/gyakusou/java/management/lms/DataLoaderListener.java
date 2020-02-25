package gyakusou.java.management.lms;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import gyakusou.java.management.lms.context.ApplicationContextListener;
import gyakusou.java.management.lms.domain.Community;
import gyakusou.java.management.lms.domain.Raffle;

public class DataLoaderListener implements ApplicationContextListener {
  
  List<Community> communityList = new ArrayList<>();
  List<Raffle> raffleList = new ArrayList<>();
 
  @Override
  public void contextInitialized(Map<String, Object> context) {
    System.out.println("데이터를 로딩합니다.");
    
    loadCommunityData();
    loadRaffleData();
    
    context.put("communityList", communityList);
    context.put("raffleList", raffleList);

  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {
    System.out.println("데이터를 저장합니다.");
    
    saveCommunityData();
    saveRaffleData();

  }
  
  @SuppressWarnings("unchecked")
  private void loadCommunityData() {
    File file = new File("./community.ser2");

    try (ObjectInputStream in = 
        new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
        
        communityList = (List<Community>) in.readObject();

      System.out.printf("총 %d 개의 커뮤니티 데이터를 로딩했습니다.\n", communityList.size());

    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
    }
  }
  
  private void saveCommunityData() {
    File file = new File("./community.ser2");

    try (ObjectOutputStream out = 
        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      
      out.writeObject(communityList);
      
      System.out.printf("총 %d 개의 커뮤니티 데이터를 저장했습니다.\n", communityList.size());

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());
    }
  }

  @SuppressWarnings("unchecked")
  private void loadRaffleData() {
    File file = new File("./raffle.ser2");


    try (ObjectInputStream in = 
        new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      
        
        raffleList = (List<Raffle>) in.readObject();
      
      System.out.printf("총 %d 개의 커뮤니티 데이터를 로딩했습니다.\n", raffleList.size());


    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
    }
  }

  private void saveRaffleData() {
    File file = new File("./raffle.ser2");

    try (ObjectOutputStream out = 
        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      
      out.writeObject(raffleList);
      
      System.out.printf("총 %d 개의 응모 데이터를 저장했습니다.\n", raffleList.size());

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());
    }
  }
}
