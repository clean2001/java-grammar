package C01Basic;

import java.math.BigDecimal;
import java.util.Scanner;

public class C02Variable {
  public static void main(String[] args) {
    // 정수: byte(1 byte, mariadb의 tinyint와 싱크가 맞음), int(4 byte), long(8 byte)

//    byte a = 127;
//    byte b = -128;
//    a++;
//    b--;
//    // 오버플로우 또는 언더플로우 발생 ->
//    System.out.println(a);
//    System.out.println(b);
//
//    int intA = 10;
//    // long은 명시적으로 L을 붙여 long 타입임을 명시하기도 함
//    long longB = 20L;
//
//
//    // 실수: float, double (기본)
//    float f1 = 1.123f;
//    double d1 = 1.123;

    // 부동 소수점 오차 테스트
//    double d2 = 0.1;
//    System.out.println(d2);
//
//    double total = 0;
//    for(int i=0; i<1000; ++i) {
//      total += 0.1;
//    }
//    // 오차 해결 방법: 1을 1000번 더한다음 10으로 나누기
//    System.out.println("total: " + total);


    // 소수점 오차의 대안으로 BigDecimal 클래스 사용
    double d1 = 1.03;
    double d2 = 0.42;

    System.out.println(d1 - d2); // 0.6100000000000001 오차가 있음

    // BigDecimal의 원리: 저장할 때 문자열로 저장해서 연산할 때 정수로 변환, 최종 결과는 실수로 반환
    BigDecimal b1 = new BigDecimal("1.03");
    BigDecimal b2 = new BigDecimal("0.42");
    double result = b1.subtract(b2).doubleValue();
    System.out.println(result); // 0.61 정확하게 나옴

    // 실수 연산할 때 연산에 오차가 없다.

    // 문자형: char -> 2바이트 할당 (이거는 시스템마다 다르다. 2바이트가 아닐 수 있음)
    // 아스키 코드는 1바이트이다.
    // 현재는 utf-8이라는 인코딩 방식이 거의 표준이 되었다. (유니코드)
    // 유니코드 체계로 가면서 2바이트 이상의 문자형이 나오게 되었다.
//    char m1 = '가';
//    System.out.println(m1);
//
//    // boolean: true 또는 false;
//    // if 조건절에서 사용된다.
//    boolean bool1 = true;
//    boolean bool2 = false;
//    Scanner sc = new Scanner(System.in);
//
//    int input1 = sc.nextInt();
//    boolean bool3 = input1 > 0;
//    // 조건
//    // if 조건절 안에 boolean 타입 값이 들어옴에 유의
//    if(bool3) {
//      System.out.println("양수입니다");
//    } else {
//      System.out.println("음수입니다");
//    }
//
//    // 타입 변환
//    // 묵시적 타입 변환
//    int a = 10;
//
//    // 명시적 타입 변환


//    char[] carr = new char[10];
//    for (int i = 0; i < 10; ++i) {
//      System.out.println((int)carr[i]);
//    }
//
//    char ch1 = 'a';
//    int ch1_num = ch1; // 묵시적 타입 변환
//    System.out.println(ch1_num);
//
//    // 알파벳 비교를 위한 묵시적 타입 변환 발생
//    System.out.println('a' < 'b');


    // int -> double 형변환은 문제 없음
//    int i1 = 10;
//    // int를 double에 넣어보기
//    double d3 = i1;
//
//    // double -> int의 묵시적 형변환은 불가능
//    // 명시적 형변환은 가능: 소수점이 절사된다.
//    double d4 = 10.5;
//    int i2 = (int)d4;
//    System.out.println(i2); // 10이 출력된다.


    //== 나눗샘에서 생기는 이슈 ==//
    // int / int 이므로 결과값을 int로 판단하여 소수점 절사
    // 해결책: 두 값 중에 한 값이라도 double로 명시적 형변환 시켜주면 결과값이 double이 된다.
//    int a = 1;
//    int b = 4;
//    int c = 1 / 4;
//    double d = 1 / (double)4;
//    System.out.println("c: " + c + " / d: " + d);
//
//    int a1 = 10;
//    // 변수값 재할당
//    a1 = 20;
//    System.out.println(a1);


    // 상수는 초기화 이후에 값이 재할당되는 것이 불가능하다.
    // 상수는 final 키워드를 통해 표현
    // 값의 항상성을 유지할 수 있다.
    // 일반적으로 상수값은 대문자로 표기한다.
    final int AGE;
    AGE = 20;


  }

}
