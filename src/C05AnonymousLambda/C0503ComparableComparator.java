package C05AnonymousLambda;

public class C0503ComparableComparator {

  public static void main(String[] args) {
    // 자바에서는 비교를 위한 인터페이스를 2개 제공한다
    // Comparable, Comparator

    // Comparable 인터페이스에는 compareTo 메서드 선언
    // Comparator 인터페이스에는 comapare 메서드 선

    // String 클래스에 compareTo 내장(Comparable 구현)
    String a = "hello";
    String b = "horld";

    // 두 문자열의 각 자리를 순차적으로 비교
    // 문자열의 비교는 유니코드 값의 차이를 반환
    System.out.println(a.compareTo(b)); // -10 출력. l과 r의 차이
  }

}
