package C06EtcClass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class C0604Iterator {

  public static void main(String[] args) {
    List<String> myList = new ArrayList<>();
    myList.add("apple");
    myList.add("banana");
    myList.add("cherry");

    // enhanced for문: 원본 변경 불가
    for (String s : myList) {
      System.out.println(s);
    }

    // Iterator는 컬렉션에 대부분 내장돼있다.
    // iterator는 참조하고 있는 원본 데이터 삭제 가능
    Iterator<String> iters = myList.iterator();

    while(iters.hasNext()) {
      System.out.println(iters.next());
    }

    // iters를 이미 소모해버렸기 때문에, 재사용 불가능하다.
    Iterator<String> iters2 = myList.iterator();
    while(iters2.hasNext()) {
      if(iters2.next().equals("banana")) {
        iters2.remove();
      }
    }

    System.out.println(myList);

    // Iterator는 기억해두자!! => 웬만한 Collection은 iterator 가지고 있다.
    // 나중에 스프링 가면, 아예 return type을 iterator로 주는 경우가 있다.

  }

}
