package C01Basic;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class C08List {

  public static void main(String[] args) {
    // List 선언 방법
//    ArrayList<String> myList = new ArrayList<>();
//    ArrayList<String> myList2=  new ArrayList<>();
//
//    // 일반적인 List 선언 방법
//    // 왼쪽: 인터페이스, 오른쪽: 구현체(클래스)
//    List<String> myList3 = new ArrayList<>();
    // 왼쪽에 List로 선언하는 이유: ArrayList에는 선언돼있지만 List에는 선언되어있지 않은 기능을 쓰지 못하게 하려고
    // myList3. -> 이걸로 쓰는 기능들은 ArrayList에 구현된 기능들이다.
    // 선언만 돼있는 요소.

    // 초기값 생성 방법 1. 하나씩 add
//    myList3.add("java");
//    myList3.add("python");
//    myList3.add("C++");
//
//    // 초기값 생성 방법 2. 리스트를 주입하는 방식
//    // Arrays.asList 배열을 리스트로 변환하는 메소드
//    String[] myArr = {"java", "python", "C++"};
//    List<String> myList4 = new ArrayList<>(Arrays.asList(myArr));
//
//    int[] intArr = {10, 20, 30};
//    List<int[]> list = new ArrayList<>(); // 이건 된다!! -> 이거 잘 기억해두기
//    List<Integer> myList5 = new ArrayList<>();
////    List<Integer> myList5 = new ArrayList<>(Arrays.asList(intArr)); // 이건 안됨!!!
//    for(int i : intArr) {
//      myList5.add(i); // add하는 시점에서 오토 박싱
//    }
//
//    // Collection 프레임워크
//
//    // 기본 자료형 ()
//    // 참조 자료형(클래스를 통해 만들어진 자료형 -> 객체)
//
//    //== List.of(arr) ==//
//    List<String> myList6 = new ArrayList<>(List.of(myArr));

    //==  ==//
//    List<Integer> myList = new ArrayList<>();
//    myList.add(10);
//    myList.add(20);
//    System.out.println(myList);
//
//    // add(index, 값): 중간에 값 삽입
//    // 성능이 떨어지기 때문에 하지 마랏
//    myList.add(0, 30);
//    System.out.println(myList);
//
//    //
//    List<Integer> myList2 = new ArrayList<>();
//    myList2.add(1);
//    myList2.add(2);
//
//    //== 특정 리스트의 요소를 모두 add ==//
//    myList.addAll(myList2);
//
//    //== get: 특정 위치의 요소를 반환 ==//
//    System.out.println(myList);
//    System.out.println(myList.get(0));
//
//
//    //== for문을 돌려서 전체 list 출력 ==//
//    // size(): 리스트의 길이(개수) 반환
//    for(int i=0; i<myList.size(); ++i) {
//      System.out.println(myList.get(i));
//    }
//
//    //== remove: 요소 삭제 ==//
//    // 1) index를 통한 삭제, 2) value를 통한 삭제
//    myList.remove(0); // 1) index를 통한 삭제
//    myList.remove(Integer.valueOf(10));
//    System.out.println(myList);
//
//    // set(index, value): 인덱스 위치의 자리에 value 값 setting(변경)
//    myList.set(myList.size()-1, 10);
//    System.out.println(myList);
//
//    // indexOf: 특정 값이 몇번째 index에 위치하는지 return. 가장 먼저 나오는 값의 index 리턴
//    System.out.println(myList.indexOf(10));
//
//
//    // 전체 삭제: clear()
//    myList.clear();
//
//    // isEmpty(): 값이 비어있는지, 안비어있는지
//    // 나중에 스프링에서 post 같은 것을 가져올 때, 단건 조회이면 null 체크를 해줘야함
//    // 하지만 List로 조회하면 null이 아니라서 상관 없음
//    // isEmpty()는 true이지만 null은 아님
//    System.out.println(myList.isEmpty());
//
//    myList.add(10);
//    //== contains: 특정 값이 있는지 없는지 확인 ==//
//    System.out.println("있음: " + myList.contains(10)); // true
//    System.out.println("없음: " + myList.contains(40)); // false
//
//    // 리스트의 츨력
//    // 이미 toString을 내부적으로 상속하고 있음.
//    // value 값이 출력
//
//    // 이중 리스트
//    List<List<Integer>> list = new ArrayList<>();
//    list.add(new ArrayList<>());
//    list.add(new ArrayList<>());
//    list.get(0).add(10);
//    list.get(1).add(12);
//    System.out.println(list);
//
//    // 리스트 안에 배열
//    List<int[]> myList3 = new ArrayList<>();
//    myList3.add(new int[2]);
//    myList3.add(new int[3]);
//    myList3.add(new int[4]);
//
//    // 초기화
//    int num = 1;
//    for(int i=0; i<3; ++i) {
//      for (int j = 0; j <= i + 1; ++j) {
//        myList3.get(i)[j] = num++;
//      }
//    }
//    System.out.println(myList3);
//    for (int[] ints : myList3) {
//      System.out.println(Arrays.toString(ints));
//    }
//
//
//    List<int[]> myList4 = new ArrayList<>();
//    myList4.add(new int[] {1, 2});
//    myList4.add(new int[] {1, 2, 3});
//    myList4.add(new int[] {1, 2, 3, 4});
//    System.out.println(myList4);
//    for (int[] ints : myList4) {
//      System.out.println(Arrays.toString(ints));
//    }
//
//    // 리스트 정렬: Collections.sort(), 리스트객체.sort();
//    // 정렬 1. Collections.sort() => 클래스 메소드이다!!
//    List<Integer> list1 = new ArrayList<>();
//    list1.add(5);
//    list1.add(3);
//    list1.add(2);
//    list1.add(1);
//    list1.add(4);
//
//    // 오름차순 정렬
//    Collections.sort(list1);
//
//    // 내림차순 정렬
//    Collections.sort(myList, Comparator.reverseOrder());
//
//
//    // 정렬 2. 리스트객체.sort() =>
//    myList.sort(Comparator.naturalOrder());
//    myList.sort(Comparator.reverseOrder());

    // 배수 고르기.

    // 배열과 List 간의 변환
    // 1. String 배열을 List<String>으로 변환

    // 1-1
    String[] stArr = {"java", "python", "c++"};
    List<String> stList1 = new ArrayList<>(Arrays.asList(stArr));

    // 1-2. for문을 통해 담기

    // 1-3. stream API(참고만)
    List<String> stList2 = Arrays.stream(stArr).collect(Collectors.toList());

    //== 2. List<String>을 String 배열로 변환 ==//
    // 2-1. for문을 통해 담기
    // 2-2. toArray 메소드
    String[] stArr2 = stList1.toArray(new String[stList1.size()]);

    // 2-3.

    //== 3. int 배열을 List<Integer>로 변환 ==//
    // 3-1. for문으로 담기

    // 3-2. stream API 사용
    int[] intArr = {10, 20, 30, 40};
    List<Integer> intList = Arrays.stream(intArr)
        .boxed()
        .collect(Collectors.toList());



  }
}
