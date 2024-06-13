package C01Basic;

// 몇번 반복해야 stack overflow 나냐..

// 실무에서 stack overflow는 엄청 크리티컬한 문제이다.
// 그래서 실무에서는 웬만하면 쓰지 않는다.
public class C1102StackFunction2 {
    public static void main(String[] args) {
        System.out.println("main 함수 시작");
        function1(1);
        System.out.println("main 함수 끝");
    }

    private static int function1(int a) {
        System.out.println("function1 시작: " + a);

        System.out.println("function1 끝");
        return function1(a+1);
    }
}
