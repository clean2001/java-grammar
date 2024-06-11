package C01Basic;


public class C07Array {

  public static void main(String[] args) {
//    // 배열 표현식1: 리터럴 방식
//    int[] intArr1 = {1, 2, 3, 4, 5};
//
//    // 배열 표현식 2: 배열 선언 후 할당 방식
//    int[] intArr2 = new int[5];
//    intArr2[0] = 1;
//    intArr2[1] = 2;
//    intArr2[2] = 3;
//    intArr2[3] = 4;
//    System.out.println(intArr2[4]);
//
//    for(int i=0; i<intArr2.length; i++) {
//      System.out.println(intArr2[i]);
//    }
//
//    for (int i : intArr2) {
//      System.out.println(i);
//    }
//
//    //== 표현식 3 ==//
//    int[] intArr3 = new int[]{1, 2, 3, 4};
//    test(new int[]{1, 2, 3, 4});
//
//
//    //== 표현식 4 => 배열의 길이는 사전에 지정돼야함 ==//
////    int[] intArr4 = new int[]; -> 이거 안됨
//    String[] stArr = new String[5];
//    stArr[0] = "hello";
//    stArr[1] = "java";
//
//    // NullPointerException =>
////    System.out.println(stArr[2].length());
//
//    // 배열에 값 한꺼번에 세팅
//    String[] stArr2 = new String[5];
//    Arrays.fill(stArr2, "java");
//
//    // 보통 아래와 같이 쓴다.
//    Arrays.fill(stArr2, ""); // => 코테 풀 때 유용할 것 같다.
//
//
//    //== 예제: 85, 65, 90인 int 배열을 선언하고 총합, 평균을 for문을 이용해서 구하기==//
//    int[] testArr = new int[]{85, 65, 90};
//    int sum = 0;
//    for (int n : testArr) {
//      sum += n;
//    }
//    double avg = (double)sum / testArr.length;
//    System.out.println("sum: " + sum);
//    System.out.println("avg: " + avg);

//    //== 최대값과 최소값 구하기 ==//
//    int[] arr = {10, 20, 30, 12, 8, 17};
//    int maxVal = arr[0], minVal = arr[0];
//    for(int i=1; i<arr.length; ++i) {
//      if(maxVal < arr[i]) maxVal = arr[i];
//      if(minVal > arr[i]) minVal = arr[i];
//    }
//
//    System.out.println("max: " + maxVal + " | " + "min: " + minVal);
//
//    // int 범위에서 가장 작은 값
//    int max = Integer.MIN_VALUE;

//    // 배열의 순서 바꾸기
//    int[] arr = {10, 20};
//    int temp = arr[0];
//    arr[0] = arr[1];
//    arr[1] = temp;
//
//    int[] arr2 = {10, 20, 30, 40, 50};
//    // 0번째 index부터 마지막 Index까지 순차적으로 자리 체인지
//    int len = arr2.length;
//    for(int i=0; i<len-1; ++i) {
//      int temp2 = arr2[i];
//      arr2[i] = arr2[i+1];
//      arr2[i+1] = temp2;
//    }
//    System.out.println(Arrays.toString(arr2));

//    // 배열 뒤집기
//    int[] arr = {1, 2, 3, 4, 5};
//    // 새로운 배열에 위 arr을 뒤집은 값 세팅
//    int len = arr.length;
//    int[] newArr = new int[len];
//    for(int i=0; i<len; ++i) {
//      newArr[i] = arr[len - i - 1];
//    }
//    System.out.println("뒤집은 배열: " + Arrays.toString(newArr));

//    //== 숫자 뒤집기 ==//
//    int num = 1234;
//    //== 방법 1 ==//
//
//    String[] sArr = Integer.toString(num).split("");
//    StringBuilder sb = new StringBuilder();
//    int len = sArr.length;
//    for(int i=0; i<len; ++i) {
//      sb.append(sArr[len - 1 - i]);
//    }
//    System.out.println("뒤집은 숫자: " + sb);
//
//    //== 방법 2 ==//
//    StringBuilder sb2 = new StringBuilder(Integer.toString(num));
//    System.out.println("뒤집은 숫자 2: " + sb2.reverse());

    //== 정렬. 직접 구현도 해보자. ==//
    // 1. 선택 정렬
//    int[] arr = {5, 1, 2, 7, 3, 1, 2};
//    Arrays.sort(arr); // 오름차순 정렬이 기본이다.
//    System.out.println(Arrays.toString(arr));
//
//    // 문자열 정렬
//    // 아스키 코드 기준으로 정렬 => 대문자가 소문자보다 아스키코드 숫자가 낮다.
//    String[] fruits = {"banana", "apple", "cherry", "Apple"};
//    Arrays.sort(fruits);
//    System.out.println(Arrays.toString(fruits));

//    // 문자열의 index 순서로 비교한다.
//    String[] fruits2 = {"apple1", "apple11", "apple2"};
//    Arrays.sort(fruits2);
//    System.out.println(Arrays.toString(fruits2));
//
//    // 2. 버블 정렬
//
//    // 내림차순
//    String[] stArr = {"hello", "hi", "bye", "good morning"};
//    Arrays.sort(stArr, Comparator.reverseOrder());
//
//    // 기본형 타입은 Comparator로 처리 불가능
//    int[] intArr = {5, 1, 2, 7, 3, 1, 2};
//    // Comparator 자체가 참조형 자료만 처리할 수 있도록 설계돼있음!
////    Arrays.sort(intArr, Comparator.reverseOrder()); // error!
//    Arrays.sort(intArr); // 방법 1. 역순 정렬하고 싶다면 일단 정렬하고 다시 뒤집자.
//
//    // 방법 2. stream api와 lambda를 활용한 내림차순 정렬
//    int[] answer = Arrays.stream(intArr) // intArr을 대상으로 stream 객체 생성. stream이라는 것은 int 배열의 복사본이라고 보면 된다.
//        .boxed() // int 요소를 Integer로 형변환 시키는 메소드
//        .sorted(Comparator.reverseOrder())
//        .mapToInt(a -> a) // Integer를 다시 int로 형변환
//        .toArray(); // 배열로 변환

//
//    int[] ans = new int[intArr.length];
//    for(int i = 0; i < answer.length; i++) {
//      ans[i] = intArr[i];
//    }

    // 초기값 없이 배열의 변수를 만들면, 배열의 타입에 맞게 자동으로 초기화
    // String: null,

    // 나중에 힙 정렬 배울 것임.

    //== 숫자 조합의 합 ==//
//    int[] intArr = {10, 20, 30, 40, 50, 60};
//    int idx = 1;
//    for(int i=0; i<intArr.length; ++i) {
//      for(int j=i+1; j<intArr.length; ++j) {
//        System.out.println((idx++) + ". " + intArr[i] + " + " + intArr[j] + " = " + (intArr[i] + intArr[j]));
//      }
//    }

    //== 배열의 복사: copyOf(배열, length), copyOfRange(배열, start, end) ==//
//    int[] arr = {10, 20, 30, 40, 50};
//    int[] newArr = Arrays.copyOf(arr, 3); // start는 무조건 0이다!
//    System.out.println(Arrays.toString(newArr));
//    int[] newArr2 = Arrays.copyOfRange(arr, 1, 4); // end index는 포함하지 않음
//    System.out.println(Arrays.toString(newArr2));
//
//
//    //== 배열의 중복 제거 ==//
//    int[] temp = {10, 10, 5, 7, 40, 40, 10, 10};
//    Arrays.sort(temp);
//    int[] newArr3 = new int[temp.length];
//    int idx = -1;
//    for(int a : temp) {
//      if(idx == -1 || newArr3[idx] != a) { // 첫 원소이거나
//        newArr3[++idx] = a;
//      }
//    }
//    int[] result = Arrays.copyOf(newArr3, idx+1);
//    System.out.println(Arrays.toString(result));

    //== 배열의 검색 ==//

    // 배열의 검색
//    int[] arr_ = {5, 3, 1, 8, 7};
//    int target = 8;
//    int i=0;
//    for(i=0; i<arr_.length; ++i) {
//      if(target == arr_[i]) break;
//    }
//    System.out.println(i);
//  }

    //== 이진 검색(Binary Search) ==//
    // 시간복잡도: O(logn)
//    int[] arr = {1, 3, 4, 5, 7, 8, 10, 15};
//    // 사전에 오름차순 정렬이 되어있어야 이진검색 가능
//    System.out.println(Arrays.binarySearch(arr, 15));
//
//
//    //== 배열간 비교 ==//
//    int[] arr1 = {10, 20, 30};
//    int[] arr2 = {10, 20, 30};
//    System.out.println(arr1==arr2); // false
//
//    // Arrays.equals : 값과 순서까지 동일해야 true이다.
//    System.out.println(Arrays.equals(arr1, arr2)); // true


//    //== 2차원 배열. 선언과 할당 ==//
//    int[][] arr = new int[2][3];
//    // 리터럴 방식으로 할당
//    int[][] arr2 = {{1, 2, 3}, {4, 5, 6}};
//    // {{1, 2, 3}, {4, 5, 6}}
//
//    // 2차원 배열의 출력
//    // 중요!! deepToString(arr);
//    System.out.println(Arrays.deepToString(arr2));

    // 2차원 가변 배열 선언 후 할당
    // 가변 배열: 리터럴 방식
//    int[][] arr3 = {{1, 2, 3}, {4, 5, 6}};
//    int[][] arr = new int[2][];
//    arr[0] = new int[3];
//    arr[1] = new int[4];
//    // 여기다 값 세팅하면 된다.
//
//    // 가변 배열 리터럴 방식
//    int[][] arr2 = {{1, 2}, {3, 4, 5}};
//
//    // [3][4] size 배열을 선언한 뒤
//    // 1 ~ 12까지 숫자값 각 배열에 할당 후 출력
//    int[][] arr4 = new int[3][4];
//    for(int i=0; i<arr4.length; ++i) {
//      for(int j=0; j<arr4[0].length; ++j) {
//        arr4[i][j] = i * (arr4[0].length) + (j + 1);
//      }
//    }
//
//    System.out.println(Arrays.deepToString(arr4));

    //== 가변 배열 실습. 행의 길이(전체 배열의 길이): 5 => {{10}, {20, 20}, {30, 30, 30}, {40, 40, 40, 40}} ==//
    // 50까지. for문으로 만들기
//    int[][] arr = new int[5][];
//    for(int i=0; i<5; ++i) {
//      arr[i] = new int[i+1];
//      for(int j=0; j<i+1; ++j) {
//        arr[i][j] = (i+1) * 10;
//      }
//    }
//
//    System.out.println(Arrays.deepToString(arr));

    //
  }
}
