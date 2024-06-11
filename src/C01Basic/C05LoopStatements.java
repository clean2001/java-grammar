package C01Basic;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class C05LoopStatements {
  public static void main(String[] args) {
//    int a = 2;
//    while(a <= 10) {
//      System.out.println(a++);
//    }

    // 입력한 숫자의 구구단 단수 출력
    // 3 * 1 = 3
    // 3 * 2 = 6

//    while(true) {
//      Scanner sc = new Scanner(System.in);
//      System.out.println("원하시는 단수를 입력해주세요.");
//      int input = sc.nextInt();
//      int num = 1;
//      while(num <= 9) {
//        System.out.println(input + " X " + num + " = " + num * input);
//        num++;
//      }
//    }

//    Scanner sc = new Scanner(System.in);
//    String answer = "1234";
//    // 도어락 키 예제
//    int cnt = 0;
//    while(true) {
//      String password = sc.nextLine();
//      if(answer.equals(password)) {
//        System.out.println("문이 열렸습니다.");
//        break;
//      } else {
//        System.out.println("비밀번호가 틀렸습니다.");
//        if(++cnt >= 5) {
//          System.out.println("입력 횟수를 초과했습니다.");
//          break;
//        }
//      }
//    }

//    Scanner sc = new Scanner(System.in);

//    int num = 1234;
//    int result = 0;
//    int tempNum = num;
//
//    while(tempNum > 0) {
//      result *= 10;
//      result += (tempNum % 10);
//      tempNum /= 10;
//    }
//
//    System.out.println("result = " + result);
//
//    // do-while 문: 무조건 한번은 실행되는 반복문이다.
//    // do-while문은 초기 입력 값을 검증하는데에 사용될 수 있다.
//    int a = 100;
//    do {
//      a++;
//      System.out.println(a);
//    } while(a < 10);
//
//    for(int i=2; i<=10; ++i) {
//      System.out.println("i: " + i);
//    }
//
//    // 1~10 중 홀수 출력하기
//    for(int i=1; i<=10; ++i) {
//      if (i % 2 == 1) {
//        System.out.println("홀수 : " + i);
//      }
//    }
//
//    // 1~20까지의 수 중에 짝수를 모두 더한 값
//    int sum = 0;
//    for(int i=1; i<=20; ++i) {
//      sum += (i % 2 == 0 ? i : 0);
//    }
//    System.out.println("짝수의 합: " + sum);


    // 최대 공약수 구하기
//    int a = 24, b = 36;
//    int minimum = a < b ? a : b;
//    int g;
//    for(g = minimum; g >= 1; g--) {
//      if(a % g == 0 && b % g == 0) {
//        break;
//      }
//    }
//    System.out.println("최대공약수: " + g);


    // 소수 구하기: 1과 자기 자신을 제외한 숫자로 나누어지지 않는 수
    boolean[] isComposite = new boolean[25];
    for(int i=2; i<=24; ++i) {
      for(int j=2; j<i; ++j) {
        if(i % j == 0) {
          isComposite[i] = true;
          break;
        }
      }
    }
//    for(int i=1; i<=24; ++i) {
//      if(!isComposite[i]) {
//        System.out.println(i);
//      }
//    }

//    for(int input=1; input<=24; input++) {
//
//    }
//
//
//    isComposite = new boolean[25];
//    // 에라토스테네스의 체
//    for(int num=2; num<=24; ++num) {
//      if(isComposite[num]) continue;
//
//      for(int i = num*2; i <= 24; i += num) {
//        isComposite[i] = true;
//      }


    // 기억할 것: 소수 구하기 할 때, 루트 씌운 값까지만 나눠보면 된다. -> 시간초과를 피하기 위함


    // 출력
//    for(int i = 2; i <= 24; ++i) {
//      if(!isComposite[i]) {
//        System.out.println(i);
//      }
//    }
//
//    // 1~10 중에 홀수만 출력하기
//    for(int i=1; i<=10; ++i) {
//      if(i%2==0) {
//        continue;
//      }
//
//      System.out.println(i);
//    }

    // 배열과 enhanced for문 (향상된 for문)
//    int[] arr = {1, 2, 3, 4, 5};
//
//    // 일반 포문
//    for(int i=0; i<5; ++i) {
//      System.out.println(arr[i]);
//    }
//
//    // 반복횟수는 arr에 들어가 있는 데이터 개수만큼 반복
//    // 주의: for each문은 값을 바꿀 수가 없음
//    for(int num : arr) {
//      System.out.println(num);
//    }

//    System.out.println(arr); // 메모리 주소가 출력됨
//    System.out.println(Arrays.toString(arr));
//
//    // 일반 포문으로 값 바꾸기
//    for(int i=0; i<5; ++i) {
//      arr[i] += 10;
//    }

    // 향상된 for문을 통한 arr 값 변경 후 출력
    //
//    for(int i : arr) {
//      i += 10;
//    }
//
//    System.out.println(Arrays.toString(arr));

    // 향상된 for문으로는 실제 arr의 값은 변경이 불가능하다.
//
//    int num = 10;
//    if(num > 1) {
//      int abc = 20;
//      num = 20;
//    }

    // abc = 30; -> 불가능하다!

    // 구구단 2~9단
//    for(int dan = 2; dan <=9; ++dan) {
//      System.out.println(dan + "단 입니다.");
//      for(int n = 1; n <=9; ++n) {
//        System.out.println(dan + " X " + n + " = " + dan * n);
//      }
//      System.out.println();
//    }


    // 라벨문
//    loop1:
//    for(int i=0; i<5; ++i) {
//      boolean test = false;
//
//      for(int j=0; j<5; ++j) {
//        System.out.println("Hello World");
//
//        if(j == 2) {
//          break loop1;
//        }
//      }
//    }

    // 라벨문을 활용해서 원하는 값찾기
    int[][] arr2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
    int target = 11;

    int len1 = arr2.length;
    int len2 = arr2[0].length;
    loop1:
    for(int i=0; i<len1; ++i) {
      for(int j=0; j<len2; ++j) {
        if(arr2[i][j] == target) {
          System.out.println("(" + i + ", " + j + ")에 " + target + "이 있습니다.");
          break loop1;
        }
      }

    }


  }
}
