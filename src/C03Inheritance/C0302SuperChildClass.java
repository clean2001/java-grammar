package C03Inheritance;

public class C0302SuperChildClass extends SuperParents{
  String a;
  int c;

  // 부모클래스의 생성자의 값에 super()를 호출해줘야한다.
  C0302SuperChildClass() {
    // super(): 부모 클래스의 생성자를 의미한다.
    // super.변수명: 부모 클래스의 변수명 의미
    super(30);
    a = "DDD";
    c = 20;
  }

  public static void main(String[] args) {
    C0302SuperChildClass c1 = new C0302SuperChildClass();
    c1.display2();
  }

  void display2() {
    System.out.println(a); // this.a
    System.out.println(super.a);
  }
}

class SuperParents {
  int a;

  SuperParents(int a) {
    this.a = a;
  }

  void display() {
    System.out.println("부모 클래스입니다");
  }

}
