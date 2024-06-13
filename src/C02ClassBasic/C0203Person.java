package C02ClassBasic;

public class C0203Person {
  private String name;
  private String email;
  private int age;

  // 인스턴스 메소드
  public void eating() {
    System.out.println(this.name + "이 밥을 먹는다.");
  }


  // setter
  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public int getAge() {
    return age;
  }

  // getter
  public String getName() {
    return this.name;
  }


  public void setEmail(String email) {
    this.email = email;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
