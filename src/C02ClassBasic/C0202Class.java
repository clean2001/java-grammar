package C02ClassBasic;

// public class는 한 파일안에 하나만 있어야한다.
public class C0202Class {

  public static void main(String[] args) {
    // 클래스 메서드 호출 방식: 클래스명.메서드명();
    MyCalculator.sumAcc(20);
    System.out.println(MyCalculator.total);

    MyCalculator.sumAcc(20);
    System.out.println(MyCalculator.total);


    //== 객체를 사용한 회계 프로그램: 객체 고유의 메모리 공간 할당 ==//
    // A 회사의 매출
    MyCalculatorInstance m1 = new MyCalculatorInstance();
    // 객체 메서드 호출 방식: 객체명.메소드명();
    m1.sumAcc(10);
    m1.sumAcc(20);
    m1.sumAcc(30);
    MyCalculatorInstance m2 = new MyCalculatorInstance();
    m2.sumAcc(100);
    m2.sumAcc(200);
    m2.sumAcc(300);

    System.out.println(m1.total);
    System.out.println(m2.total);

    C0203Person person1 = new C0203Person();
    // 변수값에 직접 접근하여 값을 할당하는 방식
//    person1.name = "홍길동";
//    person1.email = "hong@naver.com";
//    person1.age = 10;
//    person1.eating();
//    System.out.println("이름: " + person1.name + " 이메일은 " + person1.email);

    // 일반적인 패턴: 변수값에 직접 접근하지 않는다.
    // **의도를 명확히 한 메서드**를 통해 변수값을 할당하고 가져옴.

    person1.eating();

    //==  ==//
    int[] arr = new int[10];
    System.out.println(arr[0]);
    person1.setName("홍길동");
    System.out.println(person1.getName());
    person1.eating();



    //==  ==//
  }




}

// 클래스는 변수와 매개변수가 결합돼 있는
class MyCalculator {
  static int total = 0;
  static int sum(int a, int b) {
    return a + b;
  }

  static void sumAcc(int a) {
    total += a;
  }
  static int minus(int a, int b) {
    return a - b;
  }
}


class MyCalculatorInstance {
  // static이 붙어있는 변수는 클래스 변수, static이 붙어있지 않으면 객체(인스턴스) 변수이다.
  // 클래스와 객체가 무슨 차이가 있을까?
  int total = 0;
  int sum(int a, int b) {
    return a + b;
  }

  void sumAcc(int a) {
    // this: 객체 자기 자신을 의미한다.
    this.total += a;
  }
  int minus(int a, int b) {
    return a - b;
  }

  // static method(클래스 메소드)는 객체 변수에 접근할 수 없다.
  // 인스턴스 메소드는 static method에 접근할 수 있다.
  // 클래스를 통해서 객체를 만듦: 고유의 메모리값을 할당한 요소(복제본을 만든 것)
  // map, set, stack, queue, list 배열


}
