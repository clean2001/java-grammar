package C01Basic;

import java.util.Scanner;

public class C04IfStatements {

  public static void main(String[] args) {
    // 비밀번호는 String 값으로 정해두기: 1234
    // 맞으면 "문이 열렸습니다" 출력

//    // 도어락키 if문
//    Scanner sc = new Scanner(System.in);
//    int answer = 1234;
//
//    int password = sc.nextInt();
//    if(answer == password) {
//      System.out.println("문이 열렸습니다.");
//    } else {
//      System.out.println("비밀번호가 틀렸습니다.");
//    }


    // 알파벳이 소문자인지 대문자인지 판별하는 프로그램
    // 힌트: 묵시적 타입 변환을 이용하자!
    // 소문자 알파벳, 대문자 알파벳, 그외
//    char c = sc.next().charAt(0);
//    if(c >= 'a' && c <= 'z') {
//      System.out.println("소문자입니다");
//    } else if(c >= 'A' && c <= 'Z') {
//      System.out.println("대문자입니다");
//    } else {
//      System.out.println("알파벳이 아닙니다.");
//    }


    // 숫자범위로 실습하기
    // 택시 요금: 10000, 버스요금: 3000, 킥보드: 2000
    // 사용자에게 얼마가 있는지 물어보고 구간별로 교통수단 추천
//    int money = sc.nextInt();
//    if(money >= 10000) {
//      System.out.println("택시 타라");
//    } else if(money >= 3000) {
//      System.out.println("버스 타라");
//    } else if(money >= 2000) {
//      System.out.println("킥보드 타라");
//    } else {
//      System.out.println("걸어가라");
//    }

    // 삼항연산자: 결과값 = 조건식 ? 반환값1 : 반환값2
//    int answer = 1234;
//    System.out.println("비밀번호를 입력하시오");
//    Scanner sc = new Scanner(System.in);
//    int input = sc.nextInt();
//    String result = (answer == input) ? "문이 열렸습니다." : "비밀번호가 틀렸습니다.";
//
//    System.out.println(result);


    // switch 문
    Scanner sc = new Scanner(System.in);
    System.out.println("원하시는 서비스 번호를 입력하세요.");
    int input = sc.nextInt();
    String result;
    switch(input) {
      case 0:
        result = "상담사 연결입니다.";
        break;
      case 1:
        result = "대출 업무입니다.";
        break;
      case 2:
        result  = "예금 업무입니다.";
        break;
      case 3:
        result = "적금 업무입니다.";
        break;
      default:
        result = "잘못 입력하셨습니다.";
    }
    System.out.println(result);
  }

}
