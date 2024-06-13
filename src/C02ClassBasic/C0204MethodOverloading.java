package C02ClassBasic;

public class C0204MethodOverloading {
  public static void main(String[] args) {
    // 객체 만들기
    C0204MethodOverloading methodOverloading = new C0204MethodOverloading();
    System.out.println(methodOverloading.sum(10, 20));

  }
  // 접근제어자를 붙이지 않으면 기본적으로 default 접근 제어자이다. => 같은 패키지 내에선 접근할 수 있다. : 같은 패키지 내에서만 유효
  int sum(int a, int b) {
    return a+b;
  }

  // 메소드 오버로딩:  매개변수의 타입 또는 개수가 다르면, 같은 이름의 메소드 정의 가능
  double sum(double a, double b) {
    return a + b;
  }

  int sum(int a, int b, int c) {
    return a + b + c;
  }

}
