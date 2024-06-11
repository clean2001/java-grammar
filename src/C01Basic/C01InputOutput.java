package C01Basic;

// 자바 밑에 util밑에 Scanner라는 클래스를 임포트 하겠다.
import java.util.Scanner;

public class C01InputOutput {
  public static void main(String[] args) {
//    // 출력: System.out -> 콘솔 출력
//    // System이라는 클래스 안에 out이라는 메소드가 있는 것
//    int a = 20; // a는 변수명. 20이라는 값을 a에 담겠다는 의미
//    // println: 출력 후 줄바꿈
//    // print: 줄바꿈 없이 출력
//    System.out.print(a);
//    String b = "hello world!";
//    System.out.println(b);
//
//    // 문자열과 숫자를 합하면 문자가 된다.
//    System.out.println(a+b); // 20hello world 라는 문자열이 출력된다.
//
//    // 숫자 + 숫자
//    System.out.println(20+"10");


    // 입력: System.in -> 키보드 입력
    // Scanner: 입력을 위한 클래스이다.
    Scanner myScanner = new Scanner(System.in);
//    System.out.println("아무 문자열을 입력해주세요.");
//
//    // nextLine은 입력받은 데이터를 한줄 읽어서 String으로 리턴한다.
//    String inputs = myScanner.nextLine(); // 어떤것을 리턴하냐에 따라서
//    System.out.println(inputs);
//
//    System.out.println("더하기할 두 숫자를 입력해주세요");
//    int a1 = myScanner.nextInt();
//    int a2 = myScanner.nextInt();
//
//    System.out.println("두수를 더하는 값은 " + (a1 + a2) + "입니다.");
//
//    System.out.println("실수를 입력해주세요");
//    double inputDouble = myScanner.nextDouble();
//    System.out.println(inputDouble);

    System.out.println("true 또는 false를 입력해주세요");
    boolean inputBoolean = myScanner.nextBoolean();
    if (inputBoolean) {
      System.out.println("참");
    } else {
      System.out.println("거짓");
    }

    // 입출력 시스템 메모리 해제해주는 것이 좋다.
    // java 밖의 시스템이므로 입출력 시스템 메모리 해제해주는 것이 좋다.
    myScanner.close();
  }

}
