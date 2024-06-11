package C01Basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class C06String {
  public static void main(String[] args) {

    // 객체 생성
    // 참조형 변수의 경우엔 이렇게 만드는 게 정석이기는하다. 하지만 스트링은 예외를 허용해준다.
//    String st1 = new String("hello");
//
//    // 리터럴 방식
//    // 리터럴 세팅하면 == 비교 가능함
//    String st2 = "hello";

    // 박싱
    // 기본 자료형을 래퍼 클래스로 변환

    // 참조 자료형: 기본 자료형을 제외한 모든 자료형
    // WrapperClass: 기본형 타입을 Wrapping한 클래스
    // int와 Integer 간의 형변환
//    int a = 10;
//    Integer b = new Integer(20);
//    // 오토 언박싱: Integer에서 int로 자동 형변환
//    int c = b;
//    // 오토 박싱
//    Integer d = a;

    // String과 int의 형변환
//    int a = 10;
//    String st3 = Integer.toString(a);
//    String st4 = String.valueOf(a);
//
//    // String -> int로 변환
//    int b = Integer.parseInt(st3);
//
//    // 참조 자료형에 원시 자료형을 담을 때는 Wrapper 클래스를 써야한다.
//    List<Integer> list = new ArrayList<>();
//    list.add(10);
//    list.add(20);

    // 리터럴 풀 -> 성능 향상. 권장하는 방법
//    String st1 = new String("hello");
//    String st2 = "hello";
//    String st3 = new String("hello");
//    String st4 = "hello";
//
//    System.out.println(st1 == st3);
//    System.out.println(st2 == st4);
//    System.out.println(st3 == st4);
//
//    System.out.println(st1.equals(st2));
//
//
//    // 대소문자 무시하고 문자열 비교하기
//    System.out.println("hello".equalsIgnoreCase("HellO")); // true


    // 문자열 길이: length()
    String st1 = "hello java world";
    System.out.println(st1.length());

    st1 = "hello java java";
    // indexOf: 특정 문자열의 위치 반환, 가장 먼저 나오는 문자열의 위치
    int index1 = st1.indexOf("java");
    System.out.println("index1: " + index1);

    // lastIndexOf: 마지막으로 일치하는 문자열의 index 위치
    int index2 = st1.lastIndexOf("java");
    System.out.println("index2: " + index2);

    // contains: 특정 문자열이 있는지 여부를 boolean으로 리턴
    System.out.println(st1.contains("hello"));
    System.out.println(st1.contains("world"));

    // charAt: 특정 index의 문자(char) 리턴
    String st = "abcdefabaadf";
    char ch1 = st.charAt(1);
    System.out.println("ch1: " + ch1);


    //== ==//
    // 위의 문자열에 a의 개수가 몇개인지 count
    int cnt = 0;
    for(int i=0; i<st.length(); ++i) {
      if(st.charAt(i) == 'a') {
        cnt++;
      }
    }
    System.out.println("a의 개수는 " + cnt + "개 입니다.");



    //== toCharArray() : String 문자열을 잘라서 char 배열로 리턴 ==//
    System.out.println(Arrays.toString(st.toCharArray()));

    //== toCharArray를 활용해서 a가 몇개인지 카운트. 향상된 for문 사용 ==//
    char[] arr = st.toCharArray();
    int cnt2 = 0;
    for(char c : arr) {
      if(c == 'a') cnt2++;
    }
    System.out.println("a의 개수는 " + cnt2 + "개 입니다.");


    //== 문자열 더하기: += ==//
    st = "hello";
    st1 += " world"; // 하지만 이렇게하면 성능이 떨어지는 것으로 알려져있다.
    // 연산 자체는 느리지 않다. 메모리에 접근해서 메모리를 재할당 -> 여기서 시간이 걸린다.
    // 나중에 StringBuffer, StringBuilder 사용


    //== char의 자동 형변환 ==//
    // char를 String에 더해버리면 char가 String으로 자동 형변환된다.
    st += 'a';
    System.out.println(st);

    //== substring(a, b): a이상 b미만의 index의 문자를 잘라 리턴 ==//
    st1 = "Hello World";
    System.out.println(st1.substring(0, 5)); // Hello

    System.out.println(st1.substring(6)); // World


    //== trim, strip: 문자열 양쪽 끝의 공백 제거 ==//
    // trim과 strip의 차이점: 유니코드로 오면서 공백도 종류가 많아짐. trim은 못자르는 이상한 공백문자가 있다.
    String trimSt1 = "      hello world       ";
    String trimSt2 = trimSt1.trim();
    System.out.println(trimSt1);
    System.out.println(trimSt2);

    System.out.println(trimSt1.strip()); // strip이 더 나중에 나옴



    //== toUppperCase: 대문자로 변환, toLowerase: 소문자로 변환 ==//
    String s1 = "heLLo";
    String s2 = s1.toUpperCase();
    String s3 = s2.toLowerCase();
    System.out.println(s2);
    System.out.println(s3);


    //== char -> String으로 형변환 ==//
    char ch = 'a';
    st1 = Character.toString(ch1);
    System.out.println(st1);

    //== replace(a, b): a 문자열을 b 문자열로 대체 ==//
    st1 = "hello world";
    String st2 = st1.replace("world", "java");
    System.out.println(st2);


    //== replaceAll(a, b): replace와 동일, 정규 표현식을 쓸 수 있음 ==//
    st1 = "01abc123한글123";
    // for문 활용해서 알파벳 제거
    arr = st1.toCharArray();
    String ans = "";
    for(char c : arr) {
      if(c >= 'a' && c <= 'z') continue;

      ans += c;
    }
    System.out.println("제거된 결과: " + ans);

    //== replaceAll()과 정규 표현식 활용 ==//
    st1 = "01abc123ABC한글123";
    // [a-z]+: 1개 이상의 소문자 알파벳 표현하는 정규표현식
    // [A-Za-z]+: 대소문자 포함
    // [가-힣]: 한글
    // [0-9]+: 숫자
    //
    String answer = st1.replaceAll("[A-Za-z]", "");


    //== matches와 Pattern.matches() ==//
    String test = "helloA";
    System.out.println(test.matches("[A-Za-z]+")); // 영문자로만 이뤄져있는지 ->
    boolean b1 = Pattern.matches("[0-9]+", "12345hello"); // false
    System.out.println(b1);


    //== 더 복잡한 정규 표현식 ==//

    // ^: 정규표현식의 시작, $: 정규 표현식 끝, *: 빈값 포함, +: 빈값 포함하지 않음
    // ^와 $는 필수 아님

    boolean b2 = Pattern.matches("^[A-Za-z]*$", "helloWorld");

    //== 전화 번호 패턴 검증 ==//
    Scanner sc = new Scanner(System.in);
//    while(true) {
//      String number = sc.next();
//      if(Pattern.matches("^\\d{3}-\\d{4}-\\d{4}$", number)) {
//        System.out.println("올바르게 입력하셨습니다."); break;
//      }
//      System.out.println("틀린 형식의 번호입니다");
//    }


    //== 이메일 검증 ==//
    // 소문자 알파벳과 숫자 + @ + 소문자 알파벳 + ".com"
//    String email = sc.next();
//    boolean b3 = Pattern.matches("^[a-z0-9]+@[a-z]+.com$", email);
//    System.out.println(b3);
//
//    //== split: 특정 문자를 기준으로 문자열을 자르는 것. 문자열 배열을 return ==//
//    String a = "a:b:c:d";
//    String[] splited = a.split(":");// 안에 정규식도 들어올 수 있다.
//    for (String s : splited) {
//      System.out.println(s);
//    }


    //== split ==//

    // 중간에 공백이 여러개
    // \s: 공백을 의미하는 이스케이프 시퀀스
    String b = "a b c  d";
    String[] bArr = b.split("\\s+");
    System.out.println(Arrays.toString(bArr));

    // isEmpty와 null(자료 타입)
    // st1, st2는 다르다.
    st1 = null;
    st2 = "";

    // 공백과 null의 차이

//    System.out.println(st1.isEmpty()); // NullPointerException

    if(st2 != null) {
      System.out.println(st2.isEmpty()); //
    }


    //== join: String[]을 하나의 String으로 만드는 메소드
    String[] sArr = {"java", "python", "C++", "javascript"};
    st = String.join(" ", sArr);
    System.out.println(st);

    //== StringBuffer, StringBuilder ==//
    // StringBuilder가 더 성능이 좋다.
    // String += <<< StringBuffer <<< StringBuilder
    // StringBuilder는 스레드 safe 하지 않다.
    StringBuffer sb1 = new StringBuffer("hello");
    sb1.append(" java");
    sb1.append(" world");

    System.out.println(sb1);

    // 6번째 자리에 문자열 끼워넣기
    sb1.insert(5, " python");
    System.out.println(sb1.toString());


    sb1.delete(17, sb1.length());
    System.out.println(sb1);

    //== Builder ==//

    // 백준 풀 때, println 하면 종종 출력 초과 나오는 경우가 있음 -> 그럴 때 sb에다 \n 넣어주기
    StringBuilder sb2 = new StringBuilder();
    sb2.append("hello");
    sb2.append("\n");
    sb2.append("world");
    System.out.println(sb2);

    //== 실습: StringBuilder ==//
    String myString = "hello";
    int n = 3;
    StringBuilder sb3 = new StringBuilder();
    char[] cArr = myString.toCharArray();
    for(char c : cArr) {
      for(int i=0; i<n; ++i) {
        sb3.append(c);
      }
    }
    sb3.append("\n");
    System.out.println(sb3);


    //== ==//


    //== join() ==//


    //== StringBuilder가 String을 직접 조작하는 것보다 빠름 ==//
    //== Deque VS Stack => Deque이 빠름 ==//

    //== StringBuilder: 동시성을 고려하지 않으므로 성능이 더 뛰어나지만, 멀티스레드 상황에서 동기화 문제가 발생할 가능성 있음 ==//
    //== StringBuffer: 동시성이 고려되어 있음 ==//
    //== StringBuffer -> synchronized 처리 되어 있음 ==//
  }
}
