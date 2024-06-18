package C06EtcClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C0603GenericMain {
  public static void main(String[] args) {
    String[] stArr = {"java", "python", "C"};
    stChange(stArr, 0, 1);
    System.out.println("자리 바꾼 후: " + Arrays.toString(stArr));

    Integer[] intArr = {10, 20, 30};
    intChange(intArr, 0, 1);
    System.out.println("자리 바꾼 후: " + Arrays.toString(intArr));
    //== 코드의 중복이 발생 => 제네릭으로 해결 ==//

    // Generic
    genericChange(stArr, 1, 2);
    System.out.println("자리 바꾼 후: " + Arrays.toString(stArr));


    GenericPerson<String> p1 = new GenericPerson();
    p1.setValue("kimsejeong");


    // 제네릭 사용
    List<String> myList = new ArrayList<>();
    myList.add("hello");
    myList.add("java");

    // 컴파일 후 제네릭 소거
//    List myList = new ArrayList<>();
//    myList.add("hello");
  }
  // 제네릭 메소드 생성: 반환타입 왼쪽에 <T> 선언
  // 유의점: 제네릭은 참조 변수 타입이 들어와야함
  static <T> void genericChange(T[] arr, int idx1, int idx2) {
    T temp = arr[idx1];
    arr[idx1] = arr[idx2];
    arr[idx2] = temp;
  }
  static void stChange(String[] stArr, int idx1, int idx2) {
    String temp = stArr[idx1];
    stArr[idx1] = stArr[idx2];
    stArr[idx2] = temp;
  }

  static void intChange(Integer[] intArr, int idx1, int idx2) {
    Integer temp = intArr[idx1];
    intArr[idx1] = intArr[idx2];
    intArr[idx2] = temp;
  }
}

// 제네릭 클래스는 클래스명 옆에 <T> 선언
// 컴파일 시점에 제네릭이 소거된다 -> Object로 대체??
// 제네릭이 소거되므로 타입을 추론해야 함 : **런타임 시점**에 추론 => 타입을 추론할 때(런타임에) **리플렉션**이라는 기술이 사용된다.


class GenericPerson<T> {
  T value;

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }
}

class Person<T> {
  T value;

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }
}
