package C02ClassBasic;

public class C0206RecursiveBasic {
    public static void main(String[] args) {
        System.out.println(sumWithRecursion(10));

        System.out.println(fibonacciWithRecursion(6));
        System.out.println(fibonacciWithForLoop(6));
    }

    private int sumWithForLoop(int num) {
        int total = 0;
        for(int i=1; i<=num; ++i) {
            total += i;
        }
        return total;
    }

    private static int sumWithRecursion(int cur) {
        if(cur == 0) return 0;
        return cur + sumWithRecursion(cur-1);
    }

    // 피보나치 수열(재귀) => 문제점: 중복 연산
    private static int fibonacciWithRecursion(int cur) {
        if(cur == 1 || cur == 2) return 1;
        return fibonacciWithRecursion(cur-1) + fibonacciWithRecursion(cur-2);
    }

    // 피보나치 수열 -> for loop : 효율적이다.
    private static int fibonacciWithForLoop(int limit) {
        int first = 1;
        int second = 1;
        for(int i=2; i<limit; ++i) {
            int temp = first;
            first = second;
            second = temp + second;

        }

        return second;
    }
}
