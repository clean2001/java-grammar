package C03Inheritance;

public class C0304ProtectedTest {
  public static void main(String[] args) {
    C0304ProtectedClass pc = new C0304ProtectedClass();

    // public 접근 가능
    System.out.println(pc.st4);

    // private은 변수 접근 불가능
//    System.out.println(pc.st1);
    System.out.println(pc.st3); // default 변수 접근 가능: 같은 패키지 내에서 접근 가능
    System.out.println(pc.st2); // protected 변수 접근 가능

    //

  }

}
