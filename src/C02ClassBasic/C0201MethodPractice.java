package C02ClassBasic;

import java.util.Scanner;

// 어떤 숫자 값이 소수인지 아닌지를 판별하는 메서드 생성
// => 리턴 타입 boolean, 매개변수는 int 숫자
// main 메서드 안에서 해당 메서드 호출해서 판별 출력
public class C0201MethodPractice {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();

    if(isPrime(num)) {
      System.out.println("소수입니다.");
    } else {
      System.out.println("거짓입니다.");
    }
  }

  public static boolean isPrime(int num) {
    int upper = (int)Math.sqrt(num);
    for(int i=2; i<=upper; ++i){
      // 메소드는 return을 만나면 바로 종료된다. (메소드 자체가 종료된다.)
      // void 리턴 타입에서도 메서드 강제 종료를 위해 return 사용
      if(num % i == 0) return false;
    }

    return true;
  }


  public static void isPrimePrint(int num) {
    int upper = (int)Math.sqrt(num);
    for(int i=2; i<=upper; ++i){
      // 메소드는 return을 만나면 바로 종료된다. (메소드 자체가 종료된다.)
      // void 리턴 타입에서도 메서드 강제 종료를 위해 return 사용
      if(num % i == 0) {
        System.out.println("소수가 아닙니다,");
        return; // 메소드를 종료 시키는 용도
      }
    }

    System.out.println("소수입니다.");
  }


}
