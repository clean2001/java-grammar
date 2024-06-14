package C04Interface;

public class DogImplements implements AnimalInterface1 {

  @Override
  public void makeSound() {
    System.out.println("멍멍");
  }
}


class DogMultiImplements implements AnimalInterface1, AnimalInterface2 {

  @Override
  public void makeSound() {
    System.out.println("멍멍멍멍멍멍멍멍");
  }

  @Override
  public String play(String a, String b) {
    return a + "와 " + b + "가 같이 뛰어놉니다.";
  }
}
