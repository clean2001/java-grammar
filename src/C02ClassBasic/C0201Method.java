package C02ClassBasic;

public class C0201Method {
  public static void main(String[] args) {
    // for문을 이용해서 100~200까지 total 값 출력

    System.out.println(sumAcc(100, 200));

    // 기본 방식: 클래스명.메서드()
    System.out.println(C0201Method.sumAcc(100, 200));
    // 같은 클래스내에서의 클래스 메서드 호출은 클래스명 생략 가능.
  }

  // 함수명, 변수명은 대문자로 시작하지 않는다.
  // int라는 리턴 타입을 자김
  // input(매개변수 값을 int 2개로 정의)
  // 메서드 구성 요소: 매개변수, 리턴타입(void), 접근제어자(public), 클래스 메소드 여부(static 붙어있으면 클래스 메서드)
  public static int sumAcc(int start, int end) {
    int total = 0;
    for(int i=start; i<=end; ++i) {
      total += i;
    }

    return total; // 함수를 호출한 쪽에 값을 되돌려줌
  }


}
