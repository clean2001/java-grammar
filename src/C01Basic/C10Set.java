package C01Basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class C10Set {
  public static void main(String[] args) {
    //== Set ==//
//    Set<String> mySet = new HashSet<>();
//    mySet.add("h");
//    mySet.add("h");
//    mySet.add("e");
//    mySet.add("l");
//    mySet.add("l");
//    mySet.add("o");
//
//    System.out.println(mySet); // 중복 없음. 순서 없음

    //== List를 Set의 인자로 받을 수 있다. ==//
    List<String> myList = new ArrayList<>(); // 스프링에서 가장 많이 활용
    myList.add("tennis");
    myList.add("baseball");
    myList.add("basketball");
    myList.add("basketball");
    myList.add("basketball");

    Set<String> mySet = new HashSet<>(myList);
    System.out.println(mySet);

    String[] arr = {"baseball", "basketball", "basketball"};
    Set<String> mySet2 = new HashSet<>(Arrays.asList(arr));
    System.out.println(mySet2);
    mySet2.remove("baseball");
    System.out.println(mySet2);

    // remove, contains 다 빠름

    // 교집합, 합집합, 차집합


    //== 프로그래머스: ==//
    // startWith 메소드
    String a = "abcd";
    String b = "efg";
    boolean b1 = a.startsWith(b);
//    String[] phone_book = {"119", "119552"}

    //== 집합 관련 함수 : ==//
    // 교집합: retainAll / 합집합: addAll / 차집합: removeAll
    Set<String> set1 = new HashSet<>(Arrays.asList("java", "python", "javascript"));
    Set<String> set2 = new HashSet<>(Arrays.asList("java", "html", "css"));

    // 특이점: set1 자체가 변경된다.
    boolean b2 = set1.retainAll(set2);
    System.out.println(set1); // [java]

    set1 = new HashSet<>(Arrays.asList("java", "python", "javascript"));
    set1.addAll(set2);
    System.out.println(set1);


    // 차집합
    set1 = new HashSet<>(Arrays.asList("java", "python", "javascript"));
    set1.removeAll(set2);
    System.out.println(set1);

    //== 관련 문제: 뉴스 클러스터링 ==// -> 관심있으면 풀어보기

    // set의 주된 목적: 중복 제거


    //== LinkedHashSet, TreeSet ==//
    Set<String> myTreeSet = new TreeSet<>();
    myTreeSet.add("hello5");
    myTreeSet.add("hello5");
    myTreeSet.add("hello4");
    myTreeSet.add("hello1");
    System.out.println(myTreeSet); // 정렬 시간 복잡도: nlogn

    //  두 개 뽑아서 더하기 문제 => treeset으로 다시 풀어보기

  }
}
