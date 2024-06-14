package C05AnonymousLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class C0503ComparableComparator {

  public static void main(String[] args) {
    // 자바에서는 비교를 위한 인터페이스를 2개 제공한다
    // Comparable, Comparator

    // Comparable 인터페이스에는 compareTo 메서드 선언
    // Comparator 인터페이스에는 comapare 메서드 선

    // String 클래스에 compareTo 내장(Comparable 구현)
    String a = "hello";
    String b = "horld";

    // 두 문자열의 각 자리를 순차적으로 비교
    // 문자열의 비교는 유니코드 값의 차이를 반환
//    System.out.println(a.compareTo(b)); // -10 출력. l과 r의 차이
//    // Comparable 인터페이스에는 compareTo 메서드 하나 밖에 없음
//
//    // String 클래스 외에 java의 많은 내장 클래스에서 Comparable을 구현하고 있다.
//    Integer a1 = 10;
//    Integer a2 = 10;
//    System.out.println(a1.compareTo(a2)); // 0 출력
//
//    List<String> myList = new ArrayList<>();
//    myList.add("java");
//    myList.add("python");
//    myList.add("javascript");
//    Collections.sort(myList); // Comparable의 compareTo 메서드를 구현하여 정렬
//    System.out.println("오름차순: " + myList);
//    Collections.sort(myList, Comparator.reverseOrder());
//    System.out.println("내림차순: " + myList);
//
//    //== 또 다른 정렬 방법 ==//
//    myList.sort(Comparator.naturalOrder());
//    myList.sort(Comparator.reverseOrder());

    // Student 객체 5개 정도 담으세요.
    List<Student> list = new ArrayList<>();
    String[] names = {"kim", "lee", "park", "choi", "hong"};
    int[] ages = {20, 33, 10, 21, 22};
    for(int i=0; i<5; ++i) {
      list.add(new Student(names[i], ages[i]));
    }
//    System.out.println(list);

    // 정렬 시키기!
//    list.sort(Comparator.reverseOrder());
//    System.out.println("내림차순 정렬: " + list);
//
//    // 방법 1. Student 객체에서 Comparable 구현 => comapareTo 메서드를 overriding 해줘야한다.
//    Collections.sort(list);
//    System.out.println("오름차순 정렬: " + list);
//
//    for(Student s : list) {
//      System.out.println(s.getName() + " " + s.getAge());
//    }

    // 방법 2. Comparator를 구현한 익명 객체를 sort에 주입하는 방식
    Comparator<Student> myComparator = new Comparator<Student>() {
      @Override
      public int compare(Student o1, Student o2) {
         return o1.getAge() - o2.getAge();
      }
    };
    list.sort(myComparator);
    System.out.println(list); // 나이 오름차순 정렬

    Comparator<Student> myComparator2 = (c, d) -> c.getAge() - d.getAge();

    list.sort((s1, s2) -> s1.getName().compareTo(s2.getName())); // 매개변수가 Comparator 객체로 정해져있음
    System.out.println("이름 오름차순(by 익명함수): " + list);

    // 글자 길이 순으로 내림차순 정렬
    String[] stArr = {"hello", "java", "C++", "world2"};
    Arrays.sort(stArr, (s1, s2) -> s2.length() - s1.length());
    System.out.println(Arrays.toString(stArr));

    // 위 배열이 들어간 아래 리스트를 배열에 0번재가 아닌 1번째를 기준으로 내림차순 정렬
    List<int[]> myList = new ArrayList<>();
    myList.add(new int[] {4, 5});
    myList.add(new int[] {1, 2});
    myList.add(new int[] {5, 0});
    myList.add(new int[] {3, 1});
    myList.sort((l1, l2) -> l2[1] - l1[1]);
    for(int[] arr : myList) {
      System.out.println("[" + arr[0] + ", " + arr[1] + "]");
    }

    // 만약에 1번째가 같으면? => 0번째로 내림차순
    myList.add(new int[] {2, 1});
    myList.add(new int[] {3, 0});
    myList.sort((l1, l2) -> {
      if(l1[1] == l2[1]) return (l2[0] - l1[0]);

      return l2[1] - l1[1];
    });
    System.out.println("만약에 1번째가 같으면? => 0번째로 내림차순 정렬");
    for(int[] arr : myList) {
      System.out.println("[" + arr[0] + ", " + arr[1] + "]");
    }
  }
}

//class Student implements Comparable<Student> { // <> 안에 어떤 객체로 비교할지
class Student { // <> 안에 어떤 객체로 비교할지
  private String name;
  private int age;

  public Student(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  // 모든 클래스의 조상 클래스인 Object 클래스의 toString 메서드를 Override하여
  // 객체 호출 시에 자동으로 toString 메서드 호출
  @Override
  public String toString() {
    return "[이름: " + name + ",  나이: " + age + "]";
  }

  // 나이 오름차순 정렬
//  @Override
//  public int compareTo(Student o) {
//    return this.age - o.getAge();
//  }
  // 이름 오름차순 정렬
//  @Override
//  public int compareTo(Student o) {
//    return this.name.compareTo(o.getName());
//  }

  // 이름 내림차순 정렬
//  @Override
//  public int compareTo(Student o) {
//    return o.getName().compareTo(this.name);
//  }

  //==  ==//


}
