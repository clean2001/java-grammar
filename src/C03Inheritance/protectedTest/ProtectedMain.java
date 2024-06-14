// 루트(최상단) 패키지는 src -> 패키지 명시를 해줄 필요가 없다.
package C03Inheritance.protectedTest;

// import에 대한 룰
// * 을 통해 패키지 내에 모든 클래스 import 가능
// 하지만 *을 통해 패키지 내에 패키지까지 포함해서 모든 내용 import는 불가능
// 즉,
import C03Inheritance.C0304ProtectedClass;
//import java.*; // => 이거는 불가능하다.

public class ProtectedMain extends C0304ProtectedClass {
  public static void main(String[] args) {
    C0304ProtectedClass c1 = new C0304ProtectedClass();
//    System.out.println(c1.st3); // protected 접근 불가
//    System.out.println(c1.st2); // default 접근 불가

    ProtectedMain p1 = new ProtectedMain();
    // default 접근 불가
//    System.out.println(p1.st2);
    System.out.println(p1.st3); // 상속한 객체에서 protected 접근 가능
  }
}
