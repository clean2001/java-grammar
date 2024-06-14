package mypkg;

public interface Test1 {
  default void testMethod1() {
    System.out.println("과연 뭐가 나올까 111");
  }

  default void testMethod2() {
    System.out.println("과연 뭐가 나올까");
  }

}
