package C01Basic;

public class C03Operator {
  public static void main(String[] args) {
    // 산술 연산자: 사칙연산
//    int n1 = 8, n2 = 3;
//
//    // *: 곱셈, /: 나눗셈, %: 나머지
//
//    System.out.println(n1 + n2);
//    System.out.println(n1 - n2);
//    System.out.println(n1 * n2);
//    System.out.println(n1 / n2);
//    System.out.println(n1 % n2);

    // 대입 연산자
//    int n1 = 7;
//    int n2 = 7;
//    int n3 = 7;
//
//    n1 = n1 - 3;
//    n2 -= 3;
//    n3 =- 3; // -3
//    System.out.println(n1);
//    System.out.println(n2);
//    System.out.println(n3);

//    int n4 = 10;
//    int n5 = 10;
//    n4 /= 3;
//    System.out.println(n4);
//    n5 %= 3;
//    System.out.println(n5);
//
//    // 증감 연산자
//    int a = 10;
//    a = a + 1;
//    a += 1;
//    System.out.println(a);
//
//    a++; // 후위 증감 연산자
//    ++a; // 전위 증감 연산
//    System.out.println(a);
//
//    // 후위 증감 연산자
//    // 전위 증감 연산자
//    System.out.println(a);

    // 후위 증감 연산자
//    int b = 5;
//    int c = b++; // 실행문이 끝나고 b값이 증가
//    int d = ++b; // 실행문이 끝나기 전에 b값이 증가 ->
//    System.out.println(c); // 5
//    System.out.println(d); // 7


    // 비교 연산자 -> 반환값이 boolean이다.
    // 비교 연산자: ==, !=, >, >= 등
//    char ch1 = 'a';
//    char ch2 = 'b';
//    System.out.println(ch1 == ch2); // false
//    System.out.println(ch1 != ch2); // true

    // 논리 연산자
    // &&: 논리식이 모두 참이면 참을 반환 (AND 연산)
    // ||: or 연산
    // !:
    int num1 = 10; int num2 = 20;

    // num1이 5보다 큰지와 num1이 20보다 작은 && 조건을 통해 boolean 값 세팅
//    boolean result1 = (num1 > 5 && num1 < 20);
//    System.out.println("result1: " + result1);
//
//
//    boolean result2;
//    result2 = !(num2 < 10 || num2 < 30);
//
//
//    System.out.println("result2: " + result2);

    // 비트연산자: &, |, ^ (xor), ~(not)
    int n1 = 5; // 101  -> 00000101
    int n2 = 4; // 100
    int n3 = n1 & n2; // 100
    System.out.println(n3); // 출력값: 4

    int n4 = n1 | n2; // 101 => 5
    int n5 = n1 ^ n2; // 1
    int n6 = ~n1; // 8자리가 꽉 차있다고 가정

    System.out.println(n4); // 출력값 : 5
    System.out.println(n5); // 출력값: 1
    System.out.println(~n5); // 출력값: -2

    // 시프트 연산: <<, >>(오른쪽으로 이동)
    // 왼쪽으로 한칸이동한다는 의미는 2를 곱한다는 의미






  }
}
