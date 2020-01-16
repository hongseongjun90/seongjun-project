# v14

##
Queue 자료구조를 구현해보고 원리의 이해와 활용

## 변경 소스

- src/main/java/com/eomcs/util/Queue.java 추가
- src/main/java/com/eomcs/lms/App.java 변경

## 실습

1. Queue 자료구조 구현

- Queue.java
  - 제네릭 적용
  
2. 사용자 입력 명령어 Queue에 보관

- App.java
  - 사용자 입력한 명령어 Queue에 보관
  
3. 사용자가 입력한 명령을 입력한 순서로 출력하는 'history2' 명령추가

- App.java
  - 명령어 내역 출력하는 printCommandHistory2() 정의
  - 'history2' 명령을 처리하는 분기문 추가
  
## 실행결과
  
명령> history2
history
/board/detail
/member/list
/lesson/add
/lesson/list
:  <== 키보드에서 ‘q’가 아닌 다른 문자키를 누른다.
/board/add
/member/list
/member/list
/board/add
/board/add
:q  <== 키보드에서 ‘q’ 키를 누른다.
명령>

```