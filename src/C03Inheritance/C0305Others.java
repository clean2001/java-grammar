package C03Inheritance;


public class C0305Others {

  public static void main(String[] args) {
    AbstractAnimal dog1 = new AbstractDog(); // 이건 됨
//    AbstractAnimal dog2 = new AbstractAnimal(); // 이건 안됨
    // 추상 클래스와 인터페이스는 구현 없이 객체 생성 불가
    AbstractAnimal dog2 = new AbstractAnimal() {
      @Override
      void makeSound3() {

      }
    }; // 익명 객체: 상속 관계가 없는데 동시에 구현하면 객체 만듦
    dog1.makeSound1();
    dog1.makeSound2();
  }

}

// final을 클래스에 붙이면 상속 불가능한 클래스가 생성된다.
final class FinalParents {

}

// abstract: 추상 클래스를 가지고 객체를 만들 수는 없다.
abstract class AbstractAnimal {
  void makeSound1() {
    System.out.println("동물 소리를 냅니다. 1");
  }

  // 메소드 앞에 final이 붙으면 Overriding 불가
  final void makeSound2() {
    System.out.println("동물 소리를 냅니다. 2");
  }

  // 리턴 타입과 매개변수만 정의돼있다.
  abstract void makeSound3();

}

class AbstractDog extends AbstractAnimal {
  // abstract 키워드는 자식클래스로 하여금 오버라이딩 강제
  @Override
  void makeSound3() {
    System.out.println("멍멍3");
  }

//  @Override
//  void makeSound2() {
//    System.out.println("멍멍!");
//  }


}




