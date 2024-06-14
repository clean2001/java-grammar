package C04Interface;

public class InterfaceMain {
  public static void main(String[] args) {
    CatImplements cat1 = new CatImplements();
    cat1.makeSound();
    DogImplements dog1 = new DogImplements();
    dog1.makeSound();

    //
    AnimalInterface1 cat2 = new CatImplements();
    cat2.makeSound();
    AnimalInterface1 dog2 = new DogImplements();
    dog2.makeSound();
    // 다형성: 하나의 객체가 여러 개의 참조 변수를 가질 수 있음을 의미

    CatMultiImplements cat3 = new CatMultiImplements(); // CatMultiImplements에 정의된 기능을 다 쓸 수 있다.
    cat3.makeSound();
    System.out.println(cat3.play("러시안블루", "먼치킨"));


    AnimalInterface1 cat4 = new CatMultiImplements(); // AnimalInterface1에 정의된 기능만 쓸 수 있다.
    AnimalInterface2 cat5 = new CatMultiImplements(); // AnimalInterface2에 정의된 기능만 쓸 수 있다.

    //==  ==//
    // 중요 !!: 기본적으로 추상클래스, 인터페이스는 객체 생성이 불가능 하나, 익명 내부클래스 방식으로 생성 가능하다.
    // 익명 클래스(익명 내부 클래스)가 만들어졌고, 그 익명 클래스의 객체가 만들어짐 (익명 객체)
    AnimalInterface1 ai1 = new AnimalInterface1() {
      @Override
      public void makeSound() {
        System.out.println("hello");
      }
    };

    ai1.makeSound();

    //==  ==//
  }

}
