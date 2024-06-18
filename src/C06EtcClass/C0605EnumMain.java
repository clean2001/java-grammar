package C06EtcClass;

public class C0605EnumMain {

  public static void main(String[] args) {
    EnumStudent s1 = new EnumStudent();
    s1.setName("hong1");
    s1.setClassGrade(ClassGrade.c1);


    EnumStudent s2 = new EnumStudent();
    s2.setName("hong2");
    // 여전히 타입이 String 타입이므로 임의 클래스 변수 사용하지 않을 수 있음
    s2.setClassGrade("secondgrade");

    // role의 경우 Enum 설정 시 위와 같은 실수를 방지 가능
    // 특정 타입을 지정함으로써, 실수 방지 가능
    s2.setRole(Role.GENERAL_USER);

    System.out.println(s2.getRole()); // GENERAL_USER
    System.out.println(s2.getRole().getClass()); // class C06EtcClass.Role
    // ordinal:
    // enum 값 내부에는 저장된 순서대로 0부터 index값이 내부적으로 할당
    System.out.println(s2.getRole().ordinal()); // 0
  }

  static class ClassGrade {
    static final String c1 = "first_grade";
    static final String c2 = "second_grade";
    static final String c3 = "third_grade";
  }

}

class EnumStudent {
  private String name;
  private String classGrade;
  private Role role;


  public String getName() {
    return name;
  }

  public String getClassGrade() {
    return classGrade;
  }

  public Role getRole() {
    return role;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setClassGrade(String classGrade) {
    this.classGrade = classGrade;
  }

  public void setRole(Role role) {
    this.role = role;
  }
}

enum Role {
  // 각 열거형 상수는 콤마로 구분하고, 상수 목록 끝에 세미콜론으로 마무리 짓는다.
  // static final이 생략돼있다고 생각하면 된다.
  GENERAL_USER, ADMIN_USER;
}
