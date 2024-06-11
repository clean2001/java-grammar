package C01Basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class C09Map {
  public static void main(String[] args) {
//    Map<String, String> myMap = new HashMap<>();
//    myMap.put("basketball", "농구");
//    myMap.put("baseball", "야구");
//    myMap.put("soccer", "축구");
//    System.out.println(myMap);
//
//    System.out.println(myMap.get("soccer")); // 축구
////    System.out.println(myMap.get("get"));
//
//    // 중복이 없다.
//    myMap.put("baseball", "크리켓"); // 덮어쓰기 됨
//    System.out.println(myMap.get("baseball")); // 크리켓
//
//    // 삭제
//    myMap.remove("baseball");
//    System.out.println(myMap);
//
//    myMap.putIfAbsent("basketball", "배구"); // 비어있으면 put 하겠다.
//    System.out.println(myMap);
//
//    // getOrDefault: key가 없으면 default값을 return
//    System.out.println(myMap.get("baseball")); // null이 나옴
//    System.out.println(myMap.getOrDefault("baseball", "비어있음"));

    // getOrDefault(key, null일때 값)
    String[] arr= {"농구", "농구", "배구", "야구", "배구"};
    Map<String, Integer> myMap = new HashMap<>();
    for(String a : arr) {
      int cnt = myMap.getOrDefault(a, 0);
      myMap.put(a, cnt+1);
    }
    System.out.println(myMap);

    // 해당 키가 있는지 없는지 확인 myMap.containsKey("baseball")

    // keySet() : 키목록을 set 형태로 반환
    // values(): 키목록을 반환

    // enhanced for 문을 통해 key 값 하나씩 출력
    for(String a : myMap.keySet()) {
      System.out.println("key: " + a);
      System.out.println("value: " + myMap.get(a));
    }

    for(int a : myMap.values()) {
      System.out.println(a);
    }

    // 어떤 메서드는 반환값이 Iterator인 경우가 있다.
    // iterator를 통해 key 값 하나씩 출력
    Iterator<String> myIter = myMap.keySet().iterator();
    // next() 메소드: 데이터를 하나씩 소모시키면서 return
    System.out.println(myIter.next());

    // hasNext(): iterator 안에 값이 있는지 없는지 boolean return
    while(myIter.hasNext()) {
      System.out.println(myIter.next());
    }


    //== 프로그래머스: 완주하지 못한 선수 ==//

    // 1. 리스트 풀이
    // sort 2번 써서 풀수도 있음

    // 2. Map 써서(Participant를 먼저 담고도 풀 수 있음) -> 마지막에 돌면서 1명 남은거 찾거나, remove해서 keySet에 유일하게 남은거 찾거나


    //== 프로그래머스: 의상 ==//


    //== LinkedHashMap: 데이터 삽입 순서가 유지된다. ==//
    Map<String, Integer> linkedMap = new LinkedHashMap<>();
    linkedMap.put("hello5", 1);
    linkedMap.put("hello4", 1);
    linkedMap.put("hello3", 1);
    linkedMap.put("hello2", 1);
    linkedMap.put("hello1", 1);
    System.out.println(linkedMap);

    // 자료가 추가된 순서를 가지고 있다.
    // TreeMap: key를 통해 데이터를 정렬(최적화된 정렬, logn의 복잡도)
    Map<String, Integer> treeMap = new TreeMap<>();
    treeMap.put("hello5", 1);
    treeMap.put("hello4", 1);
    treeMap.put("hello3", 1);
    treeMap.put("hello2", 1);
    treeMap.put("hello1", 1);

    for(String a : treeMap.keySet()) {
      System.out.println(a);
    }

  }
}
