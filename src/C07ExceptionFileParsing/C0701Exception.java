package C07ExceptionFileParsing;

import java.sql.SQLException;
import java.util.Scanner;

public class C0701Exception {
  public static void main(String[] args) throws SQLException {
    System.out.println("나눗셈 프로그램입니다.");

    Scanner sc = new Scanner(System.in);



    // 예외가 발생할 것으로 예상되는 코드에 try로 감싸고, 예외가 발생했을 때 대응하는 코드를 catch로 작성
    // 별 4개 정도됨 => 예외처리는 꼭 알아야한다.
    try {
      System.out.println("분자 입력: ");
      int head = Integer.parseInt(sc.nextLine()); // 문자를 입력하면 예외 발생
      System.out.println("분모 입력: ");
      int tail = Integer.parseInt(sc.nextLine());
      int result = head / tail; // 여기서 에러 나면 여기서 프로그램이 강제 종료된다.
      System.out.println("나눈 결과: " + result);
    } catch(ArithmeticException e) {
      System.out.println("0으로 나누시면 안됩니다.");
      // 예외가 발생된 내역을 로그를 남기기 위함
      e.printStackTrace(); // 사용자에게 알려주기 위함이 아니라, 시스템 상에 로그를 남기기 위함이다.
      System.out.println(e.getMessage());
    } catch(NumberFormatException e) {
      System.out.println("숫자에 맞는 값을 입력해주세요.");
    } catch(Exception e) {
      System.out.println("예외가 발생했습니다.");

    } finally {
      System.out.println("무조건 실행되는 구문입니다.");
    }

    System.out.println("감사합니다.");

    // Exception: 모든 예외의 조상 클래스이다.
    // try - catch 구문은 예외를 위에서부터 순차적으로 검사한다.


    //== throws ==//
    // throws: 예외 처리 위임을 명시

    login("1234");

    try {
      login2("1234");
    } catch(SQLException e) {
      System.out.println(e.getMessage());
    }
  }
  // unchecked 예외에서는 throws 키워드가 예외사항을 명시하는 용도로만 사용된다.
  //
  static void login(String password) throws IllegalArgumentException, SQLException {
    if(password.length() < 10) {
      // throw new : 예외를 강제로 발생시킴
      // 비밀번호가 짧은 것은 시스템 적인 문제가 아니다.
      // 예외는 기본적으로 바깥 메소드로 전파된다.

      // **Unchecked 예외는 예외처리가 강제 되지 않는다.**
      throw new IllegalArgumentException("비밀번호가 너무 짧습니다.");
      // ** checked => 예상 가능한 예외. 예외 처리 필수 => try-catch
      // ** unchecked => 예상 불가능한 예외. 예외 처리 선택 => try-catch 옵션
      // IllegalArgumentException은 unchecked Exception이므로, throws가 필수가 아니다.

      // checked: 주로 다른 시스템과의 네트워크(대표적으로 DB 조회), java에서 디스크 조회 후 작업
      // unchecked: 프로그램 자체의 이슈


//      // 방법 2. 메소드를 호출한 쪽에 위임 => throws
//      if(password.length() < 10) {
//        throw new SQLException("비밀번호가 너무 짧습니다.");
//      }

    }
  }

  static void login2(String password) throws IllegalArgumentException, SQLException {
    // 방법 1. 직접 예외처리
    try {
      if(password.length() < 10) {
        throw new IllegalArgumentException("비밀번호가 너무 짧습니다.");
      }
    } catch(IllegalArgumentException e) {
      System.out.println(e.getMessage());

      // 참고: e.printStackTrace() => 상세한 에러가 만들어진 상황이 다 나옴
    }

    // 방법 2. 메소드를 호출한 쪽에 위임 => throws
    if(password.length() < 10) {
      throw new SQLException("비밀번호가 너무 짧습니다.");
    }
  }
}
