package C03Inheritance;

// 클래스에는 public과 default만 있다.
// public: 프로젝트 전체에서 접근 가능
// protected: 패키지를 벗어나더라도 상속 관계인 경우는 접근 가능
// default: 패키지 내에서만 접근 가능
// private: 클래스 내에서만 접근 가능

// default 클래스에서
public class C0304ProtectedClass {
  private String st1 = "hello java1";
  String  st2 = "hello java2";
  protected String st3 = "hello java3";
  public String st4 = "hello java4"; // 프로젝트 전체에서 접근 가능


}
