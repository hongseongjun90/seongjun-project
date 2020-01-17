# v14

##
일반화(generalization) 상속 기법을 사용하여 ArrayList와 LinkedList의 공통점 분리하기

## 변경 소스

- src/main/java/gyakusou/java/mangement/util/List.java 추가
- src/main/java/gyakusou/java/mangement/util/ArrayList.java 변경
- src/main/java/gyakusou/java/mangement/util/LinkedList.java 변경
- src/main/java/gyakusou/java/mangement/lms/handelr/CommunityHandler.java 변경
- src/main/java/gyakusou/java/mangement/lms/handelr/RaffleHandler.java 변경
- src/main/java/gyakusou/java/mangement/lms/App.java 변경

## 실습

o 데이터 목록을 다루는 ArrayList와 LinkedList의 공통점을 찾아 별도의 클래스로 분리하기  

- List.java
  - ArrayList와 LinkedList의 공통 멤버를 선언
  - 서브 클래스에서 반드시 재 정의 해야 하는 메서드는 추상 메서드로 구현하지 않고 놓아둔다.
  
- ArrayList.java
  - `AbstractList`를 상속 받는다.
  - 상속 받은 추상 메서드를 구현한다.

- LinkedList.java
  - `AbstractList`를 상속 받는다.
  - 상속 받은 추상 메서드를 구현한다.
  
- CommunityHandler.java
  - ArrayList 또는 LinkedList를 직접 지정하는 대신 추상클래스를 필드로 선언한다.
  - 생성자에 따라 구체적으로 구현한 서브 클래스를 공급받도록 변경한다.
  - ArrayList 또는 LinkedList에 의존하는 코드를 제거한다.
  
- RaffleHandler.java
  - ArrayList 또는 LinkedList를 직접 지정하는 대신 추상클래스를 필드로 선언한다.
  - 생성자에 따라 구체적으로 구현한 서브 클래스를 공급받도록 변경한다.
  - ArrayList 또는 LinkedList에 의존하는 코드를 제거한다.
  
- App.java
  - XxxHandler가 사용할 의존 객체를 준비한다. (AbstarctList)
  - XxxHandler를 생성할 때 해당 의존 객체를 넘겨준다.
  
  
  
  
  
  
  
  
  
  
  
  
  
